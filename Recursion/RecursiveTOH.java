package Recursion;

import java.util.Scanner;

public class RecursiveTOH {
    static void TOH(int n,char a,char b,char c){
        if(n==0)return;
        TOH(n-1,a,c,b);
        System.out.println(a+" "+c);
        TOH(n-1,b,a,c);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        TOH(n,'A','B','C');
        sc.close();
    }
}
