package Examples;

public class InsertArray {
    public static void main(String[] args) {
        int i;
        int j;
        int arr[] = {2, 4, 6, 8, 10, 0};
        int x = 6;
        int p = 2;
    
        for (i = 0; i <= arr.length; i++){
          int y = arr[i];
    
          if (x == y){
            for (j =  4; j >= i ; j--)   
            arr[j+1] = arr[j]; 
          // end for 
          break;
          }
        }
          arr[i] = p;   // insert x at position p
        }
    }
