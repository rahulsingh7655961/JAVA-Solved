package Stack;

import java.util.*;
import java.io.*;

class NextLargestElement {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- >0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int[] arr = new int[n];
		    for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
		    int[] res = nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
    public static int[] nextLargerElement(int[] arr, int n)
    { 
       Deque<Integer> s = new LinkedList<>();
       int[] ans = new int[n];
       for(int i=n-1;i>=0;i--)
       {
           if(s.isEmpty())
               ans[i]=-1;
           if(!s.isEmpty() && arr[s.peek()]>arr[i])
               ans[i]=arr[s.peek()];
           if(!s.isEmpty() &&  arr[s.peek()] <= arr[i]){
               while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                   s.pop();
               }
               if(s.isEmpty())
                   ans[i] = -1;
               else
                   ans[i]=arr[s.peek()];
           }
           s.push(i);
       }
       return ans;
    } 
}
