package com.hsjay.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.hsjay.util.Constant;
import com.hsjay.util.GameUtil;
import com.hsjay.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	/**
	 * 
	 */
	String str = "GAME OVER";
	private static final long serialVersionUID = 1L;
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane plane = new Plane("images/plane.png", Constant.GAME_WIDTH / 2, Constant.GAME_HEIGHT / 2);
	
	ArrayList bulletList = new ArrayList();
	Date startTime, endTime;
	Explode explode = null;
	
	public static void main(String[] args) {
		PlaneGameFrame pf = new PlaneGameFrame();
		pf.launchFrame();
	}
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		plane.draw(g);
		
		//画子弹
		for(int i=0; i<bulletList.size(); i++) {
			Bullet b = (Bullet) bulletList.get(i);
			b.draw(g);
			
			//监测是否和飞机碰撞
			if(plane.isLive()) {
				boolean p = b.getRect().intersects(plane.getRect());
				if(p) {
					plane.setLive(false);	//飞机死了
					endTime = new Date();
					if(explode == null) {
						explode = new Explode(100, 100);
					}
					explode.draw(g);
				}
			}
			//System.out.println(plane.wight+"--"+plane.height);
		}
		if(!plane.isLive()) {
			printInfo(g, str, 50, Color.RED, 150, Constant.GAME_HEIGHT / 2);
			int liveTime =(int)((endTime.getTime() - startTime.getTime()) / 1000);
			
			switch(liveTime / 10) {
			case 0:
				printInfo(g, "鸟蛋", 50, Color.white, 250, 360);
				break;
			case 1:
				printInfo(g, "菜鸟", 50, Color.white, 250, 360);
				break;
			case 2:
				printInfo(g, "小鸟", 50, Color.white, 250, 360);
				break;
			case 3:
				printInfo(g, "大鸟", 50, Color.white, 250, 360);
				break;
			case 4:
				printInfo(g, "鸟王子", 50, Color.white, 250, 360);
				break;
			default:
				printInfo(g, "鸟人", 50, Color.white, 250, 360);
				break;
			}
			printInfo(g, "Time:"+liveTime+"s", 30, Color.blue, 240, 400);
		}
		printInfo(g, "Score: 10", 10, Color.WHITE, 30, 50);
		Date nowTime = new Date();
		long time = 0;
		if(plane.isLive()) {
			time = (nowTime.getTime() - startTime.getTime()) / 1000;
		}
		printInfo(g, "Time:"+time+"s", 10, Color.white, 30, 60);
	}
	
	public void printInfo(Graphics g, String info, int size, Color color, int x, int y) {
		
		Color oldColor = g.getColor();
		Font oldFont = g.getFont();
		g.setColor(color);
		Font f = new Font("宋体", Font.BOLD, size);
		g.setFont(f);
		g.drawString(info, x, y);
		g.setColor(oldColor);
		g.setFont(oldFont);
	}
	
	public void launchFrame(){
		super.launchFrame();
		
		//增加键盘监听
		addKeyListener(new KeyMonitor()); 
		
		//生成子弹
		for(int i=0; i<20; i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();
	}
	
	//定义内部类可以方便的使用外部类的属性和方法
	//定义后要注册才能使用
	class KeyMonitor extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			//System.out.println("press " + e.getKeyCode());
			plane.direction(e);
		}

		public void keyReleased(KeyEvent e) {
			//System.out.println("release " + e.getKeyCode());
			plane.stop(e); 
		}
		
	}
	
}
