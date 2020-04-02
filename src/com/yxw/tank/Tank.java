package com.yxw.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank {
	
	private int x, y;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	private Dir dir = Dir.DOWN;
	private static final int SPEED = 5;
	
	public static int WIDTH = ResourceMgr.goodTankD.getWidth();
	public static int HEIGHT = ResourceMgr.goodTankD.getWidth();
	
	private boolean living = true;
	
	Rectangle rect = new Rectangle();
	
	private boolean moving = true;
	
	private Group group = Group.BAD;
	private TankFrame f  = null;
	private Explode e = null;
	
	private Random random = new Random();
	
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
	
	public Tank(int x, int y, Dir dir, Group group, TankFrame f) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.f = f;
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
	}
	                                                                                                        
	public void paint(Graphics g) {                                                                                                                                                                                    
		
//		Color c = g.getColor();
//		g.setColor(Color.YELLOW);
//		g.fillRect(x, y, 50, 50);                                                                                         
//		move();
		
		//need remove himself
		if (!living) f.tanks.remove(this);
		//this is another method
		switch (dir) {
			case LEFT:
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL:  ResourceMgr.badTankL, x, y, null);
				break;
				
			case UP:
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU:  ResourceMgr.badTankU, x, y, null);
				break;
				
			case RIGHT:
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR:  ResourceMgr.badTankR, x, y, null);
				break;	
				
			case DOWN:
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD:  ResourceMgr.badTankD, x, y, null);
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
		
		rect.x = this.x;
		rect.y = this.y;
		
		if (this.group == Group.BAD && random.nextInt(100) > 80) {
			this.fire();
		}
		if (this.group == Group.BAD && random.nextInt(100) > 90) randomDir();
		
		boundCheck();
	}
	
	//±ß½ç¼ì²â
	private void boundCheck() {
		if (this.x < 0 ) x = 0;
		if (this.y < 28) y = 28;
		if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH;
		if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
		
	}

	private void randomDir() {
		
		this.dir = Dir.values()[random.nextInt(4)];
		
	}

	public void fire() {
//		f.b	= new Bullet(this.x, this.y, this.dir);
		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		f.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.f));
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void die() {
		this.living = false;
		f.explodes.add(new Explode(x, y, f));
//		new Explode(this.x, this.y, f);
	} 
}
