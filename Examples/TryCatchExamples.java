package Examples;
import java.io.*;
import java.util.*;

public class TryCatchExamples {
    public static void main(String[] args) throws Exception {
            
            Scanner scan = new Scanner(System.in);
            System.out.println("What's your fav number?");

        try {
            int num = scan.nextInt();
            System.out.println(num);
        } catch (Exception e) {
            System.out.println("Pls enter numer");
        }

    }
}
