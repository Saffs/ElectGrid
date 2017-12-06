package MovableObjects;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import Objects.Project;

public class EMovableObject implements Serializable{

	protected int x;
	protected int y;
	
	
	protected transient  BufferedImage image;
	protected transient  BufferedImage imageChoosen;
	
	
	public EMovableObject()
	{
		this.addToMovableObjects();
	}
	
	public void setImage(){}
	
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
	
	public BufferedImage getImage() {
		return image;
	}

	public BufferedImage getImageChoosen() {
		return imageChoosen;
	}
	
	public void addToMovableObjects()
	{
		Project.getMovableList().add(this);
	}
	
	
}
