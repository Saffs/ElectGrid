package Objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class Source  extends EObject implements Serializable {

	private double Xcmax;
	private double Xcmin;
	private boolean isMin;
	

	
	
	public Source(int in, int out, double E, double Xcmax, double Xcmin)
	{
		super();
		this.setCoord(in, out);
		this.E = E;
		this.Xcmax = Xcmax;
		this.Xcmin = Xcmin;
		
		this.setR(Xcmax);
		
		this.setVin(0d);
		
		
		setImage();
	}
	
	public void setIsMin(boolean b)
	{
		isMin = b;
	}
	
	public boolean getIsMin()
	{
		return isMin;
		
	}
	
	
	public BufferedImage getImage() {
		return image;
	}


	public BufferedImage getImageChoosen() {
		return imageChoosen;
	}


	public BufferedImage getImageChoosenLeft() {
		return imageChoosenLeft;
	}


	public BufferedImage getImageChoosenRight() {
		return imageChoosenRight;
	}
	
	
	@Override
	public void setImage()
	{
		try
		{
			image = ImageIO.read(new File("D:\\fileE.png"));
			imageChoosen = ImageIO.read(new File("D:\\fileEGr.png"));
			imageChoosenLeft = ImageIO.read(new File("D:\\fileEGrLeft.png"));
			imageChoosenRight = ImageIO.read(new File("D:\\fileEGrRight.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	

	public double getXcmax() {
		return Xcmax;
	}

	public void setXcmax(double xcmax) {
		Xcmax = xcmax;
		this.setR(xcmax);
	}

	public double getXcmin() {
		return Xcmin;
	}

	public void setXcmin(double xcmin) {
		Xcmin = xcmin;
	}
	
}
