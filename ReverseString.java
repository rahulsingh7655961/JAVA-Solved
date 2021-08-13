import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String s1 =reverseString(s);
        System.out.println(s1);
    }
    private static String reverseString(String s) {
        if(s.length()==0)
        return s;
        String str[]=s.split(" ");
        String p = "";
        for(int i=str.length-1;i>=0;i--)
        {
            if(str[i].length() != 0)
            p+=str[i].trim()+" ";
        }
        return p.trim();
    }
    
}
