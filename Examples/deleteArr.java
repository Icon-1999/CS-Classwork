package Examples;

public class deleteArr {
    public class YourClassNameHere {
        public static void main(String[] args) {
          int arr[] = {1, 6, 3, 6, 5, 6, 2};
          
          int count = 7;
          
          int x = 6;
          
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
          }
        }
    }
}
