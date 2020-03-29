package com.yxw.tank;                                                                                                   
                                                                                                                        
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
                                                                                     
                                                                                                                        
public class TankFrame extends Frame {                                                                                                                                                                               
	                                                                                                                    
	Tank myTank = new Tank(200, 200, Dir.DOWN, this);   
	List<Bullet> bullets = new ArrayList<>();
	
	Bullet b = new Bullet(200, 200, Dir.DOWN, this);
	static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
	
	public TankFrame() {                                                                                                
		setSize(GAME_WIDTH, GAME_HEIGHT);                                                                                              
		setTitle("test project");                                                                                       
		setVisible(true);                                                                                               
		                                                                                                                
		this.addKeyListener(new MyKeyListener());                                                                       
		addWindowListener(new WindowAdapter() {                                                                         
			                                                                                                            
			@Override                                                                                                   
			public void windowClosing(WindowEvent e) {                                                                  
				System.exit(-1);                                                                                        
			}                                                                                                           
		});                                                                                                             
	}                                                                                                                   
	
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT) ;
		}
		
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override                                                                                                           
	public void paint(Graphics g) {   
		
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("�ӵ�������" + bullets.size(), 10, 60);
		g.setColor(c);
		
		myTank.paint(g);                                                                                                
//	    b.paint(g);                                                                                                                                                                                                                                
		for (int i=0; i<bullets.size(); i++) {
			bullets.get(i).paint(g);
		}
//		for (Iterator<Bullet> it = bullers.iterator(); it.hasNext();) {
//			Bullet b = it.next();
//			if (!b.live) it.remove();
//		}
		
	}                                                                                                                   
	                                                                                                                    
	class MyKeyListener extends KeyAdapter {                                                                            
		                                                                                                                
		boolean bL = false;                                                                                             
		boolean bR = false;                                                                                             
		boolean bU = false;                                                                                             
		boolean bD = false;                                                                                             
		                                                                                                                
		@Override                                                                                                       
		public void keyPressed(KeyEvent e) {                                                                            
			                                                                                                            
			int key = e.getKeyCode();                                                                                   
			System.out.println(key);                                                                                    
			switch (key) {                                                                                              
				case KeyEvent.VK_LEFT:                                                                                  
					bL = true;                                                                                          
					break;                                                                                              
				                                                                                                        
				case KeyEvent.VK_UP:                                                                                    
					bU = true;                                                                                          
					break;                                                                                              
					                                                                                                    
				case KeyEvent.VK_RIGHT:                                                                                 
					bR = true;                                                                                          
					break;                                                                                              
					                                                                                                    
				case KeyEvent.VK_DOWN:                                                                                  
					bD = true;                                                                                          
					break;                                                                                              
					                                                                                                    
				default:                                                                                                
					break;                                                                                              
			}                                                                                                           
			                                                                                                            
			setMainTankDir();                                                                                           
		}                                                                                                               
                                                                                                                        
		@Override                                                                                                       
		public void keyReleased(KeyEvent e) {                                                                           
			int key = e.getKeyCode();                                                                                   
			switch (key) {                                                                                              
				case KeyEvent.VK_LEFT:                                                                                  
					bL = false;                                                                                         
					break;                                                                                              
					                                                                                                    
				case KeyEvent.VK_UP:                                                                                    
					bU = false;                                                                                         
					break;                                                                                              
					                                                                                                    
				case KeyEvent.VK_RIGHT:                                                                                 
					bR = false;                                                                                         
					break;                                                                                              
					                                                                                                    
				case KeyEvent.VK_DOWN:                                                                                  
					bD = false;                                                                                         
					break;                                                                                              
					              
				case KeyEvent.VK_CONTROL:
					myTank.fire();
					break;
					
				default:                                                                                                
					break;                                                                                              
			}                                                                                                           
			                                                                                                            
			setMainTankDir();                                                                                           
		}                                                                                                               
                                                                                                                        
		private void setMainTankDir() {  
			
			if (!bL && !bU && !bR && !bD) {
				myTank.setMoving(false);
			} else {
				myTank.setMoving(true);
				
				if (bL)	myTank.setDir(Dir.LEFT);                                                                                     
				if (bU) myTank.setDir(Dir.UP);                                                                                       
				if (bR) myTank.setDir(Dir.RIGHT);                                                                                    
				if (bD) myTank.setDir(Dir.DOWN);                                                                                     
			}
		}                                                                                                               
	                                                                                                                    
	}                                                                                                                   
	                                                                                                                    
}                                                                                                                       
                                                                                                                        