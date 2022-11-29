package H2;
// CSUN FALL 22   COMP 182
// xxxxxlstlnk.java is linked list implementation of lstinterface. 
//  Prepared by: Gh. Dastghaiby Fard  Sep. 14, 22
import java.util.*;
import java.io.*;
  //lstinterface is an interface  
public class leeh2 {
  // xxxxxlstlnk class  variables
  //head is a pointer to beginning of linked list
  private node head = null; 
  // count is no. of elements in the list
  private int count = 0; 
  //use prt for System.out to save typing
  PrintStream prt = System.out;

  // class node
  private class node{
  // class node variables
    String data; 
    node rlink;
    // class node constructor
    node(String x){
  data = x; 
  rlink = null;
    } // end class node constructor
  }// class node

  // insert x at position p, 
  // for successful insertion:  1 <= p <= count+1
  public int insertlst(String x,  int p){
  // Local variables
  node tmp, cur;
  int i;
  prt.printf("\n\tInsert %4d at position %2d:", x, p);
  if (p < 1 || p > count + 1){
  prt.printf(" Failed insertion.");
  return 0;  // invalid insertion
  } // end if
  // Allocate space foe new element
  tmp = new node(x);
  // p == 1 Inserts x to fron t of list.
  // This is a special case where head changes   
  if (p == 1){ 
  tmp.rlink = head;
  head = tmp;
  }
  else {
  cur = head;
  //Find addrres of node before p
  for (i = 2;  i < p; i ++, cur = cur.rlink);//for p=1 or p=2, loop will not execute   
  // end for
  //insert node after cur node
  tmp.rlink = cur.rlink;
  cur.rlink = tmp;
  } // end if
  count ++; // increment no. of elements.
  prt.printf(" Successful  insertion.");
  return 1;  // successful insertion
  } // end insertlst
    
  // delete x at position p,  for successful deletion:
  // list should not be empty and 1 <= p <= count
  public int deletelst(int p){
  // Local variables
  node tmp, cur;
  prt.printf("\n\t  Delete element at position %2d:", p);
  if (head == null || p < 1 || p > count){
  prt.printf(" Failed deletion.");
  return 0; // invalid deletion
  } // end if
  tmp = head;
  // p == 1 deletes front of list.
  // This is a special case where head changes   
  if (p == 1){//Delete Front of List
  head = head.rlink;
  tmp.rlink = null;
  }
  else {//Find address of node before p
  cur = head;
  // for p=1 or p=2, loop will not execute
  for (int i = 2; i < p; i ++, cur = cur.rlink);
  // end for
  // Delete node after cur node
  tmp = cur.rlink;
  cur.rlink = tmp.rlink;
  tmp.rlink = null;  // delete tmp;
  } // end if
    
  count --; // decrement no of list elements
  prt.printf(" Successful  deletion.");
  return 1; // successful deletion
  } // end deletelst
    
  // sequential serach for x in the list
  // if successful return position of x in the
  // list otherwise return 0;
  public int searchlst(String x){
  // Local variables
  node cur;
  // Complete the rest of the method
  return 0; // x is not found.
  } // end searchlst
    
  // print list elements formatted 
  private void prtlst() {
  // Local variables
  node cur;
  prt.printf("\n\tList contents(%d): ", count);
  for (cur = head; cur != null ; cur = cur.rlink)
  prt.printf("%4s, ", cur.data);
  // end for
  } // end prtlst

  private int insertSorted(String x){
    node tmp, cur, next;
      
    prt.printf("\n\t\tInserting %s into list\n", x);

    //allocate new node
    tmp = new node(x);

    //make new head
    if (count == 0){
      head = tmp;
      count = 1;
      return 0;
    }//endif
        
    //Special Case: Insert x at head
    //p = 1
    if ((head.data).compareTo(x) > 0){ 
      tmp.rlink = head;
      head = tmp;
      count++;
      return 1;
    }//endif
    
    //insert x at p if p > 2
    //start cur at head
    //next points to cur's rlink
    cur = head;
    next = cur.rlink;

    //loop through linked list
    //keep looping if p < count and data < x
    while(next != null && (next.data).compareTo(x) <= 0) {
      cur = next;
      next = next.rlink;
    }//endwhile

    //delete x at p
    tmp.rlink = cur.rlink;
    cur.rlink = tmp;
    
    //increase count
    count++;

    return 1;
  }//endinsertSorted

