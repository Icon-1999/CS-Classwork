import java.io.*;
import java.util.*;

public class leemergejkm {

    PrintStream prt = System.out;

    private void heapsortjk(int arr[], int j, int k){
        int m;// convert to max heap using heapdn 
		for (m = n/2; m >= 1; m--) 
			heapdn(m, n); // convert to max heap using heapdn 
		// end for 
		for(m = n; m > 1; m --){ 
			swap(1, m); // // swap arr[1] and arr[j], i.e. arr[j] is in its final sorted position      
			heapdn(1, m - 1); // convert arr[1] and arr[j-1] to max heap using heapdn 
		} // end for 
    }

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

    

    private void process(int n, int j, int k, int m, String fname){

    }

    public static void main(String[] args) throws Exception{
		int n, j, k, m, cnt;
        String fname;
		cnt = args.length; // get no. of atguments
		if (cnt < 4){
		    System.out.printf("\n\tOOOPS Invalid No. of aguments!"+
			"\n\tTO Execute: java xxxxxH6 20 100 200");
			return;
		} // end if	
		
		// get input n, a and b
		n = Integer.parseInt(args[0]);
		j = Integer.parseInt(args[1]);
		k = Integer.parseInt(args[2]);
        m = Integer.parseInt(args[3]);
        fname = args[4];  
			
		//System.out.printf("\n fn=%s, array n=%d", fn, n);
		System.out.printf("\n\t leemergejkm: n=%d, j=%d, k%d, m=%d", n, j, k, m);
			
		// create an instance of xxxxxH6 class
		leemergejkm srt = new leemergejkm();
		
		// call process method 
		srt.process(n, j, k, m, fname); 
			
		//MAKE SURE TO WRITE YOUR NAME IN NEXT LINE		
		System.out.printf("\n\tAuthor: Armon J. Lee Date: " +
			java.time.LocalDate.now()); 
	}	// end main
}// class xxxxxH6