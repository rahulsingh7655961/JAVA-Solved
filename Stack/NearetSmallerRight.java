package Stack;
import java.io.*;
import java.util.*;

public class NearetSmallerRight {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n =sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            int res[] = nearestSmallerRight(arr,n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i]+" ");
            System.out.println();
        }
        sc.close();
    }
    public static int[] nearestSmallerRight(int[] arr,int n){
        Deque<Integer> s = new LinkedList<>();
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            
            while(!s.isEmpty() && arr[s.peek()]>=arr[i])
                s.pop();
            ans[i] =  s.isEmpty() ? -1 : arr[s.peek()];
            s.push(i);
        }

        return ans;
    }
}
