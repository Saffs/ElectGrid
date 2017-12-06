package Threads;

import Interface.Screen3;
import Objects.EObject;

public class ConnectionThread extends Thread {
	
	private long NanoTime2;
	
	private Screen3 screen;
	
	private int dx;
	private int dy;
	
	public static boolean isRunning = true;
	
	public ConnectionThread( Screen3 screen)
	{
		
		this.screen = screen;
	}
	
	public void run()
	{
		isRunning = true;
		
		NanoTime2 = System.nanoTime() / 1000000;	
		long CurrentTime2;
		
		
		
		
		do
		{
			CurrentTime2 =  System.nanoTime()/1000000 - NanoTime2  ;
			
			if (CurrentTime2 >= 1000)
			{
				NanoTime2 = System.nanoTime() / 1000000;
				
				screen.update(screen.getGraphics());
				
			}
			
			
		}while(true);
		
		
		
	}

	
	
	
}
