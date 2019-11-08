package four;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

	/**
	 * @author Daniel Moore
	 * @version 1 / 21 / 2019
	 */

	/*
	 * Main help and concepts from NEW BEGINNER 2D GAME PROGRAMMING    by: Code N' More
	 */
	
public class ImageLoader {
	
	/**
	 * @param path
	 * @return BufferedImage
	 */
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
