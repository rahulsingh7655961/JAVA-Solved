package ADC;

import java.util.Scanner;
import java.util.Arrays;

public class frog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int dp[] = new int[n]; 
        Arrays.fill(dp,-1);

        int ans = minCost(arr,k,n-1,dp);
        System.out.println(ans);

        sc.close();
    }

    private static int minCost(int[] arr, int k, int index, int[] dp) {
        if(index==0)
            return 0;
        if(dp[index] != -1)
            return dp[index];
        int mincost = Integer.MAX_VALUE;

        for(int steps=1;steps<=k;steps++){
            if(index-steps >= 0)
            mincost = Math.min(mincost , minCost(arr, k, index-steps, dp) + Math.abs(arr[index] - arr[index-steps]));
        }
        return dp[index] = mincost;
    }
}
