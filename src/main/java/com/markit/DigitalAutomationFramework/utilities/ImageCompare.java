package com.markit.DigitalAutomationFramework.utilities;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import java.io.File;

/**Compares Image pixel by pixel
 * @author sambhav.chawla
 *
 */
public class ImageCompare {

	static boolean processImage(File file1img, File file2img) {
		int[] data1 = null;
		int[] data2 = null;
		try{
			String file1 = file1img.getAbsolutePath();
			String file2 = file2img.getAbsolutePath();

			Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
			Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

			PixelGrabber grab1 =new PixelGrabber(image1, 0, 0, -1, -1, false);
			PixelGrabber grab2 =new PixelGrabber(image2, 0, 0, -1, -1, false);


			if (grab1.grabPixels()) {
				int width = grab1.getWidth();
				int height = grab1.getHeight();
				data1 = new int[width * height];
				data1 = (int[]) grab1.getPixels();
			}

			if (grab2.grabPixels()) {
				int width = grab2.getWidth();
				int height = grab2.getHeight();
				data2 = new int[width * height];
				data2 = (int[]) grab2.getPixels();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return java.util.Arrays.equals(data1, data2);
	}


	/**Takes 2 image files as input
	 * @param file1 Image file
	 * @param file2 Iamge file
	 * @return True if images are same, false otherwise
	 */
	public static boolean isSameFileImage(File file1, File file2){
		return processImage(file1,file2);
	} 
}