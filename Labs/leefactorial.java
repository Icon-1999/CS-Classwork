public class leefactorial {
    private void permutations(int n){
        int p = 1, i;
        for(i = 0; i <= n; i++){
            p = p*1;
        }
    }

    private void process(int n){
        permutations(n);
    }
    
    public static void main(String[] args) throws Exception {
        int n, cnt;
		cnt = args.length; // get no. of atguments
		if (cnt < 1){
		    System.out.printf("\n\tOOOPS Invalid No. of aguments!"+
			"\n\tTO Execute: java xxxxxH6 20 100 200");
			return;
		} // end if	
		
		// get input n, a and b
		n = Integer.parseInt(args[0]);
			
		//System.out.printf("\n fn=%s, array n=%d", fn, n);
		System.out.printf("\n\txxxxxH6: n=%d", n);
			
		// create an instance of xxxxxH6 class
		leefactorial srt = new leefactorial();
		
		// call process method 
		srt.process(n); 
			
		//MAKE SURE TO WRITE YOUR NAME IN NEXT LINE		
		System.out.printf("\n\tAuthor: Armon J. Lee Date: " +
	    java.time.LocalDate.now()); 
    }
}
