import java.io.*;
import java.util.*;

public class leeheap {
    protected int arr[];

    PrintStream prt = System.out;

    private void heapup(int j){
        int swap;
        while (j > 1 && arr[j] > arr[j/2]){
            swap = arr[j];
            arr[j] = arr[j/2];
            arr[j/2] = swap;
            j = j/2;
        }
    }

    private void prtlst(int n){
        // local variables
        int i;
        prt.printf("\n\tarr contents(%d):\n\t", n);
        
        for (i = 1; i <= n; i++){ 
            prt.printf("%4d, ", arr[i]);
            if((i+1) % 10 == 0) prt.printf("\n\t");
        }// enf for
    } // end prtlst

    private void process(int n, int a, int b){
        int j, num;
        
        arr = new int[n+1];

        Random rnd = new Random();
        // Generate n random integers
        // and insert in arr[]
        for(j = 1; j <= n; j++){
        // Generate a random integers from a to b
        num = rnd.nextInt(b) + a;
        arr[j] = num; //insert x in arr[]
        } // end
        prtlst(n);
        for (j = 2; j <= n; j++)
            heapup(j);

        prtlst(n);
    }

    public static void main(String[] args) throws Exception {
        
        int n, a, b, cnt;
		// get no. of program arguments
		cnt = args.length; 
		
		if (cnt < 3){
			System.out.printf("\n\n\tOOPS Invalid No. of arguments! EXIT.\n");
			System.out.printf("\tThis program gets 3 integers n, a, and b from program argument"+
			"\n\tExample: java leeheap 20 10 30"); 	  
			return;
		} // end if
						
		// get value of arguments
		n = Integer.parseInt(args[0]);
        a = Integer.parseInt(args[1]);
        b = Integer.parseInt(args[2]);

		//create an instance of a class
		leeheap heap = new leeheap();
		
		// Call process method
		heap.process(n, a, b);
					
		//Pleas replace G. Dastghaibyfard with your name in next line		
		System.out.printf("\n\n\tAuthor: Armon J. Lee Date: %s\n",
		java.time.LocalDate.now());
    }
}
