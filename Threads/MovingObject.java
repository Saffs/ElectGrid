package Threads;

import java.awt.MouseInfo;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import Interface.Screen3;
import MovableObjects.EMovableObject;
import Objects.EObject;

public class MovingObject extends Thread {

	
	private EMovableObject object;
	private Screen3 screen;
	
	private int dx;
	private int dy;
	
	
	public static boolean isRunning = true;
	
	private long NanoTime2;
	
	public MovingObject(EMovableObject choosenObject, Screen3 screen, int dx, int dy)
	{
		this.object = choosenObject;
		this.screen = screen;
		
		this.dx = dx;
		this.dy = dy;

	}
	
	
	public void run()
	{
		
		isRunning = true;
		
		NanoTime2 = System.nanoTime() / 1000000;	
		long CurrentTime2;
			do{
			
			CurrentTime2 =  System.nanoTime()/1000000 - NanoTime2  ;
			
			if (CurrentTime2 >= 55)
			{
				NanoTime2 = System.nanoTime() / 1000000;
	
				
				object.setX( screen.getMousePosition().x  + 32 + dx );
				object.setY( screen.getMousePosition().y  + 9 + dy );
				
				screen.repaint();
				
			}
			
			
			
			
			
			
		}while(isRunning);
		
	}
	
	
	public static void stopMoving()
	{
		isRunning = false;
		
	}
	
}
