package com.yxw.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	
	private static final int SPEED = 10;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	
	private int x, y;
	private Dir dir;
	
	TankFrame f = null;
	private boolean live = true;
	public Bullet(int x, int y, Dir dir, TankFrame f) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.f = f;
	}
	
	public void paint(Graphics g) {                                                                                                                                                                                    
        
		if (!live) {
			f.bullets.remove(this);
		}
//		Color c = g.getColor();
//		g.setColor(Color.RED);
//		g.fillRect(x, y, WIDTH, HEIGHT);                                                                                       
//        g.setColor(c);
//		move();
		switch (dir) {
			case LEFT:
				g.drawImage(ResourceMgr.bulletL, x, y, null);
				break;
				
			case UP:
				g.drawImage(ResourceMgr.bulletU, x, y, null);
				break;
				
			case RIGHT:
				g.drawImage(ResourceMgr.bulletR, x, y, null);
				break;	
				
			case DOWN:
				g.drawImage(ResourceMgr.bulletD, x, y, null);
				break;	
		}                                                                                  
         move();                                                                                                               
	}
	private void move() {
		
		// TODO Auto-generated method stub
		switch (dir) {                                                                                                  
		case LEFT:                                                                                                  
			x -= SPEED;                                                                                             
			break;                                                                                                  
			                                                                                                        
		case UP:                                                                                                    
			y -= SPEED;                                                                                             
			break;                                                                                                  
		                                                                                                            
		case RIGHT:                                                                                                 
			x += SPEED;                                                                                             
			break;                                                                                                  
		                                                                                                            
		case DOWN:                                                                                                  
			y += SPEED;                                                                                             
			break;                                                                                                  
		                                                                                                            
//		default:                                                                                                    
//			break;              
		}                       
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			live = false;
		}
	}             
}
