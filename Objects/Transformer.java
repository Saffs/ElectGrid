package Objects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Transformer extends EObject {

	private EObject High;
	private EObject Low;
	
	private double high_wind = 2;
	private double low_wind = 2;
	
	private double prev_high;
	private double prev_low;
	
	private double high_coef;
	private double low_coef;
	
	
	public Transformer()
	{
		super();
		
		 Random r = new Random();
		 int x =  r.nextInt(150);
		 int y =  r.nextInt(150);
		  
		 this.setCoord(x, 2);
		
		
		this.High = new EObject();
		this.Low = new EObject();
	
		
		Project.getList().remove(High);
		Project.getMovableList().remove(High);
		Project.getList().remove(Low);
		Project.getMovableList().remove(Low);
		
		
		High.setR(0d);;
		Low.setR(0d);
		
		this.setR(High.getR() + Low.getR());
	//	Project.getList()
		
		setImage();
	}
	
	
	
	@Override
	public void setImage()
	{
		try
		{
			
			
			image = ImageIO.read(new File("D:\\fileT.png"));
			imageChoosen = ImageIO.read(new File("D:\\fileTGr.png"));
			imageChoosenLeft = ImageIO.read(new File("D:\\fileTGrLeft.png"));
			imageChoosenRight = ImageIO.read(new File("D:\\fileTGrRight.png"));
			
			
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public double getHigh_wind() {
		return high_wind;
	}






	public double getLow_wind() {
		return low_wind;
	}



	public void setWindings(double d, double e ) {
		
		System.out.println( );
		System.out.println();
		System.out.println("!!! Start here !!! " );
		
		prev_high = this.getHigh_wind();
		prev_low = this.getLow_wind();
		
		calcCoef(d, e);
		changeRforTransfromer(this);
		
		for (int i = 0; i < Project.getList().size(); i++)
		{
			if (Project.getList().get(i).getClass() == Transformer.class && !Project.getList().get(i).equals(this))
			{
				Transformer tr = (Transformer) Project.getList().get(i);
				
				
				tr.calcCoef(  tr.getHigh_wind(), tr.getLow_wind()  );
				changeRforTransfromer(tr);
				
				
			}	
				
		}
		
		
	
		
		
		
		//changeRes();
		
	}
	
	
	private void calcCoef(double h, double l)
	{
		
		
		high_coef = h / prev_high;
		low_coef = l / prev_low;
		
		
		this.high_wind = h;
		this.low_wind = l;
		
	}

	
	
	
	public void changeRforTransfromer(Transformer tr)
	{
		
		
		ArrayList<Line> lines = new ArrayList<>();
		ArrayList<EObject> objects = new ArrayList<>();
		
		objects.add(tr);
		
		int i = 0;
		do
		{
				int outCoord = objects.get(i).getOut();
				
				for (int j = 0; j < Project.getList().size(); j++)
				{
					
					if (outCoord == 7) break;
					
					if (Project.getList().get(j).getIn() == outCoord && !Project.getList().get(j).equals(objects.get(i)))
					{
						if (Project.getList().get(j).getClass() == Line.class )
						{
							Line temp = (Line) Project.getList().get(j);
							
							if (!lines.contains(temp))
							{
							lines.add(temp);
							}
							
							if (!objects.contains(Project.getList().get(j)))
							{
							objects.add(Project.getList().get(j));
							}
							
						}
						
						if (Project.getList().get(j).getClass() == Switcher.class || Project.getList().get(j).getClass() == Transformer.class )
						{
							if (!objects.contains(Project.getList().get(j)))
							{
							objects.add(Project.getList().get(j));
							}
						}
						
					}
					
				}
				
				objects.remove(objects.get(i));
			
		}while(objects.size() != 0);
		
		System.out.println("/// Transf here /// " );
		System.out.println("_________" );
		System.out.println("We have " +lines.size() + " lines");
		
		System.out.println("high_coef " + high_coef);
		System.out.println("low_coef " + low_coef);
		
		double koef = high_coef/low_coef;
		System.out.println("koef is " + koef);
		System.out.println("_________" );
		
		
		
		System.out.println("___Lines list");
		System.out.println("Number of Lines = " + lines.size() );
		for (int k = 0; k < lines.size(); k++)
		{
			lines.get(k).setR(lines.get(k).getR()*koef);
			System.out.println(k + " линия" + " | R = " + lines.get(k).getR() + " | Координаты - "+ lines.get(k).getIn() + " " + lines.get(k).getOut()  );
		}
		System.out.println("___End Lines list");
		
		
		
	}
	
	
	
}
