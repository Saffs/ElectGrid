package Objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import javax.imageio.ImageIO;

import MovableObjects.KzSigh;

public class Line extends EObject implements Serializable{

	private double Rud;
	private double X1ud;
	private double X0ud;
	private double Xmud;
	private double l;
	
	public static double Ub = 230; 
	private double Unom = Ub;
	private double Sdlit;
	private double Smaxplus;
	private double IprodRasch;
	private double Smaxminus;
	
	private KzSigh sigh;
	
	private int percentage;
	private Line boundedLine;
	private boolean isShortCircued;
	
	private double Rmax;
	
	public Line(double Rud, double X1ud, double X0ud, double Xmud, double l)
	{
		super();
		this.Rud = Rud;
		this.X1ud = X1ud;
		this.X0ud = X0ud;
		this.Xmud = Xmud;
		this.l = l;
		
		
		
		
		
		this.setR(Rud*l) ;
		
		setImage();
		this.setR(Rud*l) ;
		Rmax = this.getR();
		
		 Random r = new Random();
		 int x =  r.nextInt(150);
		 int y =  r.nextInt(150);
		  
		  this.setCoord(2, 3);
		
	
	}
	
	public Line(double Rud, double X1ud, double X0ud, double l)
	{
		super();
		this.Rud = Rud;
		this.X1ud = X1ud;
		this.X0ud = X0ud;
		this.l = l;
		
		
		
		
		
		
		
		this.setR(Rud*l) ;
		Rmax = this.getR();
		
		setImage();
		
		 Random r = new Random();
		 int x =  r.nextInt(150);
		 int y =  r.nextInt(150);
		  
		  this.setCoord(2, 3);
	
	}
	
	
	public Line(Line source)
	{
		super();
		this.Rud =  source.Rud;
		this.X1ud = source.X1ud;
		this.X0ud = source.X0ud;
		this.Xmud = source.Xmud;
		this.l = source.l;
	
		 
			  
			  
		
		
		
		this.setX(source.getX()+source.getImage().getWidth());
		this.setY(source.getY());
		
		this.setR(Rud*l) ;
		this.Rmax = this.getR();
		
		setImage();
		
		Rmax = this.getR();
		
		
		this.setCoord(7, source.getOut());
		source.setCoord(source.getIn(), 7);
		
		
		source.setBoundedLine(this);
	}
	
	
	
	public KzSigh getSigh() 
	{
		return sigh;
	}

	public boolean isShortCircued() {
		return isShortCircued;
	}

	public void setShortCircued(boolean isShortCircued) {
		this.isShortCircued = isShortCircued;
	}
	
	@Override
	public void setR(double R)
	{
		
	
			
			if (R == 0)
				this.R = 0.0000001;
			else
				this.R = R;
			
		
		
		
		if (this.sigh == null)
		{
			this.Rmax = R;
		}
		else
		{
			this.boundedLine.setR(this.getRmax() - R);
		}
		
	}
	
	@Override
	public void setY(int y)
	{
		this.y = y;
		
		if (this.sigh != null)
		{
			this.sigh.setConstY(y + this.getImage().getWidth());
			this.sigh.setY(y + this.getImage().getWidth());
			this.boundedLine.setY(this.y);
		}
	
		
		
		
		
	}
	
	@Override
	public void setX(int x)
	{
		this.x = x;
		
		if (this.sigh != null)
		{
			this.sigh.setConstX(x-7, x+2*this.getImage().getHeight()-7);
			this.boundedLine.setX(this.x + this.getImage().getWidth());
			
		}
		
		
		
		
	
	}
	
	@Override
	public void setImage()
	{
		try
		{
			image = ImageIO.read(new File("D:\\fileL.png"));
			imageChoosen = ImageIO.read(new File("D:\\fileLGr.png"));
			imageChoosenLeft = ImageIO.read(new File("D:\\fileLGrLeft.png"));
			imageChoosenRight = ImageIO.read(new File("D:\\fileLGrRight.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void  setKz()
	{
		
		
		Line L2 = new Line(this.getRud(), 0.1, 1.47, 0.84, this.getL());
		Random r = new Random();
		int x =  r.nextInt(150);
		int y =  r.nextInt(150);
		  
		L2.setCoord(0 , this.getOut());
		  
		this.setCoord(this.getIn(), 0);

		
		L2.setX(this.getX()+this.getImage().getWidth());
		L2.setY(this.getY());
		
		L2.setR(Rud*l) ;
		
		
		this.setBoundedLine(L2);
		
			
		this.sigh = new KzSigh(this.getX()-7, this.getX()+2*this.getImage().getHeight()-7, this.getY()+ this.getImage().getWidth());
		this.sigh.connectToLine(this);
//		
		isShortCircued = true;
		

	}
	
	public void setBoundedLine(Line line)
	{
		this.boundedLine = line;
	}
	
	public Line getBoundedLine()
	{
		return this.boundedLine;
	}
	
	public void setPercentage(int perc)
	{
		this.percentage = perc;	
	}

	public int getPercentage()
	{
		return this.percentage;
	}
	
	public double getRmax()
	{
		return Rmax;
		
	}
	
	public double getUnom() {
		return Unom;
	}

	public void setUnom(double unom) {
		Unom = unom;
	}

	public double getIprodRasch() {
		return IprodRasch;
	}
	
	public void calculateIprodRasch() {
		IprodRasch = Sdlit / ( Math.sqrt(3) * Unom  );
	}
	
	public void setIprodRasch(double iprodRasch) {
		IprodRasch = iprodRasch;
	}

	public double getRud() {
		return Rud;
	}

	public void setRud(double rud) {
		Rud = rud;
	}

	public double getX1ud() {
		return X1ud;
	}

	public void setX1ud(double x1ud) {
		X1ud = x1ud;
	}

	public double getX0ud() {
		return X0ud;
	}

	public void setX0ud(double x0ud) {
		X0ud = x0ud;
	}

	public double getXmud() {
		return Xmud;
	}

	public void setXmud(double xmud) {
		Xmud = xmud;
	}

	public double getL() {
		return l;
	}

	public void setL(double l) {
		this.l = l;
	}

	public double getSdlit() {
		return Sdlit;
	}

	public void setSdlit(double sdlit) {
		Sdlit = sdlit;
	}

	public double getSmaxplus() {
		return Smaxplus;
	}

	public void setSmaxplus(double smaxplus) {
		Smaxplus = smaxplus;
	}

	public double getSmaxminus() {
		return Smaxminus;
	}

	public void setSmaxminus(double smaxminus) {
		Smaxminus = smaxminus;
	}


	
	
	
	
	
	
	
	
}
