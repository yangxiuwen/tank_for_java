package com.yxw.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Explode {
	
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	
	private int x, y;
	
	TankFrame f = null;
//	private boolean living = true;
	
	private int step = 0;
	public Explode(int x, int y, TankFrame f) {
		this.x = x;
		this.y = y;
		this.f = f;
		
//		new Audio("").start();
	}
	
	public void paint(Graphics g) {                                                                                                                                                                                    
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        //这里需要做个改变   坦克的数量默认等于爆炸的数据  当爆炸小于等于坦克数量的时候就是移除 
//        if (step >= ResourceMgr.explodes.length && ResourceMgr.explodes.length < 5) {
        if (step <= 5) {
        	f.explodes.remove(this);
//        	step = 0;
        }
	}          
}
