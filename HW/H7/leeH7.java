import java.util.*;
import java.io.*;

public class leeH7 {

    protected int arr[];

    PrintStream prt = System.out;

    private void gensorted(int arr[], int k){
        Random rnd = new Random();
        int i;
        arr[0] = rnd.nextInt(100);
        for(i = 1; i < k; i++){
            // Generate a random integers from a to b
            arr[i] = rnd.nextInt(20) + arr[i-1];
        } // end
    }

    private void merge(int a[], int m, int b[], int n, int c[]){
        int x, y, count = 0, i = 0, j = 0;

        while (i < m && j < n){
            x = a[i];
            y = b[j];

            if (x < y){
                c[count] = x;
                i++;
                count++;
            }
            else{
                c[count] = y;
                j++;
                count++;
            }
        }

        while (i < m){
            x = a[i];
            c[count] = x;
            i++;
            count++;
        }
        while (j < n){
            y = b[j];
            c[count] = y;
            j++;
            count++;
        }
    }

    private void process(int m, int n){
        int a[], b[],c[];

        a = new int[m+1];
        b = new int[n+1];
        c = new int[m+n+2];

        if (m < 0 || n < 0){
            prt.print("Oops, invalid input -- m < 0 or n < 0");
            return;
        }

        prt.printf("\n\tThis program inserts m = %s sorted random numbers into Array A and m = %s" + 
        "\n\tsorted random numbers into Array B, then mearges both Arrays into Array C.\n", m, m);

        prt.printf("\n\tArray A (%s): \n\t", m);
        gensorted(a, m);
        prtarr(a, m);

        prt.printf("\n\n\tArray B (%s): \n\t", n);
        gensorted(b, n);
        prtarr(b, n);

        prt.printf("\n\n\tArray C (%s): \n\t", m+n);
        merge(a, m, b, n, c);
        prtarr(c, n+m);

    }

    private void prtarr(int arr[], int k){
        int count = 0;
        for(int i = 0; i < k; i++){
            prt.printf("%4s ", arr[i]);
            count++;

            if(count % 10 == 0){
                prt.printf("\n\t");
            }
        }
    }

    public static void main(String[] args) throws Exception{
		int m, n, cnt;
		cnt = args.length; // get no. of atguments
		if (cnt < 2){
		    System.out.printf("\n\tOOOPS Invalid No. of aguments!"+
			"\n\tTO Execute: java leeH7 m n");
			return;
		} // end if	
		
		// get input n, a and b
		m = Integer.parseInt(args[0]);
		n = Integer.parseInt(args[1]);
			
		//System.out.printf("\n fn=%s, array n=%d", fn, n);
		System.out.printf("\n\tleeH7: n=%d, m=%d\n\t", m, n);
			
		// create an instance of xxxxxH6 class
		leeH7 srt = new leeH7();
		
		// call process method 
		srt.process(m, n); 
			
		//MAKE SURE TO WRITE YOUR NAME IN NEXT LINE		
		System.out.printf("\n\tAuthor: Armon J. Lee Date: " +
			java.time.LocalDate.now()); 
    }
}
