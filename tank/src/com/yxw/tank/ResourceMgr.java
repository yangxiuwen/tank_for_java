package com.yxw.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceMgr {
	
	public static BufferedImage tankL, tankU, tankR, tankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	
	static {
		try {
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/1.jpg"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/2.jpg"));
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/3.jpg"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/4.jpg"));		
			
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bullet.jpg"));
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bullet.jpg"));
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bullet.jpg"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bullet.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
