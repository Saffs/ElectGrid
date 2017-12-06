package Objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import MovableObjects.EMovableObject;

public class EObject extends EMovableObject    {
	
	
	public  Point Vin;
	public  Point Vout;
	
	private static boolean isLightOn;
	private static EObject objectToTie;
	
	private boolean isChoosing;

	private boolean isChoosingLeft;
	private boolean isChoosingRight;
	

	protected double E;
	protected double I;
	protected double R;
	
	protected static ArrayList<Point> points = new ArrayList<Point>();;
	protected static ArrayList<EObject> objects = new ArrayList<EObject>();
	
	
	public static int counter;
	
	
	public static final int WIDTH = 41;
	public static final int HEIGHT = 39;
	
//	protected transient  BufferedImage image;
//	protected transient  BufferedImage imageChoosen;
	protected transient  BufferedImage imageChoosenLeft;
	protected transient  BufferedImage imageChoosenRight;
	
	
//	public BufferedImage getImage() {
//		return image;
//	}
//
//	public BufferedImage getImageChoosen() {
//		return imageChoosen;
//	}

	public BufferedImage getImageChoosenLeft() {
		return imageChoosenLeft;
	}

	public BufferedImage getImageChoosenRight() {
		return imageChoosenRight;
	}
	
	
	public EObject()
	{
		
		int minimum = 50;
		int maximum = 300;
		
		this.x = minimum + (int)(Math.random() * (maximum - minimum+1)); 
		this.y = minimum + (int)(Math.random() * (maximum - minimum+1)); 
			
		
		this.addEObjectToMyList();
		
		objects.add(this);
		System.out.println("Size is "+ objects.size());
	}
	
	
	public Point getPointVin()
	{
		return Vin;
	}
	
