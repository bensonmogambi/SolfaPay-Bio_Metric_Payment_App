package com.neurotechnology.Nffv;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * Provides methods for managing images.
 */
public class NffvImage {
	
	private byte [] imageData;
	private int width;
	private int height;
	private int stride;
	private float horizontalResolution;
	private float verticalResolution;
	
	/**
	 * Creates an image from a byte array.
	 * @param imageData Byte array that contains image data.
	 */
	public void setImageData(byte [] imageData) {
		this.imageData = imageData;
	}

	/**
	 * Gets an image data as a byte array.
	 * @return Byte array that contains image data.
	 */
	public byte [] getImageData() {
		return imageData;
	}

	/**
	 * Sets image width.
	 * @param width Image width in pixels.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Retrieves image width.
	 * @return Image width in pixels.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets image height.
	 * @param height Image height in pixels.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Retrieves image height.
	 * @return Image height in pixels.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the stride (size of one row) of the image.
	 * @param stride Image stride.
	 */
	public void setStride(int stride) {
		this.stride = stride;
	}

	/**
	 * Gets the stride (size of one row) of the image.
	 * @return Image stride.
	 */
	public int getStride() {
		return stride;
	}

	/**
	 * Sets the horizontal resolution of the image.
	 * @param horizontalResolution Horizontal resolution of image to set.
	 */
	public void setHorizontalResolution(float horizontalResolution) {
		this.horizontalResolution = horizontalResolution;
	}

	/**
	 * Gets the horizontal resolution of the image.
	 * @return Horizontal resolution of image.
	 */
	public float getHorizontalResolution() {
		return horizontalResolution;
	}

	/**
	 * Sets the vertical resolution of the image.
	 * @param verticalResolution Vertical resolution of image to set.
	 */
	public void setVerticalResolution(float verticalResolution) {
		this.verticalResolution = verticalResolution;
	}

	/**
	 * Retrieves the vertical resolution of the image.
	 * @return Vertical resolution of image.
	 */
	public float getVerticalResolution() {
		return verticalResolution;
	}
	
	/**
	 * Gets a buffered image.
	 * @return Buffered image which contains an accessible buffer of the image.
	 */
	public BufferedImage getBufferedImage(){
		BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		int [] pixels = new int[width * height];
			for (int i = 0; i < height; i++)
				for (int j = 0; j < width; j++){
					int p = (i * stride + j * 3); 
					pixels[i * width + j] = imageData[p + 2] + (imageData[p + 1] << 8) + (imageData[p] << 16) + (255 << 24);
				}
		bimage.setRGB(0, 0, width, height, pixels, 0, width);
		
		return bimage;
	}
	
	/**
	 * Get an image icon.
	 * @return An icon of the image.
	 */
	public ImageIcon getImageIcon(){
		return new ImageIcon(getBufferedImage());
	}
}
