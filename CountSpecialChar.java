 import java.util.Scanner;

public class CountSpecialChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
       
        int special = 0;

		for(int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				continue;
            else if (ch >= 'a' && ch <= 'z')
				continue;
            else if (ch >= '0' && ch <= '9')
				continue;
			else
				special++;
		}

        System.out.println(special);
        sc.close();
    }  
}
