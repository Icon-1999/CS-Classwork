package Exam1;
// CSUN FALL 22   
// xxxxxL1Trial.java Trial Lab Exam-1 COMP 182 Oct. 17, 22
// This program gets 4 integers n(<=30), m(>=5), p and x from
// program argument, Inserts n random integers from p...p+m-1
// in the arr[] and deletes duplicates of x
// To compile: javac xxxxxL1Trial.java
// To execute: java  xxxxxL1Trial 20 8 50 52   
// Prepared by: Gh. Dastghaiby Fard, 
import java.util.*;
import java.io.*;
  
// class xxxxxL1Trial
public class leeL1Trial{ 
// class Variables
protected int count = 0, arr[]; 
 
// use prt for System.out to save typing
PrintStream prt = System.out;
  
// Insert x in after last element
public void insert(int x){
// local variables
   arr[count] = x;
count++;
} // end insert
  
// if x is duplicate delete it and return no. of duplicates
public void deletedup(int x){
// local variables
int i, j, k, cnt = 0; 
// Find first x
for (i = 0 ; i < count && arr[i] != x ; i++);  
// end for
j = i+1;
while ( j < count){  
if (arr[j] == x){// delete x
cnt ++; // add no. of duplicates
count--; // decrease no. of elements
// Shift to left
for (k = j ; k < count; k++)
arr[k] = arr[k+1];
// end for
continue; // next iteration
} // end if
j++;
} // end while
prt.printf("\n\t\t%d duplicates of %2d:", cnt, x);
} // end deletedup

public void deletealldup(){
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
}//end deletealldup

// print arr[], formatted 10 elements per line
public void prtlst(){
// local variables
int i;
prt.printf("\n\tarr contents(%d):\n\t", count);
for (i = 0; i < count; i++){ 
prt.printf("%4d, ", arr[i]);
if((i+1) % 10 == 0) prt.printf("\n\t");
}// enf for
} // end prtlst
// insert n random elements in the list
private void process(int n, int m, int p, int x){
// local variables
int j, num; 
prt.printf("\tThis program gets 4 integers n(<=30), m(>=5), p and x from program argument"+ 
"\n\tInserts %d random integers from %d...%d, in the arr[] and deletes duplicate of %d:", n, p, m+p-1, x);
prt.printf("\n\t\tTo compile: javac xxxxxL1Trial.java" +
"\n\t\tTo execute: java  xxxxxL1Trial n  m  p  x"+
"\n\t\tExample:    java  xxxxxL1Trial 20 8 50 52");    
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
insert(num); //insert x in arr[]
} // end
// print arr[], formatted 10 elements per line
prtlst();
// if x is duplicate in arr[], delete it and print no. of duplicates
deletealldup();
// print arr[], formatted 10 elements per line
prtlst();//print list elements
} // end process
  
// main method
public static void main(String args[]) throws Exception{
// declare variables
int n, m, p, x, cnt;
// get no. of program arguments
cnt = args.length; 
if (cnt < 3){
System.out.printf("\n\n\tOOPS Invalid No. of arguments! EXIT.\n");
System.out.printf("\tThis program gets 4 integers n(<=30), m(>=5), p and x from program argument"+
"\n\tExample: java xxxxxL1Trial 20 8 50 52");    
return;
} // end if
// get value of arguments
n = Integer.parseInt(args[0]);
m = Integer.parseInt(args[1]);
p = Integer.parseInt(args[2]);
x = Integer.parseInt(args[3]);
//create an instance of a class
leeL1Trial lst = new leeL1Trial();
// Call process method
lst.process(n, m, p, x);
//Pleas replace G. Dastghaibyfard with your name in next line
System.out.printf("\n\n\tAuthor: G. Dastghaibyfard Date: %s\n",
java.time.LocalDate.now()); 
} // end main
} // end class xxxxxL1Trial