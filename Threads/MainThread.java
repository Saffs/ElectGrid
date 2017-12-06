package Threads;

import java.util.ArrayList;

import Interface.Screen3;
import Objects.EObject;

public class MainThread extends Thread {


	

	private long NanoTime;
	private ArrayList<EObject> objects;
	private int a;;

	private boolean isRunning = true;
	

	public MainThread( ArrayList<EObject> objects, int a) {
		this.objects = objects;
		this.a = a;
	}




	public void run()
	{
		
	Screen3 screen = new Screen3();
		
	
	
	
	
		NanoTime = System.nanoTime() / 1000000;	
		long CurrentTime;
		
//		do{
//			
//			CurrentTime =  System.nanoTime()/1000000 - NanoTime  ;
//			
//			if (CurrentTime > 500)
//			{
//				
//				NanoTime = System.nanoTime() / 1000000;	
//				
//				
//					
//				
//					screen.update(screen.getGraphics());
//					System.out.println("MainThread " + a);
//				
//					
//				
//					
//			}
//			
//			
//			
//			
//			
//			
//		}while(isRunning);
		
		
		
	}
	
	
	public void stopThread()
	{
		isRunning = false;
		
	}
	
	
	
}
