package H1;

    
    // ADT List interface in java has No implementation 
    // DO NOT CHANGE THIS FILE.  
    public interface lstinterface{
    
        // Insert x at position p in the List.  
        // p can be from first(L) thru end(L)   
        // if successful insertion returns 1, otherwise returns 0; 
        public int insertlst(String x,  int p); 
      
        // Delete element at position p in the list. 
        // p can be from first(L) thru previous(end(L), L) 
        // if successful deletion returns 1, otherwise returns 0; 
        public int deletelst(int p); 
       
        // Sequential search for x in the List.   
        // if successful returns position of x otherwise 0; 
        public int searchlst(String x); 
        
        public int insertSorted(String x);  

        public int searchSorted(String x);  

        public int deleteSorted(String x);  
 
        // Print list elements 
        public void prtlst();  


     
    }  //end lstinterface 
