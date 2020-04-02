package com.yxw.tank;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;

public class Audio extends Thread {
	
	@Override 
	public void run() {
		try {
			byte[] b = new byte[1024];
			int len = 0;
//			SourceDataLine.open(AudioFormat, 1024);
//			SourceDataLine.start();
//			while ((len = AudioInputStream(b)) > 0) {
//				SourceDataLine.write(b,0,len);
//			}
//			AudioInputStream.close();
//			SourceDataLine.drain();
//			SourceDataLine.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
