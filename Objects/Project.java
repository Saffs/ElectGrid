package Objects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;


import Interface.Screen3;
import Logic.MatrixMultiplication;
import Logic.dotsDeterminator;
import MovableObjects.EMovableObject;
import MovableObjects.KzSigh;
import Relays.DistanceProtection;
import Threads.MainThread;
import Threads.MovingObject;

public class Project {

	
	private static ArrayList<EObject> myList = new ArrayList<>();
	private static ArrayList<EMovableObject> myMovableList = new ArrayList<>();
	
	
	public static MainThread MainThread;
	public static MainThread MainThread2;
	
	public static MovingObject MovingThread;
	
	
	
	public void calculate()
	{
		System.out.println("calculate");
		
		Source S12 = new Source(0,1, 30, 10,15);
		S12.setX(30);
		S12.setY(190);
		
		Switcher S1 = new Switcher();
		S1.setX(100);
		S1.setY(120);
		S1.setCoord(1, 2);
		
		Switcher S2 = new Switcher();
		S2.setX(100);
		S2.setY(240);
		S2.setCoord(1, 3);
		
		Line L1 = new Line(1, 0.1, 1.47, 0.84, 10);
		L1.setSdlit(135);
		L1.setSmaxplus(38);
		L1.setSmaxminus(270);
		L1.setCoord(2, 4);
		L1.setX(183);
		L1.setY(120);

		Line L2 = new Line(1, 0.1, 1.47, 0.84, 10);
		L2.setSdlit(135);
		L2.setSmaxplus(38);
		L2.setSmaxminus(270);
		L2.setCoord(3, 5);
		L2.setX(183);
		L2.setY(240);
		
		
		Switcher S3 = new Switcher();
		S3.setX(265);
		S3.setY(120);
		S3.setCoord(4, 6);
		
		Switcher S4 = new Switcher();
		S4.setX(265);
		S4.setY(240);
		S4.setCoord(5, 6);
		
		
		
		
		
		System.out.println((L1.equals(L2)));
		
		
		
		Line L4 = new Line(1, 0.1, 1.47, 0.84, 10);
		L4.setSdlit(135);
		L4.setSmaxplus(38);
		L4.setSmaxminus(270);
		L4.setCoord(6, 7);
		L4.setX(350);
		L4.setY(180);
		
		
		
		
//		Line L3 = new Line(1, 0.405, 1.41, 0.81, 10);
//		L3.setSdlit(38);
//		L3.setSmaxplus(76);
//		L3.setSmaxminus(50);
//		L3.setCoord(2, 6);
//		
//		Line L4 = new Line(1, 0.405, 1.41, 0.81, 10);
//		L4.setSdlit(38);
//		L4.setSmaxplus(76);
//		L4.setSmaxminus(50);
//		L4.setCoord(2, 6);
//		
//		Line L6 = new Line(1, 0.405, 1.41, 0.81, 10);
//		L6.setCoord(6, 7);
//		

		System.out.println("her!");
		Screen3 screen = new Screen3();

                
                
	}
	
