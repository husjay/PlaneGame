package com.hsjay.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author hsj
 *
 */
public class GameUtil {
	public static Image getImage(String path) {
		BufferedImage bi=null;
		try {
			URL u = GameUtil.class.getClassLoader().getResource(path);
			bi = javax.imageio.ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//img = Toolkit.getDefaultToolkit().createImage(u);
		
		return bi;
	}
}
