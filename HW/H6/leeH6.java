package H6;
// CSUN Fall 22 COMP182 Hwk-6   heap sort   
// Author: G. Dastghaiby Fard
import java.util.*;
import java.io.*;

public class leeH6 {
    protected int arr[]; 	
		
	//use prt for System.out to save typing
    PrintStream prt = System.out;

    // swap arr[m] and arr[n]
	protected void swap(int m, int n){
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
	
    // sort arr[1] thru arr[n] using heap sort 	
    public void heapsort(int n){   // sort in increasing order                  
		int m;// convert to max heap using heapdn 
		for (m = n/2; m >= 1; m--) 
			heapdn(m, n); // convert to max heap using heapdn 
		// end for 
		for(m = n; m > 1; m --){ 
			swap(1, m); // // swap arr[1] and arr[j], i.e. arr[j] is in its final sorted position      
			heapdn(1, m - 1); // convert arr[1] and arr[j-1] to max heap using heapdn 
		} // end for 
	} //end heapsort ()
	 // heapsort	  

	// convert arr[m] thru arr[1] to max heap using heapup
	protected void heapup(int m){
		while (m > 1 && arr[m] > arr[m/2]){
			swap(m, m/2);
            m = m/2;
        }
    } // end heapup


	// convert arr[m] thru arr[n] to max heap using heapdn
	protected void heapdn(int m, int n){
		while (2 * m  <= n) {
			int lc = 2 * m;   // index of left child of j 
			int val = arr[lc];
			if (lc+1 <= n && arr[lc+1] >= val ) { 
				lc = lc+1; 
				val = arr[lc]; 
			} // end if 
			// check if subtree with root m is ? than its children 
			if (arr[m] <= arr[lc]) { 
				swap(m, lc); 
				m = lc;   // convert to max heap from subtree with root j 
			} 
			else // already a max heap, exit while loop 
				break; //  
		} // end while 
	} // end heapdn (int j, int n)   
    // end heapdn
	
	// print arr[] formatted 10 numbers per line
    public void prtarr(int n){
		prt.printf("\n\t(%d):", n);
		for (int i = 1; i <= n; i++) 
			prt.printf("%3d ", arr[i]);
    }

    // print arr[1] thru arr[n] as a CBT level by level	
    public void levelbylevel(int n){
		int i, count = 1;
		for (i = 1; i <= n; i++){
			
			if (i == count){
				prt.print("\n\t");
				count = count * 2;
			}

			prt.printf("%s ", arr[i]);
		}
    }

   // process method for heap sort
   private void process(int n, int a, int b){ 
      int i, range;
	  prt.print("\n\tHeap sort " +
	  "\n\t\tTo compile: javac xxxxxH6.java" +
		"\n\t\tTo execute: java  xxxxxH6 n a b"+
		"\n\t\t   Example: java  xxxxxH6 20 400 1000");
		//Allocate space for arr
		arr =  new int[n+1];
		Random r = new Random();		
		range = b - a + 1;
		for(i=1; i <= n; i++) 
			arr[i] = r.nextInt(range)+a;
		// endfor
		prt.printf("\n\tInput\t");
		prtarr(n); // print arr[]

		// Call heapsort
		heapsort(n);
		
		prt.printf("\n\tSorted arr[]");
		prtarr(n); // print arr[]
		
		//Print CBT tree(arr[]) Level by Level
		prt.printf("\n\tCBT Level by Level");
		levelbylevel(n);
   } //end process method		

  public static void main(String[] args) throws Exception{
		int n, a, b, cnt;
		cnt = args.length; // get no. of atguments
		if (cnt < 3){
		    System.out.printf("\n\tOOOPS Invalid No. of aguments!"+
			"\n\tTO Execute: java xxxxxH6 20 100 200");
			return;
		} // end if	
		
		// get input n, a and b
		n = Integer.parseInt(args[0]);
		a = Integer.parseInt(args[1]);
		b = Integer.parseInt(args[2]);
			
		//System.out.printf("\n fn=%s, array n=%d", fn, n);
		System.out.printf("\n\txxxxxH6: n=%d, a=%d, b%d", n, a, b);
			
		// create an instance of xxxxxH6 class
		leeH6 srt = new leeH6();
		
		// call process method 
		srt.process(n, a, b); 
			
		//MAKE SURE TO WRITE YOUR NAME IN NEXT LINE		
		System.out.printf("\n\tAuthor: Armon J. Lee Date: " +
			java.time.LocalDate.now()); 
	}	// end main
}// class xxxxxH6