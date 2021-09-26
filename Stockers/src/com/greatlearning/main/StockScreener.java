package com.greatlearning.main;

import java.util.Scanner;
import java.util.*;

public class StockScreener {
	
	private final static Scanner sc = new Scanner(System.in);
	public int l_noCompanies = 0;
	Boolean[] l_priceTrack;
	HashMap<Integer, Double> l_map = new HashMap<Integer, Double>();	

	public void InputData()
	{
		System.out.println("Enter the no of companies");
		l_noCompanies = sc.nextInt();
		l_priceTrack = new Boolean[l_noCompanies];
		double temp = 0;
		boolean flag = false;
		
		for(int i=0; i<l_noCompanies; i++)
		{
			System.out.println("Enter current stock price of the company "+(i+1));
			temp = sc.nextDouble();
			l_map.put(i,temp);
			
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			flag = sc.nextBoolean();
			l_priceTrack[i] = flag;
		}			
	}
	
	public void Display()
	{
		System.out.println("");
		System.out.println("");
		System.out.println("-----------------------------------------------");
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. press 0 to exit");
		System.out.println("-----------------------------------------------");
		
		int l_choice = sc.nextInt();
		double[] l_sortedPrices = new double[l_noCompanies];
		double[] l_sortedPricesDesc = new double[l_noCompanies];
		
		for(int i=0; i<l_noCompanies; i++)
		{
			l_sortedPrices[i] = l_map.get(i);
		}
		
		MergeSortImplementation ms = new MergeSortImplementation();
		ms.sort( l_sortedPrices, 0, l_sortedPrices.length - 1 );
		
		switch(l_choice)
		{
			case 1:
				System.out.println("Stock prices in ascending order are :");
				for(int i=0; i<l_noCompanies; i++)
				{
					System.out.print(l_sortedPrices[i]+" ");
				}
				System.out.println("");
				//System.out.println(Arrays.toString(l_sortedPrices));
				break;
			case 2:
				System.out.println("Stock prices in descending order are :");
				for(int i=l_noCompanies-1; i>=0; i--)
				{
					System.out.print(l_sortedPrices[i]+" ");
				}
				System.out.println("");
				break;
			case 3:
				int l_count = 0;
				for(int i=0; i<l_noCompanies; i++)
				{
					if(l_priceTrack[i])
					{
						l_count++;
					}
				}
				System.out.println("Total no of companies whose stock price rose today : "+l_count);
				break;
			case 4:
				l_count = 0;
				for(int i=0; i<l_noCompanies; i++)
				{
					if(!l_priceTrack[i])
					{
						l_count++;
					}
				}
				System.out.println("Total no of companies whose stock price declined today : "+l_count);
				break;
			case 5:
				System.out.println("Enter the key value");
				double l_search = sc.nextDouble();
				for(int i=0; i<l_noCompanies; i++)
				{
					if(l_sortedPrices[i] == l_search)
					{
						System.out.println("Stock of value "+l_search+" is present");
						break;
					}
					else
					{
						System.out.println("Value not found");
					}
				}
				break;
			case 0:
				System.out.println("Exited successfully");
				System.exit(0);
			default:
				System.out.println("Invalid option");
				break;
		}
		
		
	}
	
	public static void main(String args[])
	{
		StockScreener ss = new StockScreener();
		ss.InputData();
		
		while(true)
		{
			ss.Display();
		}
	}
	
}
