package H3;
import java.util.*;
import java.io.*;

//program takes input equations from HW3 file
//then converts them to the equations from infix to postfix
//this is achived by using ADT stack

public class leeH3 {
   
   PrintStream prt = System.out;

   //priority method
   //gives priority to operators for the stack to compare
   private int priority(char ch){
      switch (ch) {
         case '^': return 3;
         case '*': case '/': return 2;
         case '+': case '-': return 1;
         default: return 0;
      }//endswitch
   }//end priority

   private String postfix(String exp){ 
      int n, j;
      char ch;

      // initializing empty stack s of type char 
      Stack<Character> stk = new Stack();    //  Create Stack of type Character: 
      n = exp.length();  // exp is a String 
      // convert exp to uppercase letters 
      exp = exp.toUpperCase(); // not case sensitive 
      String post = "";  // initialize post expression 
      
      for(j= 0; j < n; j++){    
         ch = exp.charAt(j);  //ch is next character of exp. 
         
         if (Character.isLetter(ch)) // ch is an operand A ..... Z 
            post += ch;      // append ch to post          
            
         else if (ch == '(')     
            stk.push(ch);   // push ch to the stack.  
         else if (ch == ')') {  //output from stack until a '(' is encountered.                     
            while (!stk.empty() && stk.peek() != '('   ) {  
                 post += stk.pop();   //append top of stack to post and delete top        
               } // end while                 
         if (stk.empty() || stk.peek() != '(' ){ 
            post = " invalid expression";   
            return  post;  // exit 
         }  // end if 
         else 
            stk.pop();  // remove '(' from stack  
         }  // end if (ch == ')') 
         else{  //  ch is an operator   +   -   *    /   ^  ..........        
            // you have to write priority method     
            while (!stk.empty() && priority(ch) <= priority(stk.peek())){  
               if (stk.peek() == '(') {               
                  post = " invalid expression";   
                  return  post;  // exit 
               } // end if 
                     post += stk.pop(); //append top of stack to post and delete top         
            } // end while  
               stk.push(ch);  // push operator (ch) onto stack   
         }  // end else   
      }    // end for     
        // pop all the operators from the stack and append to post 
      while (!stk.empty()){  
         if(stk.peek() == '(') { 
            post = " invalid expression";   
            return  post;  // exit 
         } // endif 
            
         post += stk.pop(); //append top of stack to post and delete top 
      }  // end while 
        
   return post;  // return computed postfix 
   } // end  postfix 
    
   private void process(String fn){  
      String exp, post; //infix postfix expression  
      int j, n;    // local vaiables   
      
      try{ 
         // open input file 
         Scanner inf = new Scanner (new File(fn)); 
    
         // read no. of expressions 
         n = inf.nextInt(); 
          
         // read and process n expressions 
         for (j = 1; j <= n; j++){ 
            // read next infix expression        
            exp = inf.next(); 
    
            // call infix to postfix method 
            post = postfix(exp); 
            System.out.printf("\nPosfix of %s is: %s", exp, post);
         } // end for 
    
         // close input file 
         inf.close();  
      } catch (Exception e){prt.printf("\n\tRead Error! %s", e);} 
   }// end process method

   public static void main(String args[]) throws Exception{
		// declare variables
		int cnt = args.length; // get no. of arguments
		String HW3;
						
		if (cnt < 1){
			System.out.printf("\n\n\tOOPS Invalid No. of arguments! EXIT.\n");
			return;
		} // end if
						
		// get input file name
		HW3 = args[0];

		//create an instance of a class
		leeH3 g = new leeH3();
		
		// Call process method
		g.process(HW3);

      //Pleas replace G. Dastghaibyfard with your name in next line		
	   System.out.printf("\n\n\tAuthor: A. Lee Date: %s\n",
		java.time.LocalDate.now()); 
	} // end main
}
