package com.yxw.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	
	private static final int SPEED = 30;
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	
	Rectangle rect = new Rectangle();
	
	private int x, y;
	private Dir dir;
	
	private Group group = Group.BAD;
	TankFrame f = null;
	private boolean living = true;
	
	public Bullet(int x, int y, Dir dir, Group group, TankFrame f) {
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
        
		if (!living) {
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
		
		rect.x = this.x;
		rect.y = this.y;
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			living = false;
		}
	}

	public void collideWith(Tank tank) {
		
		if (this.group == tank.getGroup()) return;
		
		// todo: new ����̫�� ��һ��rect ����¼�ӵ���λ��
//		Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
//		Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
//		if (rect1.intersects(rect2)) {
		if (rect.intersects(tank.rect)) {
			tank.die();
			this.die();
		}
	}

	private void die() {
		// TODO Auto-generated method stub
		this.living = false;
	}             
}
