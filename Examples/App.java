package Examples;
public class App {
    public static void main(String[] args) throws Exception {
        String str = " aab + bab = b ";
        String num = "hi";
        String num2 = "e";
        str = str.replace(num2, num).replace("b", "1");

        System.out.print(str);
    }
}
