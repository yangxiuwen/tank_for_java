package com.yxw.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	
	private int x, y;
	private Dir dir = Dir.DOWN;
	private static final int SPEED = 10;
	
	private boolean moving = false;
	
	private TankFrame f  = null;
	
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}
	
	public Tank(int x, int y, Dir dir, TankFrame f) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.f = f;
	}
	                                                                                                        
	public void paint(Graphics g) {                                                                                                                                                                                    
		
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 50, 50);                                                                                       
        
		move();
		                                                                                  
                                                                                                                        
	}

	private void move() {
		
		if (!moving) return;
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
		
	}

	public void fire() {
//		f.b	= new Bullet(this.x, this.y, this.dir);
		f.bullets.add(new Bullet(this.x, this.y, this.dir, f));
	} 
}
