package DP;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        
        boolean ans = isEqualSum(arr);
        System.out.println(ans);
    }

    private static boolean isEqualSum(int[] arr) {

        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }

        if(sum % 2 == 1)
        return false;

        int new_sum = sum/2;

        return SubsetSum(arr,new_sum);
    }

    private static boolean SubsetSum(int[] arr, int target) {

        int n = arr.length;
        boolean[][] dp = new boolean[n+1][target+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0)
                    dp[i][j] = false;
                
                if(j==0)
                    dp[i][j] = true;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                
                if(arr[i-1] > j)
                    dp[i][j] = dp[i-1][j];

                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
            }
        }

        return dp[n][target];
    }
}
