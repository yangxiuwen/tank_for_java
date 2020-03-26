package com.yxw.tank;

import java.awt.Frame;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Frame f = new TankFrame();
		
		while(true) {
			Thread.sleep(50);
			f.repaint();
		}
	}

}
