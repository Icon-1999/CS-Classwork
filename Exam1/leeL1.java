package Exam1;
// CSUN FALL 22   
// xxxxxL1.java  Lab Exam-1 COMP 182 Oct. 19, 22
// This program gets 3 integers n(<=30), m(>=5)p and x from
// program argument, Inserts n random integers from p...p+m-1
// in the sorted arr[] and deletes duplicates from sorted arr[].
//	To compile: javac xxxxxL1.java
//	To execute: java  xxxxxL1 20 8 50	  
// Prepared by: Gh. Dastghaiby Fard, 

import java.util.*;
import java.io.*;
  
// class xxxxxL1
public class leeL1{ 
	// class Variables
	protected int count = 0, arr[]; 
		 
	// use prt for System.out to save typing
	PrintStream prt = System.out;
				  
	// Insert x in sorted arr[]
	private void insertsorted(int x){
		// local variables
		int p, j;

			
			for(p = 0; p < count && x > arr[p]; p++);

    		for (j = count; j >= p; j--) {
      			arr[j+1] = arr[j];
    		}
		
			
    		arr[p] = x;   // insert x at position p
    		count++;


    	
 	} // end insertsorted
		  
	// Delete all duplicates from sorted arr[]	
	private void deletealldups(){
		// local variables
		int x, i, j, k, cnt = 0;
    //loop through arr
    //allocate x as first element in arr
    //i = 0
    for (i = 0; i <= count; i++){
        x = arr[i];
        //loop through arr to find dupe of x
        j = i+1;
        //while j < count
        while (j < count){
            //if arr[i] == x
            if (arr[j] == x){
                //delete dupe
                cnt++;
                count--;

                for (k = j; k < count; k++){
                    arr[k] = arr[k+1];
                }//endfor
                continue;
            }//endif
            j++;
        }//endwhile
    }//endfor
	} // end deletealldups()
				
	// print arr[], formatted 10 elements per line
	private void prtlst(){
		// local variables
		int i;
		prt.printf("\n\tArr contents(%d):\n\t", count);
		for (i = 0; i < count; i++){ 
			prt.printf("%4d, ", arr[i]);
			if((i+1) % 10 == 0) prt.printf("\n\t");
		}// enf for		
	} // end prtlst

	// insert n random elements in the list
	private void process(int n, int m, int p){
		// local variables
		int j, num; 
		prt.printf("\tThis program gets 3 integers n(<=30), m(>=5) and p from program argument"+
		"\n\tInserts %d random integers from %d...%d, in the sorted arr[] and deletes duplicate of from sorted arr[]:", n, p, m+p-1);
		prt.printf("\n\t\tTo compile: javac xxxxxL1.java" +
		"\n\t\tTo execute: java  leeL1 n  m  p"+
		"\n\t\tExample:    java  leeL1 20 8 50"); 	  
		
		if ( n > 30 || m < 5){
			prt.printf("\n\tInvalid values for n or m");
			return;			
		}// end if
		
		// Allocate Space for array		 	 
		arr = new int[30];
		
		// create an instance of class Random
		Random rnd = new Random();
		
		// Generate n random integers from p...p+m
		// and insert in arr[]
		for(j = 1; j <= n; j++){
			// Generate a random integers from p...p+m
			num = rnd.nextInt(m) + p;   
			insertsorted(num); //insert x in arr[]
		} // end
		
		// print arr[], formatted 10 elements per line
		prtlst();
		
		// Delete all duplicates from sorted arr[]
		deletealldups();
		
		// print arr[], formatted 10 elements per line
		prtlst();//print list elements
	} // end process
		  
	// main method
	public static void main(String args[]) throws Exception{
		// declare variables
		int n, m, p, cnt;
		// get no. of program arguments
		cnt = args.length; 
		
		if (cnt < 3){
			System.out.printf("\n\n\tOOPS Invalid No. of arguments! EXIT.\n");
			System.out.printf("\tThis program gets 3 integers n(<=30), m(>=5) and p from program argument"+
			"\n\tExample: java xxxxxL1 20 8 50"); 	  
			return;
		} // end if
						
		// get value of arguments
		n = Integer.parseInt(args[0]);
		m = Integer.parseInt(args[1]);
		p = Integer.parseInt(args[2]);

		//create an instance of a class
		leeL1 lab1 = new leeL1();
		
		// Call process method
		lab1.process(n, m, p);
					
		//Pleas replace G. Dastghaibyfard with your name in next line		
		System.out.printf("\n\n\tAuthor: Armon J. Lee Date: %s\n",
		java.time.LocalDate.now()); 
	} // end main
} // end class xxxxxL1