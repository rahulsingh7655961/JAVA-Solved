package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Recursion1 {
   
    static int stepCount = 0;
    public static void main(String[] args) {
        // stepCount =0;
        // System.out.println(sum(5));
        // System.out.println(pow(2,1000));
        // System.out.println("stepcounts "+stepCount);
        // stepCount =0;
        // System.out.println(fastPow(2,1000));
        // System.out.println("stepcounts "+stepCount);

        // System.out.println(path(4,4));
        
        List<Integer> A = new ArrayList<>();
         A.add(6);
        // A.add(3);
        // A.add(9);
        // A.add(4);
        // A.add(1);
        // System.out.println(A);
        // sort(A);
        // System.out.println(A);

        Stack<Integer> s = new Stack<>();

        s.push(6);
        s.push(3);
        s.push(9);
        s.push(4);
        s.push(1);

        sort(s);
        while(!s.isEmpty())
        System.out.print(s.pop()+" ");
    }
    static int path(int a,int b){
        if(a==1 || b==1)
            return 1;
        return path(a-1,b) + path(a,b-1);
    }
    static int fastPow(int a,int b){
        stepCount++;
        if(b==0)
            return 1;
        else if(b%2 == 0)
            return fastPow(a*a,b/2);
        return a * fastPow(a,b-1);
    }
    
    static int pow(int a, int b){
        stepCount++;
        if(b==0)
            return 1;
        return a*pow(a,b-1);
    }
    static int sum(int n){
        if(n==1)
            return 1;

        return  n + sum(n-1);
    }
    //List is opposite to vector in c++ therefor Changes will be made
    static void sort(List<Integer> A){
        int n=A.size()-1;
        if(A.size()==1)
            return;
        int temp = A.get(n);
        A.remove(n);
        sort(A);
        insert(A,temp);
    }
    private static void insert(List<Integer> a, int temp) {
        int n = a.size()-1;
        if(a.isEmpty() || a.get(n)<=temp){
            a.add(temp);
            return;
        }
        int value = a.get(n);
        a.remove(n);
        insert(a, temp);
        a.add(value);

    }
    static void sort(Stack<Integer> s){
        if(s.size()==1)
            return;
        int temp=s.pop();
        sort(s);
        insert(s,temp);
    }
    static void insert(Stack<Integer> s,int temp){
        if(s.isEmpty()||s.peek()<temp){
            s.push(temp);
            return;
        }
        int value = s.pop();
        insert(s, temp);
        s.push(value);
    }
}
