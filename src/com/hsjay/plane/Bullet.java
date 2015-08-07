package com.hsjay.plane;

import java.awt.Color;
import java.awt.Graphics;
import com.hsjay.util.Constant;

public class Bullet extends GameObject{
	
	double degree;

	public Bullet() {
		degree = Math.random() * Math.PI;
		x = Constant.GAME_WIDTH / 2;
		//y = Constant.GAME_HEIGHT / 2 - 50;
		y = 30;
		wight = 10;
		height = 10;
	}
	
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, wight, height);
		
		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);
		
		if(x < 0 || x > Constant.GAME_WIDTH - wight) {
			degree = Math.PI - degree;
		}
		if(y < 30 || y > Constant.GAME_HEIGHT - height) {
			degree = - degree;
		}
		
		g.setColor(oldColor);
	}
	
}

