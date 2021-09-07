package DP;

import java.util.Scanner;

public class CountSubsetSum {
    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        int n = br.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = br.nextInt();
        }

        int target = br.nextInt();

        int ans = count(nums, target);
        System.out.println(ans);
        br.close();
    }

    private static int count(int[] nums, int target) {

        int n = nums.length;
        int dp[][] = new int[n + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0)
                    dp[i][j] = 0;

                if (j == 0)
                    dp[i][j] = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                 if (nums[i - 1] <= j)
                 dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                 else
                 dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][target];
    }
}
