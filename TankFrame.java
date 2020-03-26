package com.yxw.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	int x = 200, y = 200;
	
	public TankFrame() {
		setSize(800, 600);
		setTitle("Tank war");
		setVisible(true);
		
		this.addKeyListener(new MyKeyListener());
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("paint");
		g.fillRect(x, y, 50, 50);
//		x += 20;
	}
	
	class MyKeyListener extends KeyAdapter {
		
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
				
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
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
				
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
		}
		
	}
}
