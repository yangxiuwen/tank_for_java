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
        //������Ҫ�����ı�   ̹�˵�����Ĭ�ϵ��ڱ�ը������  ����ըС�ڵ���̹��������ʱ������Ƴ� 
//        if (step >= ResourceMgr.explodes.length && ResourceMgr.explodes.length < 5) {
        if (step <= 5) {
        	f.explodes.remove(this);
//        	step = 0;
        }
	}          
}
