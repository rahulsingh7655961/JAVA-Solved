package DP;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int[] arr = { 1, 6, 11, 5 };

        int ans = minDiff(arr);
        int res = minDiff(arr,arr.length);
        System.out.println(ans+"  "+res);
    }

    private static int minDiff(int[] arr, int n) {

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }

        int[][] dp = new int[n+1][sum+1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                
                if(arr[i-1] > j)
                    dp[i][j] = dp[i-1][j];

                else
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j - arr[i-1]]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum/2; i++) {
            if(dp[n-1][i] == 1)
                min = Math.min(min , sum - 2*i);
        }
        return min;
    }

    private static int minDiff(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        return minDiffHelper(arr, sum, n - 1, 0);
    }

    private static int minDiffHelper(int[] arr, int sum, int index, int currSum) {
        if(index < 0)
            return Math.abs(sum - 2 * currSum);

        int exc = minDiffHelper(arr, sum, index-1, currSum);
        int inc = minDiffHelper(arr, sum, index-1, currSum + arr[index]);   
        
        return Math.min(inc, exc);
    }
}

// reference:->
// Recursion:https://ide.geeksforgeeks.org/SXlhpnfyVD
// Top-Down: https://ide.geeksforgeeks.org/85swqCyDRp
// Bottom-Up:https://ide.geeksforgeeks.org/Qll00QBsGV