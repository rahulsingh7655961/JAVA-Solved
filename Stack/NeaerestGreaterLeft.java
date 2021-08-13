package Stack;

import java.io.*;
import java.util.*;


public class NeaerestGreaterLeft {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0; i<n; i++)
                arr[i]=sc.nextInt();
            int[] res = leftLargerElement(arr, n);
            for (int i = 0; i < n; i++) 
                    System.out.print(res[i] + " ");
             System.out.println();
             sc.close();
             
        }
    }

    public static int[]  leftLargerElement(int[] a,int n){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && a[stack.peek()] <= a[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? -1: a[stack.peek()];
            stack.push(i);
        }
        return ans;
    }
}
