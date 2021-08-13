import java.util.Scanner;
public class CamelCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
       
        int terms = 1;
        for (int i = 0; i < s.length(); i++) {
            String letter = Character.toString(s.charAt(i));
            if (letter == letter.toUpperCase()) {
                terms++;
            }
        }
        System.out.println(terms);
        sc.close();
    }
}
