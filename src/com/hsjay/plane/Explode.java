package com.hsjay.plane;

import java.awt.Graphics;
import java.awt.Image;

import com.hsjay.util.GameUtil;

/**
 * 爆炸效果
 * @author hsj
 *
 */
public class Explode {
	double x, y;
	static Image[] imgs = new Image[16];
	int count;
	
	static {
		for(int i=0; i<16; i++) {
			imgs[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");
			imgs[i].getWidth(null);
		}
	}
	
	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		if(count <= 15){
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
}
