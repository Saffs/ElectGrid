package Objects;

import java.io.Serializable;

public class Point implements Serializable  {

	
	private  Double fi;



	private int coord;
	
	
	public Point(){
	//	this.id = ++counter;
	};
	
	public Point(int coord, Double fi)
	{
		this.coord = coord;
		this.fi = fi;
		
		
	}
	
	public void setFi(Double fi) {
		this.fi = fi;
	}

	public void setCoord(int coord) {
		this.coord = coord;
	}

	public Point(int coord)
	{
		this.coord = coord;
		
		

	
	
		
		
	}
	
	
	public int getCoord()
	{
		
		return this.coord;
	}
	
	
	public Double getFi() {
		return fi;
	}
	
}
