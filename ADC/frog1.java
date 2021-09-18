package ADC;

import java.util.*;

public class frog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int dp[] = new int[n]; 
        Arrays.fill(dp,-1);

        // dp[0] = 0;
        // dp[1] = Math.abs(arr[1]-arr[0]);

        // for(int i=2;i<n;i++){
        //     int first = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
        //     int second = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
        //     dp[i] = Math.min(first,second);
        // }

        // System.out.println(dp[n-1]);
        System.out.println(minCost(arr,n-1,dp));
        sc.close();
    }

    private static int minCost(int[] arr,int index,int[] dp) {
        if(index==1)
            return  dp[index] = Math.abs(arr[1]-arr[0]);

        if(index==0)
            return dp[index] = 0;

        if(dp[index] != -1)
            return dp[index];

        int prev = minCost(arr,index-1,dp) + Math.abs(arr[index] - arr[index-1]);
        int prev_to_prev = minCost(arr,index-2,dp) + Math.abs(arr[index] - arr[index-2]);    

        return dp[index] = Math.min(prev,prev_to_prev);
    }
}
