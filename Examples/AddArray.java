package Examples;
public class AddArray {
        public static void main(String[] args) throws Exception {
            //Original array
            String[] rgb = new String[]{"red", "green"};

            //new array with one more length
            String[] rgb2 = new String[rgb.length + 1];

            //copy the old in the new
            System.arraycopy(rgb, 0, rgb2, 0, rgb.length);

            //add new element
            rgb2[rgb.length] = "blue";

            //Optional: set old array to new array
            rgb = rgb2;

            //loop thru array
            for (int i = 0; i <= rgb.length - 1; i++) {
                System.out.println(rgb[i]);
            }
            
        }
}
