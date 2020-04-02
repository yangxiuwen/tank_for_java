package com.yxw.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceMgr {
	
	public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
	public static BufferedImage badTankL, badTankU, badTankR, badTankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	public static BufferedImage[] explodes = new BufferedImage[5];
	
	static {
		try {
			goodTankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/1.jpg"));
			goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/2.jpg"));
			goodTankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/3.jpg"));
			goodTankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/4.jpg"));		
			
			badTankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/1.jpg"));
			badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/2.jpg"));
			badTankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/3.jpg"));
			badTankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/4.jpg"));		
			
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bullet.jpg"));
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bullet.jpg"));
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bullet.jpg"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bullet.jpg"));
			
			for (int i=0; i<5; i++) {
				explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bom" + i + ".jpg"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
