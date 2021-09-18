package ADC;
import java.util.*;
public class vacation {
    static int[] a = new int[1000], b = new int[1000], c= new int[1000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        int ans = Math.max(solveA(n) ,Math.max(solveB(n),solveC(n)));
        System.out.println(ans);
        sc.close(); 
    }
    private static int solveC(int n) {
        if(n==0)
        return c[n];

        return Math.max(solveA(n-1) , solveB(n-1)) + c[n];
    }
    private static int solveB(int n) {
        if(n==0)
        return b[n];

        return Math.max(solveA(n-1) , solveC(n-1)) + b[n];
    }
    private static int solveA(int n) {
        if(n==0)
        return a[n];

        return Math.max(solveB(n-1) , solveC(n-1))+ a[n];
    }

   
}
