package H1;

import java.util.*;
import java.io.*; 

 // CSUN FALL 22   COMP 182 
 // xxxxxlstarr.java is Array implementation of lstinterface.java:  
 // Prepared by: Gh. Dastghaiby Fard, Sep 12,22 
  

    
 // listinterface is an interface   
 public class leeh1 implements lstinterface {
   // class Variables 
   int size, count = 0;
   
   String arr[];
       
   // use prt for System.out to save typing 
   PrintStream prt = System.out;
            
   // Insert x at position p, for successful insertion: 
   // Array should not be full and 1 <= p <= count+1 <= size 
   public int insertlst(String x,  int p){ 
     int i; // local variable 
     prt.printf("\n\t\tInsert %4d at position %2d:", x, p); 
     if (size == count || p < 1 || p > count+1){ 
       prt.printf(" Failed insertion.");      
       return 0;  // invalid insertion 
     } // end if 
        
     // shift array elements to right from position count downto p  
     for (i = count ; i >= p ; i--)   
       arr[i+1] = arr[i]; 
     // end for 
                
     arr[p] = x;   // insert x at position p 
     count++; // increment no. of elements. 
     prt.printf(" Successful insertion."); 
     return 1; 
   } // end insertlst
        
   // Delete element at position p, for successful deletion: 
   // List should not be empty and 1 <= p <= count 
   public int deletelst(int p){ 
     int i; // local variable 
     prt.printf("\n\t\tDelete element at position %2d:", p); 
     if ( count == 0 || p < 1 || p > count){  
       prt.printf(" Invalid position for deletion."); 
       return 0;   // invalid deletion 
     } // end if 
            
     // Shift array elements from position p + 1 to count to left 
     for (i = p ; i < count ; i++)   
       arr[i] = arr[i+1]; 
     // end for 
        
     count --;   // decrement no. of list elements 
     prt.printf(" Successful deletion.");   
     return 1;  // successful deletion 
   } // end deletelst 
        
   // Sequential search for x in the list 
   // if successful return position of x in the 
   // list otherwise return 0; 
   public int searchlst(String x){ 
     prt.printf("\n\t\tSearch for %4d:", x); 

     for (int i = 0; i <= arr.length; i++){
        String y = arr[i];
        
        if (x == y) {
            prt.print(arr[i]);
        }
     }
     // Complete the rest of the method 
     return 0; // x is not found 
   } // end searchlst 
          
   // Print list elements formatted  
   public void prtlst(){ 
     int i;  // local variable 
     prt.printf("\n\tList contents: "); 
     for (i = 1; i <= count; i++)  
       prt.printf("%4s, ", arr[i]);
     // enf for
   } // end prtlst 

   public int insertSorted(String x) {
    int p;
    int j;
    
    prt.printf("\n\t\tInserting %s", x);

    if (count == size) {
      prt.print("Array full");
      return 0;
    }

    for(p = 1; p <= count && x.compareTo(arr[p]) > 0; p++);

    for (j = count; j>=p; j--) {
      arr[j+1] = arr[j];
    }
      
    arr[p] = x;   // insert x at position p
    count++;

    return 1;
  }



   public int searchSorted(String x) {
    int p;
    // loop through arr

    prt.printf("\n\n\tSearching for %s", x);

    for (p = 1; p <= count; p++) {

      // if y = arr[i] == x
      if (x.compareTo(arr[p]) == 0 && p <= count) {

        prt.printf("\n\t\t%s is in position %d", x, p);      // retun postion or i
        break;// end loop if found
      }
        prt.printf("%s not in list", x);
        break;
    }
    return 1;
   }

   public int deleteSorted(String x){
    int p, j;
    
    // loop through arr
    for (p = 1; p <= count; p ++) {

      // if y = arr[i] == x
      if (x.compareTo(arr[p]) == 0 && p <= count) {
        // Shift array elements from position p + 1 to count to left 
        // delete y
        // return arr
        for (j = p; j <= count; j++)   
       arr[j] = arr[j+1];
        
       count--;

       prt.printf("\n\t\tFinding and deleting %s", x);

       prt.printf("\n\t\tSuccessful deletion.");
       prt.printf("\n");
       break;
      }
    }

    return 1;
   }
  
   // insert, delete and search in the list 
   private void process(String fn){ 
     int j, nIns, nSrch, nDel, k, p;  // local variables 
     String x;
  
     prt.printf("\tArray implementation of integer list, gets input"+ 
     "file name from program argument, then reads:"+ 
     "\n\tinteger array size,\n\tinteger No. of elements to insert"+ 
     " followed by elements to insert and their positions,"+ 
     "\n\tinteger No. of elements to search followed by element to"+ 
     "search"+ 
     "\n\tinteger No. of elements to delete followed by position of"+ 
     "elements to delete" +      
     "\n\t\tTo compile: javac xxxxxlstarr.java" + 
     "\n\t\tTo execute: java  xxxxxlstarr inputfilename");     
            
     try{   
       // open input file 
       Scanner inf = new Scanner(new File(fn));  
              
       //read array size 
       size = inf.nextInt(); 
       // Allocate Space for array         
       arr = new String[size+1];// index 0 is not used 
       prt.printf("\n\tCreating an array of size %3d:",size); 
              
       //read no. of elements to insert 
      nIns = inf.nextInt();             
      prt.printf("\n\n\tInsert %d elements in the list.", nIns); 
      for(j = 1; j <= nIns; j++){ 
        x = inf.next();   // read x  
        k = insertSorted(x); //insert x at position p 
      } // end for 
      prtlst();//print  list elements
      //read no. of elements to search in list 
      nSrch = inf.nextInt();  
      prt.printf("\n\n\tSearch for %d elements in list.", nSrch); 
      for(j = 1; j <= nSrch; j++){ 
        x = inf.next(); // read x to search 
        k = searchSorted(x);  // Search for x 
      }// end for   
  
      //read no. of positions to delete from list 
      nDel = inf.nextInt();  
      prt.printf("\n\n\tDelete %d elements from list.", nDel); 
      for(j = 1; j <= nDel; j++){ 
        x = inf.next();   // read position 
        k = deleteSorted(x);    // delete element at position p 
      }// end for 
      prtlst();//print list elements 
  
      // close input file      
      inf.close();    
    }catch (Exception e){prt.printf("\n\tRead Error! %s", e);} 
  } // end process 

  
       
  // main method 
  public static void main(String args[]) throws Exception{ 
    // declare local variables 
    int cnt = args.length; // get no. of atguments 
    String H1; 
  
    //create an instance of a class 
    leeh1 lst = new leeh1();     
  
    // get no. of  arguments     
    cnt = args.length;  
             
    if (cnt < 1){ 
      System.out.printf("\n\n\tOOPS Invalid No. of aguments! EXIT.\n"); 
      return; 
    } // end if 
             
    // get input file name 
    H1 = args[0];  
     
    // Call process method 
    lst.process(H1); 
     
    //Pleas replace G. Dastghaibyfard with your name in next line     
    System.out.printf("\n\n\tAuthor: Armon J. Lee Date: %s\n", 
    java.time.LocalDate.now());  
  } // end main 
 } // end class xxxxxlstarr