	public Point getPointVout()
	{
		return Vout;
	}
	
	
	public void ChooseThis()
	{
		int size = Project.getList().size();
		
		for (int i = 0; i < size; i++)
		{
			Project.getList().get(i).isChoosing = false;
		}
		
		this.isChoosing = true;
		
		
	}
	
	
	public  void setImage() {
	}





//	public static void setImage(BufferedImage image2) {
//		image = image2;
//	}
	
	
	
	
//	public int getX() {
//		return x;
//	}
//
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public int getY() {
//		return y;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}


	public  void addEObjectToMyList()
	{
		Project.getList().add(this);
//	Project.getMovableList().add(this);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public double getE() {
		return E;
	}

	public void setE(double e) {
		E = e;
	//	Vout.setFi(e);
	}
	
	

	
	
	public double getI() {
		return I;
	}

	public void setI(double i) {
		
	//	double newDouble = new BigDecimal(i).setScale(3, RoundingMode.UP).doubleValue();
		
		
			I = i;
		
		
	}

	public double getVin() {
		
		return Vin.getFi();
	
	}

	public void setVin(Double vin) 
	{
		System.out.println("Set Vin!");
		Vin.setFi(vin);	
		
		if (Vout.getFi() != null)
		{
			System.out.println("Set Current!"+ this.getI());
		this.setI((Vin.getFi() - Vout.getFi())/R);
		}
	}
	
	public void Example()
	{
		System.out.println("Hello where!");
		this.Vin.setFi(15d);
		System.out.println("Vin result is " + this.Vin.getFi());;
		

	}
	
	

	public double getVout() {
		return Vout.getFi();
	}

	public void setVout(Double vout) {
		System.out.println("Set Vout!");
		Vout.setFi(vout);
		
		if (Vin.getFi() != null)
		{
			
			this.setI((Vin.getFi() - Vout.getFi())/R);
			System.out.println("Set Current!" + this.getI());
		}
			
		
	}

	public void setCoord(int in, int out)
	{
		
		System.out.println("Установление координат");
		
	
		boolean isCheckedIn = false;
		boolean isCheckedOut = false;
	
		points.clear();
		
		for (int i = 0; i < Project.getList().size(); i++)
		{
			if   (Project.getList().get(i) == this  ) continue;
			
			Point Pin =  Project.getList().get(i).getPointVin();
			Point Pout =  Project.getList().get(i).getPointVout();
			
			points.add(Pin);
			points.add(Pout);
			
		
		}
		
//		 System.out.println("Загрузка точек произошла, всего -" + points.size());
//		for (int i = 0; i < points.size(); i++)
//		{
//			System.out.println(points.get(i).getCoord());
//		}
//		System.out.println("Точки загружены");
		 
		
		for (int i = 0; i < points.size(); i++)
		{
			if (points.get(i).getCoord() == in)
				{ 
				
					
				
					Vin = points.get(i); isCheckedIn = true;
					System.out.println("Дублируется точка -" + points.get(i).getCoord());
					
					
		
					
					
					
				}
			
			else if (points.get(i).getCoord() == out)
				{ 
				
				
					Vout = points.get(i); isCheckedOut = true; 
					System.out.println("Дублируется точка -" + points.get(i).getCoord());
				
					
					if (this.getClass() == Line.class)
					{
						Line temp = (Line) this;
						if (temp.isShortCircued() == false)
						{
							isCheckedOut = false;
						}
					}
					
					
					
					
				}
		}
		
		if (!isCheckedIn)
		{
		Point a =  new Point(in);
		this.Vin = a;
			points.add(a);
			
			System.out.println("Создается точка -" + a.getCoord());
			
		}
		
		if (!isCheckedOut)
		{
			Point a =  new Point(out);
			this.Vout = a;
				points.add(a);
				System.out.println("Создается точка -" + a.getCoord());
		}
		
		
		if (this.getClass() == Source.class)
		{
			this.getPointVin().setFi(0d);
		}
			
	}

	public static void printPoints() {

for (int i = 0; i < points.size(); i++)
{
//	System.out.println("Координата точки "+ i +" is " + points.get(i).coord + " id точки " + points.get(i).id);
	
}
		
	}
	
	
	public int getIn() {
		return Vin.getCoord();
	}

	public int getOut() {
		return Vout.getCoord();
	}
	
	public double getR() {
		return R;
	}
	
	public void setR(double R){
		
		if (R == 0)
			this.R = 0.0000001;
		else
			this.R = R;
		
	}
	
	public boolean isChoosingLeft() {
		return isChoosingLeft;
	}

	public void setChoosingLeft() {
		
		if (isLightOn) 
			{
				if(objectToTie.isChoosingLeft)
					this.setCoord(objectToTie.getIn(), this.getOut());
				else if (objectToTie.isChoosingRight)
					this.setCoord(objectToTie.getOut(), this.getOut());
				
				isLightOn = false;
				
				this.isChoosingLeft = false;
				this.isChoosingRight = false;
				
				objectToTie.isChoosingLeft =false;
				objectToTie.isChoosingRight =false;
				objectToTie = null;
				return;
			}
		
		if(!isLightOn) 
		{ 
			setLeftChoosenPcture();
			this.isChoosingLeft = true;
			isLightOn = true;
			objectToTie = this; 
		} 
		
		
	}
	
	public void setChoosingRight() {
		
		if (isLightOn) 
			{
				if(objectToTie.isChoosingLeft)
					this.setCoord(this.getIn(), objectToTie.getIn());
				else if (objectToTie.isChoosingRight)
					this.setCoord(this.getIn(), objectToTie.getOut());
			
				isLightOn = false;
				
				this.isChoosingLeft = false;
				this.isChoosingRight = false;
				
				objectToTie.isChoosingLeft =false;
				objectToTie.isChoosingRight =false;
				objectToTie = null;
				return;
			}
		
		if(!isLightOn) 
		{ 
			setRightChoosenPcture();
			this.isChoosingRight = true;
			isLightOn = true;
			objectToTie = this; 
		} 
		
		
	}
	
	
	
	
	
	public void setLeftChoosenPcture()
	{
		this.imageChoosen = this.imageChoosenLeft;
	}
	
	public void setRightChoosenPcture()
	{
		this.imageChoosen = this.imageChoosenRight;
	}
	
	

	
	
	
	public  void setSC()
	{
		this.getPointVout().setFi(0d);
		
		
	}
	
	
}



