package com.project;

import java.util.Scanner;

public class MyAppThread implements Runnable {
	

	static int[] Array;
	static int[] cloneArray;
	 static int[] cloneArray2;
	 static int[] cloneArray3;
	 
	public void run(){
		
		cloneArray = Array.clone();
		cloneArray2= cloneArray.clone();
		cloneArray3= cloneArray.clone();
		
		Thread t = Thread.currentThread();
		
		if(t.getName().equals("bubble")){
			System.out.println("Using Thread Buublesort is called");
			bubbleSort(cloneArray);
			
		}
		else if(t.getName().equals("selection")){
			System.out.println("Using Thread SelectionSort is called");
			cloneArray2 = cloneArray.clone();
			selectionSort(cloneArray2);
		}
		else if (t.getName().equals("insertion")) {
			System.out.println("Using Thread Insertionsort is called");
			cloneArray3 =  cloneArray.clone();
			insertionSort(cloneArray3);
		}
	}
	public static void bubbleSort(int[] array){
		int size = array.length;
		int swap = 0;
		long starttime = System.currentTimeMillis();
		for (int i = 0; i < ( size - 1 ); i++) {
		      for (int j = 0; j < size - i - 1; j++) {
		        if (array[j] > array[j+1]) /* For descending order use < */
		        {
		          swap       = array[j];
		          array[j]   = array[j+1];
		          array[j+1] = swap;
		        }
		      }
		    }
		 
		    //System.out.println("Bubble Sort list of numbers");
		 
		    /*for (int i = 0; i < size; i++) 
		      System.out.println(array[i]);
		  */
		    long endtime = System.currentTimeMillis();
		 System.out.println("Total completed Time for Bubble Sort is :" + (endtime - starttime));
	}

	//selection sort
	
	public static void selectionSort(int[] array){
		long starttime = System.currentTimeMillis();
		
        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[index])
                    index = j;
      
            int smallerNumber = array[index]; 
            array[index] = array[i];
            array[i] = smallerNumber;
        }
		long endtime = System.currentTimeMillis();
		
        //System.out.println("Selection Sort list of numbers");
        
        /*for(int i=0;i<array.length-1;i++){
        	System.out.println(array[i]);
        }*/
        System.out.println("Total completed Time for Selection sort is :" + (endtime - starttime));
    }
	
//insertion sort
	 public static void insertionSort(int array[]) {
		 
	        int n = array.length;
	     long starttime = System.currentTimeMillis();
	        for (int j = 1; j < n; j++) {
	            int key = array[j];
	            int i = j-1;
	            while ( (i > -1) && ( array [i] > key ) ) {
	                array [i+1] = array [i];
	                i--;
	            }
	            array[i+1] = key;
	        }
	         long endtime = System.currentTimeMillis();
			
	       // System.out.println("Insertion Sort list of numbers");
	        /*for(int i=0;i<array.length;i++)
	        	System.out.println(array[i]);
	        */
	         System.out.println("Total completed Time for insertion sort is :" + (endtime - starttime));
	    }
	 
	
	public static void main(String[] args) {
		MyAppThread app = new MyAppThread();
		
		System.out.println("Enter Array Size : ");
		Scanner s = new Scanner(System.in);
		
		int size = s.nextInt();
		Array = new int[size];
		cloneArray = new int[size] ;
		cloneArray2 = new int[size] ;
		cloneArray3= new int[size] ;
		 System.out.println("Chooce Complexity ");
		 System.out.println("1. Best Case Senario");
		 System.out.println("2. Average Case Senario");
		 System.out.println("3. Worst Case Senario");
		 
		 int choice = s.nextInt();
			
		 switch (choice) {
			case 1:
				System.out.println("You have Selected Best Case Senario");
				for(int i=0;i<size;i++){
					Array[i]  = i+1;			
				}
				cloneArray = Array.clone();
				break;
			case 2:
				System.out.println("You have Selected Average Case Senario");
				for(int i=0;i<size;i++){
					Array[i] =(int)(Math.random()*100);			
				}
				cloneArray = Array.clone();
				break;
			case 3:
				System.out.println("You have Selected Worst case senario");
				for(int i=size-1;i>=0;i--){
					Array[i] = i+1;
					//System.out.println(Array[i]);
				}
				cloneArray = Array.clone();
				break;
					
			default:
				System.out.println("Please, Select Right Option");
				break;
			}
			
			System.out.println("Please Choose Algorithm :");
			System.out.println("1.Bubble Sort");
			System.out.println("2.Selection Sort");
			System.out.println("3.Insertion Sort");
			System.out.println("4.All BenchMark Call");
			int algo = s.nextInt();
			switch (algo) {
			case 1:
				bubbleSort(cloneArray);/*in the same file no need  to call with class name can directly  call static method*/
				break;
			case 2:
				selectionSort(cloneArray);
				break;
			case 3:
				insertionSort(cloneArray);
				break;
			case 4:
				Thread t1= new Thread(app,"bubble");
				Thread t2 =new Thread(app,"selection");
				Thread t3 = new Thread(app,"insertion");
				t1.start();
				t2.start();
				t3.start();
				break;
			default:
				break;
			}
			s.close();
	}

}
