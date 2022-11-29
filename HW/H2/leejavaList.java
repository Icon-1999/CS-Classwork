package H2;
//	CSUN FALL 22   COMP 182
//	xxxxxjavaList.java 
//	insert, delete and search in List implemented with ArrayList
//	Prepared by: Gh. Dastghaiby Fard Sep. 28, 22
import java.util.*;
import java.io.*;
  
// Example of java ArrayList utility
public class leejavaList{ 
	// class Variables
	//creating integer list with mixed type	   
	//List         lst = new ArrayList();   
	//creating integer list with ArrayList	   
	List <Integer> lst = new ArrayList();   
	
	// use prt for System.out to save typing
	PrintStream prt = System.out;				  
				
	// Print formatted list elements 
	public void prtlst(){
		// local variables
		prt.printf("\n\t\t%d elements are in the List:", lst.size());
		//prt.print(lst);  // OR next line
		//for(i = 0;i < lst.size();i++) 
			// Assuming integer list
			//prt.printf(" %d, ",lst.get(i));
		// end for
		for(Object x: lst)
			// Assuming integer list
			prt.printf("%5d,", x);	
		// enf for		
	} // end prtlst

	// insert, delete and search in List 
	// implemented with ArrayList
	private void process(String fn){
		// local variables
		int j, nIns, nSrch, nDel, size, p, x; 

		prt.printf("\tUse of Java ArrayList to insert, search and delete"+
		" in a list.\n\tThis program gets input file name from program argument, then reads:"+
		"\n\tinteger No. of elements to insert"+
		" followed by elements to insert and their positions,"+
		"\n\tinteger No. of elements to search followed by element to"+
		" search"+
		"\n\tinteger No. of elements to delete followed by position of"+
		" elements to delete" + 	  
		"\n\t\tTo compile: javac xxxxxjavaList.java" +
		"\n\t\tTo execute: java  xxxxxjavaList inputfilename"); 	  
				  
		try{  
			// open input file
			Scanner inf = new Scanner(new File(fn)); 
						
			//read no. of elements to insert
			nIns = inf.nextInt();						
			prt.printf("\n\tInsert %d elements in the list.", nIns);
			for(j = 1; j <= nIns; j++){
				x = inf.nextInt();   // read x
				p = inf.nextInt();  // read position 
				prt.printf("\n\t\tInsert %4d at position %2d:", x, p);
				size = lst.size(); // get size of list
				if (p >=0 && p <= size){
					lst.add(p, x); //insert x at position p
					prt.printf(" Inserted!");				
				}
				else 
					prt.printf(" Invalid Position");

			} // end for
			prtlst();//print list elements
					
			//read no. of elements to search in list
			nSrch = inf.nextInt(); 
			prt.printf("\n\tSearch for %d elements in list.", nSrch);
			for(j = 1; j <= nSrch; j++){
				x = inf.nextInt(); // read x to search
				prt.printf("\n\t\tindex of %5d is: %d", x, lst.indexOf(x));
			}// end for	

			//read no. of positions to delete from list
			nDel = inf.nextInt(); 
			prt.printf("\n\tDelete %d elements from list.", nDel);
			for(j = 1; j <= nDel; j++){
				p = inf.nextInt();   // read position
				prt.printf("\n\t\tdelete element at position %2d:", p);
				size = lst.size(); // get size of list
				if (p >= 0 && p < size){ // && p >= 0)
					lst.remove(p); //delete element at position p
					prt.printf(" Deleted!");				
				}
				else 
					prt.printf(" Invalid Position");				
			}// end for
			prtlst();//print list elements

			// close input file 		
			inf.close();   
		}catch (Exception e){prt.printf("\n\tRead Error! %s", e);}
		
	//Total input: nIns*2 +1+nSrch +1+nDel= nIns*2 + nSrch + nDel + 3
	} // end process

	public static void main(String args[]) throws Exception{
		// declare variables
		int cnt = args.length; // get no. of arguments
		String fname;
						
		if (cnt < 1){
			System.out.printf("\n\n\tOOPS Invalid No. of arguments! EXIT.\n");
			return;
		} // end if
						
		// get input file name
		fname = args[0];

		//create an instance of a class
		leejavaList g = new leejavaList();
		
		// Call process method
		g.process(fname);
					
//Pleas replace G. Dastghaibyfard with your name in next line		
	System.out.printf("\n\n\tAuthor: G. Dastghaibyfard Date: %s\n",
		java.time.LocalDate.now()); 
	} // end main
} // end class xxxxxjavaList