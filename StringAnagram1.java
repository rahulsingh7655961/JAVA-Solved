import java.util.Scanner;
public class StringAnagram1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();
        boolean isAnagram = true;
        int[] a = new int[256];
        int[] b= new int[256];

        for(char c:s1.toCharArray()){
            int index = (int)c;
            a[index]++;
        }
        for(char c:s2.toCharArray()){
            int index = (int)c;
            b[index]++;
        }
        for(int i=0;i<256;i++){
            if(a[i] != b[i]){
                isAnagram=false;
                break;
            }
        }
        if(isAnagram)
        System.out.println("Anagram");
        else System.out.println("Not Anagram");

    }
}
