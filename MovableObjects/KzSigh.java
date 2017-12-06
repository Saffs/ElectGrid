package MovableObjects;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import Objects.Line;

public class KzSigh extends EMovableObject implements Serializable {

	
	private int const_Xmin;
	private int const_Xmax;
	private int const_Y;
	
	private Line line;
	
	
	private int KzType = 1;
	
	
	public int getKzType() {
		return KzType;
	}

	public void setKzType(int kzType) {
		KzType = kzType;
	}

	public KzSigh(int const_Xmin, int const_Xmax, int const_Y)
	{
		this.const_Xmin = const_Xmin;
		this.const_Xmax = const_Xmax;
		this.const_Y = const_Y;
		
		
		
		
		this.setX(const_Xmax);
		this.setY(150);
		
		
		
		
		
		setImage();
	}
	
	public void connectToLine(Line line2)
	{
		this.line = line2;
//		Line a = new Line(this.line);
		
	}
	
	
	
	public void setImage()
	{
	
		try
	{
		image = ImageIO.read(new File("D:\\kz.png"));
		imageChoosen = ImageIO.read(new File("D:\\kz.png"));
		
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}

	}
	
	

	
	
	
	public void setConstY(int y)
	{
		System.out.println("Установлено");
		this.const_Y = y;
		
	}
	
	

	
	
	
	@Override
	public void setY(int y)
	{
		System.out.println(const_Y);
		this.y = const_Y;
	}
	
	public void setConstX(int Xmin, int Xmax)
	{
		
		this.const_Xmin = Xmin;
		this.const_Xmax = Xmax;
		
		this.x = Xmin + (Xmax - Xmin) * this.line.getPercentage()/100;
		
		
	}
	
	@Override
	public void setX(int X)
	{
		
		if (X < const_Xmin )
			this.x = const_Xmin;
		
		else if (X > const_Xmax)
			this.x = const_Xmax;
		
		else
			this.x = X;
		
		if (line != null)
		{
			int perc = (this.x - const_Xmin)*100/ (const_Xmax - const_Xmin);
			line.setPercentage(perc);
			this.line.setR(this.line.getRmax() * perc / 100);
		}
		

		
		
	}
	
	public Line getLine()
	{
		return this.line;
		
	}
	
}
