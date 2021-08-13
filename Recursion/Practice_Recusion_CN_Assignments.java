package Recursion;

public class Practice_Recusion_CN_Assignments {
    static int countSteps=0;
    
    static int mult(int a,int b){
        countSteps++;
        if(a==1)return b;
        if(b==1)return a;
        if(a==0 || b==0)return 0;

        if(a<b)return mult(b, a);

        return a + mult(a,b-1);
    }

    static int countZeroes(int n){
        if(n==0) return 1;
        if(n<10) return 0;

        if(n%10 == 0)   return 1 + countZeroes(n/10);

        else return countZeroes(n/10);
    }
    static double geometricSum(int n){
        if(n==0) return 1;

        return 1 / Math.pow(2,n) + geometricSum(n-1);
    }

    static  boolean checkPalindrome(String s){
        if(s.length()==0) return true;

        return checkPalindrome(s,0,s.length()-1);
    }
    static boolean checkPalindrome(String S,int l,int r){
        if(l==r) return true;

        if(S.charAt(l)!=S.charAt(r)) return false;

        return checkPalindrome(S, l+1, r- 1);
    }
    static int sumOfDigits(int n){
        if(n==0) return 0;
        if(n<10) return n;

         return n%10 + sumOfDigits(n/10);
    }
    public static void main(String[] args) {
        //System.out.println(mult(5,50));
        // System.out.println(countSteps);

        // System.out.println(countZeroes(1000));

        // System.out.println(geometricSum(3));
        // System.out.println(checkPalindrome("civic"));
        // System.out.println(checkPalindrome("redivider"));
        // System.out.println(checkPalindrome("level"));

        //System.out.println(sumOfDigits(16743843));
        System.out.println();
    }
}