	public static void Action()
	{
		
		for (int i = 0; i < myList.size(); i++)
		{
			
				if (myList.get(i).getPointVin().getFi() != null)
				{
					myList.get(i).getPointVin().setFi(null);	
				}
				
				if (myList.get(i).getPointVout().getFi() != null)
				{
					myList.get(i).getPointVout().setFi(null);	
				}
				   
		}
		
		
		
		for (int i = 0; i < myList.size(); i++)
		{
		
//			
//			if (myList.get(i).getIn() == 5)
//			{
//				myList.get(i).setCoord(7, myList.get(i).getOut());
//			}
//			
//			
//			if (myList.get(i).getOut() == 5)
//			{
//				myList.get(i).setCoord(myList.get(i).getIn(), 7);
//			}
//			
			
			
			int coord = myList.get(i).getPointVout().getCoord();
			
			boolean isEnd = true;
			
			for (int j = 0; j < myList.size(); j++)
			{
				
				if (  myList.get(j).getPointVin().getCoord() == coord )
				{
					isEnd = false;
					break;
				}
				
				
			}
			
			
			if (isEnd)
			{
				myList.get(i).setCoord( myList.get(i).getIn(), 0);
				
			}
			
			
			
			
			if (myList.get(i).getIn() == 0)
			{
				myList.get(i).getPointVin().setFi(0d);	
			}

			if (myList.get(i).getOut() == 0)
			{
				myList.get(i).getPointVout().setFi(0d);	
			}
			
			


		
			
			
			
				
				
			
		
		}

		
		for (int i = 0; i < myList.size(); i++)
		{
				System.out.println("I is " + myList.get(i).getI());
		}
		
	
		
		
		ArrayList<Integer> keyDots = dotsDeterminator.getKeyDots(myList);
		
		double[][] resistMatrix =	dotsDeterminator.getMatrixResistors(myList);
		double[][] Ematrix  = dotsDeterminator.getMatrixPotentials(myList);
		double[][] potentials = MatrixMultiplication.MatrixMult(resistMatrix, Ematrix);
		
		setPotentialsInLines(keyDots, myList, potentials);
		
		System.out.println("���� ����� setPotentialsInLines");
		for (int i = 0; i < myList.size(); i++)
		{
				System.out.println("I is " + myList.get(i).getI());
		}
		
		
		
		
		// ���������� ����� � 2-� ��
		for (int i = 0; i < myList.size(); i++)
		{
			if(myList.get(i).getClass() == Line.class)
			{
				
				Line line_temp = (Line) myList.get(i);
				if (line_temp.isShortCircued() && line_temp.getSigh().getKzType() == 0)
				{
					
					for (int j = 0; j < myList.size(); j++ )
					{
						if (myList.get(j).getClass() == Source.class) continue;
						myList.get(j).setI(myList.get(j).getI() * 0.87);
					}
					
					break;
					
					
				}
				
				
				
			}
		}
		
		
		
		// ������ ������������� � ����
		for (int i = 0; i < myMovableList.size(); i++)
		{
			if(myMovableList.get(i).getClass() == DistanceProtection.class)
			{
				DistanceProtection temp = (DistanceProtection) myMovableList.get(i);
				temp.setImpendance();
			}
		}
		
		System.out.println("���� ����� action");
		for (int i = 0; i < myList.size(); i++)
		{
				System.out.println("I is " + myList.get(i).getI());
		}
		
		
	}

	
	public static void setPotentialsInLines(ArrayList<Integer> keyDots, ArrayList<EObject> lines, double[][] potentials )
	{
		for (int i = 0; i < keyDots.size(); i++)
		{
			for (int j = 0; j < lines.size(); j++)
			{
				System.out.println(lines.get(j).getIn() + " and " + lines.get(j).getOut());
				
				
				if  ( lines.get(j).getIn() ==  keyDots.get(i))
				{
					lines.get(j).setVin(potentials[i][0]);
				}
				else if  ( lines.get(j).getOut() ==  keyDots.get(i))
					{
					lines.get(j).setVout(potentials[i][0]);
					}
			}
		}
		
		
		
		
		
		
	//	return lines;
	}
	
	
	public void printResults(ArrayList<Integer> keyDots, EObject[] lines, double[][] potentials)
	{
System.out.println("Println");
	
		
		for (int i = 0; i < keyDots.size(); i++)
		{
			System.out.println(keyDots.get(i) + "  " + potentials[i][0]);	
		}
		
		
		System.out.println("Currents");
		for (int j = 0; j < lines.length; j++)
		{
			
			if (lines[j].getClass() == Line.class)

System.out.println(lines[j].getIn() +" "+lines[j].getOut() + " "+ lines[j].getI());
		
		}

		
	//	lines[0].setVout(10d);
		for (int j = 0; j < lines.length; j++)
		{
			// +" "+lines[j].getVin()
			
			System.out.println( j+" in coord " + lines[j].Vin.getCoord()  + " "+lines[j].getVin()    );
			System.out.println( j+" out coord "+ lines[j].Vout.getCoord()  +" "+lines[j].getVout()  );
			
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException 
	{
		System.out.println("hi there!");
		Project a = new Project();
		a.calculate();
		
//		
//		ex.loadData(3, 5);
//		ex.loadData(7, 2);
		
	}
	

	

	
	
	private static void SomeMethod(int x1, int y1, int x2, int y2)
	{
		System.out.println(x1+" "+ y2);
		System.out.println(x2+" "+ y1);
		
		Screen3 aa = new Screen3();
	//	aa.DrawSomeLine();
	}
	
	public static void SaveData()
	{
		
		System.out.println("������ �������");
		for (int i = 0; i < myList.size(); i++)
		{
			System.out.println("��� ������ - " +myList.get(i).getClass().getName()  );
			
		}
		
		
		
		String fileName = "data2.gar";
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(myMovableList);
			os.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		System.out.println("saved");

		
	
		
		
	}
	
	public static void LoadData()
	{
		String fileName = "data2.gar";
		//Switcher s2;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
			myMovableList =   (ArrayList<EMovableObject>) is.readObject();
		
				is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("������ ������� ��� ��������");
		for (int i = 0; i < myMovableList.size(); i++)
		{
			System.out.println("��� ������ - " +myMovableList.get(i).getClass().getName()  );
			
			Package Objects = Objects.EObject.class.getPackage();
			
			if (myMovableList.get(i).getClass().getPackage() == Objects)
				myList.add(  (EObject)myMovableList.get(i)  );
			
		}
		
		
		
		for (int i = 0 ; i < myMovableList.size(); i++)
		{
			myMovableList.get(i).setImage();
		}
		
		
		System.out.println("loaded");
		
	}
	
	
	public static ArrayList<EObject> getList()
	{
		return myList;
	}
	
	public static ArrayList<EMovableObject> getMovableList()
	{
		return myMovableList;
	}
	


	private static void putDataToExcel() throws IOException
	{
		
		
		
	}
	
	
	
	
	
	
	
}
