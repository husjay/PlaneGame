package com.hsjay.plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import com.hsjay.util.GameUtil;

public class Plane extends GameObject{

	boolean left, up, right, down;
	boolean live = true;
	
	public Plane() {
		
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Plane(String planepath, double x, double y) {
		super();
		this.plane = GameUtil.getImage(planepath);
		this.x = x;
		this.y = y;
		this.wight = plane.getWidth(null);
		this.height = plane.getHeight(null);
		this.speed = 20;
		//System.out.println(wight+"--"+height);
	}

	public void draw(Graphics g) {
		if(isLive()) {
			g.drawImage(plane, (int)x - plane.getWidth(null) / 2, (int)y - plane.getHeight(null) / 2, null);
			move();
		}
	}
	
	public void move() {
		if(left) {
			x -= speed;
		}
		if(right) {
			x += speed;
		}
		if(up) {
			y -= speed;
		}
		if(down) {
			y += speed;
		}
	}
	
	public void direction(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 37:
			left = true;
			break;
		case 38:
			up = true;
			break;
		case 39:
			right = true;
			break;
		case 40:
			down = true;
			break;
		default:
			break;
		}
	}
	public void stop(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 37:
			left = false;
			break;
		case 38:
			up = false;
			break;
		case 39:
			right = false;
			break;
		case 40:
			down = false;
			break;
		default:
			break;
		}
	}
	
}
