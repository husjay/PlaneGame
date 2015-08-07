package com.hsjay.plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	Image plane;
	double x, y;
	int wight, height;
	double speed = 8;
	
	public GameObject() {
		
	}
	
	public GameObject(Image plane, double x, double y, int wight, int height,
			double speed) {
		super();
		this.plane = plane;
		this.x = x;
		this.y = y;
		this.wight = wight;
		this.height = height;
		this.speed = speed;
	}

	public Rectangle getRect() {
		Rectangle r = new Rectangle((int)x, (int)y, wight, height);
		return r;
	}
}