  private int searchSorted(String x){
    node cur, next;
    int p = 0;

    prt.printf("\n\t\tSearching for: %s\n", x);

    //exit if empty linked list
    if (count == 0){
      prt.printf("\n\t\t--Sorry, list is empty--\n");
      return 0;
    }

    //Special Case: x found at head
    //x == p = 1
    if ((head.data).compareTo(x) == 0) {
      p++;
      prt.printf("\t\tfound %s at postion %s\n", head.data, p);
      return 1;
    }//endif

    //insert x at p if p > 2
    //start cur at head
    //next points to cur's rlink
    cur = head;
    next = cur.rlink;
    p = 2;

    //loop through linked list
    //keep looping if p < count and data < x
    while(next != null && (next.data).compareTo(x) <= 0) {

      //x found at p > 1
      if ((next.data).compareTo(x) == 0){
        prt.printf("\t\tfound %s at postion %s\n", next.data, p);
        return 0;
      }

      cur = next;
      next = next.rlink;
      p++;
    }

    //no matches
    prt.printf("\t\t--No %s in list--\n", x);

    return 1;
  }//endsearchSorted

  private int deleteSorted(String x){
    node cur, tmp, next;
    int p = 0;

    prt.printf("\n\t\tSearching for and deleting: %s\n", x);

    //exit if empty list
    if (count == 0){
      prt.printf("\n\t\t--Sorry, list is empty--\n");
      return 0;
    }

    //allocate new node
    tmp = new node(x);

    //Special case: delete x at head
    //p = 1
    if ((head.data).compareTo(x) == 0) {
      p++;
      prt.printf("\t\tfound and deleting %s at postion %s\n", head.data, p);
      prt.printf("\t\t**Successful deletion**\n");
      tmp = head;
      head = head.rlink;
      tmp = null;
      count--;//decrease count
      return 1;
    }//endif

    //insert x at p if p > 2
    //start cur at head
    //next points to cur's rlink
    cur = head;
    next = cur.rlink;
    p = 2;

    //keep looping if p < count and data < x
    while(next != null && (next.data).compareTo(x) <= 0) {

      //found x at p > 1
      if ((next.data).compareTo(x) == 0){

        //delete x at p > 1
        cur.rlink = next.rlink;
        next.rlink = null;
        count--;//decease count

        prt.printf("\t\tfound and deleting %s at postion %s\n", next.data, p);
        prt.printf("\t\t**Successful deletion**\n");
        return 1;
      }//endif

      cur = next;
      next = next.rlink;
      p++;
    }//endwhile

    //no match
    prt.printf("\t\t--No %s in list--\n", x);

    return 1;
  }//end_deleteSorted

  // insert, delete and search in the list
  private void process(String fn){
  // Local variables
  int j, nIns, nSrch, nDel, k, p;
  String x;
  prt.print("\tLinked List implementation of list gets input file "+
  "name from program argument, then reads:"+
  "\n\tnIns: No. of elements to insert followed by elements to "+
  " insert and their positions,"+
  "\n\tnSrch: No. of elements to search, followed by element to "+
  " search"+
  "\n\t nDel: No. of elements to delete followed by position of "+
  " elements to delete" +    
  "\n\t\tTo compile: javac leeh2.java" +
  "\n\t\tTo execute: java  leeh2 H2");    
      
  try{  
  // open input file
  Scanner inf = new Scanner(new File(fn)); 
  //read no. of elements to insert
  nIns = inf.nextInt();
  prt.printf("\n\tInsert %2d elements in the list.", nIns);
  for(j = 1; j <= nIns; j++){
    x = inf.next();   // read x
    //p = inf.nextInt();  // read position
    k = insertSorted(x); //insert x at position p
  } // end for
  prtlst();//print list elements
  //read no. of elements to search in list
  nSrch = inf.nextInt(); 
  prt.printf("\n\tSearch for %d elements in list.", nSrch);
  for(j = 1; j <= nSrch; j++){
    x = inf.next(); // read x to serach
    k = searchSorted(x);   //delete position p
  }// end for
  //read no. of positions to delete from list
  nDel = inf.nextInt(); 
  prt.printf("\n\tDelete %d elements from list.", nDel);
  for(j = 1; j <= nDel; j++){
    x = inf.next();   // read position
    k = deleteSorted(x);   //delete position p
  }// end for
  prtlst();//print linked list elements
  // close input file 
  inf.close();   
  }catch (Exception e){prt.printf("\n\tRead Error! %s", e);}
  // Total input:  1+nIns*2 +1+nSrch +1+nDel= nIns*2 + nSrch + nDel + 3
  } // end process

  // main method
  public static void main(String args[]) throws Exception{
  // declare variables
  int cnt = args.length; // get no. of atguments
  String H2;
  if (cnt < 1){
    System.out.printf("\n\n\tInvalid No. of aguments! EXIT.\n");
    return;
  }
  // get input file name
  H2 = args[0];
  //create an instance of a class
  leeh2 lst = new leeh2();
  lst.process(H2);
  //Pleas replace G. Dastghaibyfard with your name in next line
  System.out.printf("\n\tAuthor: Armon J. Lee Date: %s\n",
  java.time.LocalDate.now()); 
  } // end main
}// end class leeh2