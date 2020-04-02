package com.yxw.tank;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame f = new TankFrame();
		
		//construct  tanks
		
		for (int i=0; i<5; i++) {
			f.tanks.add(new Tank(50 + i * 60, 200, Dir.DOWN, Group.BAD, f));
		}
		while(true) {
			Thread.sleep(50);
			f.repaint();			
		}
	}

}
