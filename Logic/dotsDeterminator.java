package Logic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.xml.transform.Source;

import Objects.EObject;
import Objects.Line;

public class dotsDeterminator {

	public static double[][] getMatrixResistors(ArrayList<EObject> Lines2){
		
		EObject[] Lines = ArrayListToArray(Lines2);
		
		
		ArrayList<Integer> a2 = dotsDeterminator.getKeyDots(Lines2);
	
	double[][] elements = new double[a2.size()][a2.size()];
	
	
	
	for(int j = 0; j < a2.size(); j++)
	{
		for(int k = 0; k < a2.size(); k++)
		{
		
		
			
			double b = 0;
			for(int i = 0; i < Lines.length; i++)
			{
				
				if (j==k) 
				{
					if (Lines[i].getIn() == a2.get(j) || Lines[i].getOut() == a2.get(j))
						{
						b +=1/Lines[i].getR() ;
						}
				}
				else if (  (Lines[i].getIn() == a2.get(j) && Lines[i].getOut() == a2.get(k)) || 
						(Lines[i].getIn() == a2.get(k) && Lines[i].getOut() == a2.get(j))  )
				{
					b -= 1/Lines[i].getR();
				}
					
					
			
			}
	
			elements[j][k] = b;
		
			
			
		}
	
	}
	
	System.out.println("resistors");
	printArray(elements);
		return elements;
	}

	public static ArrayList<Integer> getKeyDots(ArrayList<EObject> Lines2){
	
		EObject[] Lines = ArrayListToArray(Lines2);
		
		// create and fill ArrayList with all dots
				ArrayList<Integer> a2 = new ArrayList<Integer>();
				for (int i = 0; i < Lines.length; i++)
				{
					a2.add(Lines[i].getIn());
					a2.add( Lines[i].getOut());
				}
				
				
				
				// clear all dublicats
				a2 = cutOffDublucats(a2,0);
				
				for (int i = 0; i < a2.size(); i++)
				{	
					for (int j = 0; j < Lines.length; j++)
					{
						if( Lines[j].getClass() == Objects.Source.class && Lines[j].getIn() == a2.get(i))
						{
							System.out.println("Source haha");
							a2.remove(i);
						}
					}
				}
				
		return a2;
	}
	
		public static double[][] getMatrixPotentials(ArrayList<EObject> Lines2)
		{
			
			EObject[] Lines = ArrayListToArray(Lines2);
			
			ArrayList<Integer> a2 = dotsDeterminator.getKeyDots(Lines2);
			
			
			double[][] a = new double[Lines.length][1];
			
			System.out.println("Start E");
			for (int i = 0; i < a2.size(); i++)
			{
				double E = 0;
				for (int j = 0; j< Lines.length; j++)
				{
					if (Lines[j].getIn() == a2.get(i) || Lines[j].getOut() == a2.get(i)) E += Lines[j].getE()/Lines[j].getR();
				}
				a[i][0] =E;

			}

			for (int i = 0; i < a.length; i++)
			{
				System.out.println( a[i][0] );
				
			}
			
			System.out.println("potentials");
			printArray(a);
			return a;
		}
	
	
	
	
	// method to delete all dublicats
	private static ArrayList<Integer> cutOffDublucats(ArrayList<Integer> a1, int keyZeroPotential)
	{
		
		
		for (int i = 0 ; i < a1.size(); i++)
		{
			for (int j = i+1; j < a1.size(); j++)
			{
				if (a1.get(i) == a1.get(j)) a1.remove(j);	
			}
		}
		
		// need to correct this (double loop)
		for (int i = 0 ; i < a1.size(); i++)
		{
			for (int j = i+1; j < a1.size(); j++)
			{
				if (a1.get(i) == a1.get(j)) a1.remove(j);	
			}
		}

//		for (int i = 0 ; i < a1.size(); i++)
//		{
//		
//				if (a1.get(i) == keyZeroPotential) a1.remove(i);	
//	
//		}
		
		
		return a1;
	}
	
	
	public static void printArrayList(ArrayList<Object> array)
	{
		
		for (int i = 0; i < array.size(); i++)
		System.out.println(i + " element is " + array.get(i));
		
	}
	
	public static void printArray(double[][] array)
	{
		
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[0].length; j++)
		System.out.println(i +" "+ j + " element is " + array[i][j]);
		
		
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[0].length; j++)
			{
				System.out.print(array[i][j]+" ");
			}
				
			System.out.println();
			
		}
			
		
	}
	
	
	private static EObject[] ArrayListToArray(ArrayList<EObject> Lines)
	{
		int size = Lines.size();
		
	
		EObject[] ar = new EObject[size];
		
		for (int i = 0; i < size; i++)
		{
			ar[i] = Lines.get(i);
			
			
		}
		return ar;
	}
	
}
