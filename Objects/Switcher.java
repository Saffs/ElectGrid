package Objects;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import javax.imageio.ImageIO;

public class Switcher extends EObject implements Serializable {

	private boolean isSwitchOn;
	
	public Switcher()
	{
		super();
		
		setImage();
		
		Random a = new Random();
		
		int in = a.nextInt(150);
		int out = a.nextInt(150);
		
		this.setCoord(1, 2);
		this.setR(0.0000001);
		
	}
	
	@Override
	public void setImage()
	{
		try
		{
			this.image = ImageIO.read(new File("D:\\fileS.png"));
			this.imageChoosen = ImageIO.read(new File("D:\\fileSGr.png"));
			this.imageChoosenLeft = ImageIO.read(new File("D:\\fileSGrLeft.png"));
			this.imageChoosenRight = ImageIO.read(new File("D:\\fileSGrRight.png"));
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setSwitch(boolean b)
	{
		this.isSwitchOn = b;
		
		if (b)
			this.setR(10000000);
		else
			this.setR(0.00000001);
	}
	
	public boolean getSwitchPosition()
	{
		return isSwitchOn;
	}
	
}
