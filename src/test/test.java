package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class test {

	@Test
	public void test() {
		
		try {
			
//			BufferedImage image = ImageIO.read(new File("F:/php/java_projact/tan.jpg"));
//			assertNotNull(image);
			
			BufferedImage image1 = ImageIO.read(test.class.getClassLoader().getResourceAsStream("image/1.jpg"));
			assertNotNull(image1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
