package Relays;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import MovableObjects.EMovableObject;
import Objects.EObject;
import Objects.Line;
import Objects.Project;
import Objects.Switcher;

public class DistanceProtection extends EMovableObject implements Serializable{

	private Switcher switcher;
	
	protected int x;
	protected int y;
	
	private double z;
	
	
	private double firstStage;
	private EObject firstStageObject;
	
	private double secondStage;
	private EObject secondStageObject;

	private double thirdStage;

	
	private boolean isSettedFirst = false;
	private boolean isSettedSecond = false;
	private boolean isSettedThird = false;
	
	
	public DistanceProtection()
	{
		this.x = 50;
		this.y = 50;
		setImage();
	}
	
	
	
	
	
public void setImage()
	{
	
		try
	{
		image = ImageIO.read(new File("D:\\fileD.png"));
		imageChoosen = ImageIO.read(new File("D:\\fileDGr.png"));
		
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}

	}








public BufferedImage getImage() {
	return image;	
}



public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public Switcher getSwitcher() {
	return switcher;
}

public void setSwitcher(Switcher switcher) {
	this.switcher = switcher;
	
	isSettedFirst = false;
	isSettedSecond = false;

	
}

public void setImpendance()
{
//	if (this.switcher.getSwitchPosition()) return;
	
	System.out.println("Напряжение выкл -" + this.switcher.getVin() + "Ток выключателя - " + this.switcher.getI());
	
	this.z = this.switcher.getVin()/ this.switcher.getI();
	
//	if (!isSettedFirst)
//	setFirstStage();
//	
//	if (isSettedFirst)
//	setSecondStage();
	
//	if (z < firstStage)
//		this.switcher.setSwitch(true);
}

public double getImpedance()
{
	return z;
}


public void setFirstStage()
{
	int out_coord = switcher.getPointVout().getCoord();
	
	for (int i = 0; i <Project.getList().size(); i++)
	{
		if (Project.getList().get(i) == switcher) continue;
		
		if (Project.getList().get(i).getPointVin().getCoord() == out_coord)
			{
			firstStage = Project.getList().get(i).getR() * 0.85;
			firstStageObject = Project.getList().get(i);
			isSettedFirst = true;
			}
		
		
	}


	
	
	
}


public void setSecondStage()
{
	if (!isSettedFirst) return;
	

	
	System.out.println("Сопротивление равно -" + firstStageObject.getR());
	
	
	
	
	secondStage = firstStageObject.getR()*1.25;
	secondStage = someMethod(firstStageObject);
	
	isSettedSecond = true;
}




public double someMethod(EObject object)
{
	ArrayList<Line> lines = new ArrayList<>();
	ArrayList<EObject> objects = new ArrayList<>();
	
	objects.add(object);
	
	int i = 0;
	do
	{
		
		
		
		
			int outCoord = objects.get(i).getOut();
			
			for (int j = 0; j < Project.getList().size(); j++)
			{
				if (Project.getList().get(j).getIn() == outCoord && !Project.getList().get(j).equals(objects.get(i)))
				{
					if (Project.getList().get(j).getClass() == Line.class)
					{
						Line temp = (Line) Project.getList().get(j);
						lines.add(temp);
					}
					
					if (Project.getList().get(j).getClass() == Switcher.class)
					{
						objects.add(Project.getList().get(j));
					}
					
					
				}
				
				
			}
			
			
			objects.remove(objects.get(i));
		
		
		
	}while(objects.size() != 0);
	
	
	System.out.println("We have " +lines.size() + " lines");
	
	
	double min = lines.get(0).getR();
	
	
	for (int k = 0 ; k < lines.size(); k++)
	{
		if (  lines.get(k).getR() < min)
		{
			min = lines.get(k).getR();
		}
		
		
	}
	
	
	return min;
}



public void setThirdStage()
{

	
	
	


}




public double getFirstStage()
{
	return this.firstStage;
}



public double getSecondStage()
{
	return this.secondStage;
}


public double getThirdStage()
{
	return this.firstStage;
}


	
}


