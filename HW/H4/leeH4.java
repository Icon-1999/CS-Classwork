package H4;

import java.util.*;
import java.io.*;

//program takes input equations from HW4 file
//then converts them to the equations from infix to postfix
//this is achived by using ADT stack

public class leeH4 {
   
   PrintStream prt = System.out;
   HashMap<Character, Double> hash = new HashMap();

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
            post = "invalid expression";   
            return  post;  // exit 
         }  // end if 
         else 
            stk.pop();  // remove '(' from stack  
         }  // end if (ch == ')') 
         else{  //  ch is an operator   +   -   *    /   ^  ..........        
            // you have to write priority method     
            while (!stk.empty() && priority(ch) <= priority(stk.peek())){  
               if (stk.peek() == '(') {               
                  post = "invalid expression";   
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
            post = "invalid expression";   
            return  post;  // exit 
         } // endif 
            
         post += stk.pop(); //append top of stack to post and delete top 
      }  // end while 
        
   return post;  // return computed postfix 
   } // end  postfix
   
   private double calc(String post){ 
      int n, j;
      char ch;
      double x, y, retr, compute, calculation;

      // initializing empty stack s of type char 
      Stack<Double> stk = new Stack();    //  Create Stack of type Character: 
      n = post.length();  // exp is a String 
      // convert exp to uppercase letters 
      post = post.toUpperCase(); // not case sensitive

      for(j= 0; j < n; j++){    
         ch = post.charAt(j);

         if (hash.containsKey(ch) && Character.isLetter(ch)){
            retr = hash.get(ch);
            stk.push(retr);
         }
         
         if (ch == '+'){
            x = stk.pop();
            y = stk.pop();
            compute = x + y;
            stk.push(compute);
         }
         else if (ch == '-'){
            x = stk.pop();
            y = stk.pop();
            compute = x - y;
            stk.push(compute);
         }
         else if (ch == '*'){
            x = stk.pop();
            y = stk.pop();
            compute = x * y;
            stk.push(compute);
         }
         else if (ch == '/'){
            x = stk.pop();
            y = stk.pop();
            compute = x / y;
            stk.push(compute);
         }
         else if (ch == '^'){
            x = stk.pop();
            y = stk.pop();
            compute = Math.pow(x, y);
            stk.push(compute);
         }
      }

      calculation = stk.pop();
   return calculation;  // return computed postfix 
   } // end  postfix

   
    
   private void process(String fn){  
      String exp, post; //infix postfix expression  
      int i, j, n, m;
      char oper;
      double oper_num, calc; // local vaiables     
      
      try{ 
         // open input file 
         Scanner inf = new Scanner (new File(fn)); 
    
         // read no. of expressions 
         n = inf.nextInt(); 
          
         // read and process n expressions 
         for (i = 1; i <= n; i++){ 
            // read next infix expression        
            exp = inf.next(); 
            
            // call infix to postfix method 
            post = postfix(exp);
            
            //get number of operands
            m = inf.nextInt();
            
            //read and process m operands
            for (j = 1; j <= m; j++){
               //input operand
               
               oper = inf.next().charAt(0);
               
               //input number equavilant
               oper_num = inf.nextFloat();

               hash.put(oper, oper_num);
            }

            calc = calc(post);
             
            System.out.printf("\n\nPosfix of %s is: %s", exp, post);
            if (post == "invalid expression"){
               System.out.printf("\nCan't compute");
            }
            else
            System.out.printf("\ncalculation of exp is %.7s when %s", calc, hash);
            hash.clear();
         } // end for 
    
         // close input file 
         inf.close();  
      } catch (Exception e){prt.printf("\n\tRead Error! %s", e);} 
   }// end process method

   public static void main(String args[]) throws Exception{
		// declare variables
		int cnt = args.length; // get no. of arguments
		String HW4;
						
		if (cnt < 1){
			System.out.printf("\n\n\tOOPS Invalid No. of arguments! EXIT.\n");
			return;
		} // end if
						
		// get input file name
		HW4 = args[0];

		//create an instance of a class
		leeH4 g = new leeH4();
		
		// Call process method
		g.process(HW4);

      //Pleas replace G. Dastghaibyfard with your name in next line		
	   System.out.printf("\n\n\tAuthor: A. Lee Date: %s\n",
		java.time.LocalDate.now()); 
	} // end main
}