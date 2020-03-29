package com.yxw.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	
	private int x, y;
	private Dir dir = Dir.DOWN;
	private static final int SPEED = 10;
	
	public static int WIDTH = ResourceMgr.tankD.getWidth();
	public static int HEIGHT = ResourceMgr.tankD.getWidth();
	
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
		
//		Color c = g.getColor();
//		g.setColor(Color.YELLOW);
//		g.fillRect(x, y, 50, 50);                                                                                         
//		move();
		
		//this is another method
		switch (dir) {
			case LEFT:
				g.drawImage(ResourceMgr.tankL, x, y, null);
				break;
				
			case UP:
				g.drawImage(ResourceMgr.tankU, x, y, null);
				break;
				
			case RIGHT:
				g.drawImage(ResourceMgr.tankR, x, y, null);
				break;	
				
			case DOWN:
				g.drawImage(ResourceMgr.tankD, x, y, null);
				break;	
		}
		
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
		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		f.bullets.add(new Bullet(bX, bY, this.dir, f));
	} 
}
