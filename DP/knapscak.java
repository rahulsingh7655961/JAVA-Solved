package DP;

import java.io.*;
import java.util.*;

public class knapscak {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] wts = new int[n];
            String str2 = br.readLine();
            for (int i = 0; i < n; i++) {
                wts[i] = Integer.parseInt(str2.split(" ")[i]);
            }

            int[] values = new int[n];
            String str1 = br.readLine();
            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(str1.split(" ")[i]);
            }

            int cap = Integer.parseInt(br.readLine());

            int maxProfit = knapsack(wts, values, n, cap);
            int maxProfit1 = knapsackMEMO(wts, values, n, cap);
            int maxProfit2 = knapsackTD(wts, values, n, cap);
            System.out.println(maxProfit);
            System.out.println(maxProfit1);
            System.out.println(maxProfit2);

        }
    }

    private static int knapsackTD(int[] wts, int[] values, int n, int cap) {
        
        int dp[][] = new int[n+1][cap+1];
        

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
            }            
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(wts[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1]+dp[i-1][j-wts[i-1]]);
                }                
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][cap];
    }

    private static int knapsack(int[] wt, int[] val, int n, int capacity) {

        if (n == 0 || capacity == 0)
            return 0;

        if (wt[n - 1] <= capacity)
            return Math.max(knapsack(wt, val, n - 1, capacity),
                    val[n - 1] + knapsack(wt, val, n - 1, capacity - wt[n - 1]));

        return knapsack(wt, val, n - 1, capacity);
    }

    private static int knapsackMEMO(int[] wt, int[] val,int n, int capacity) {
            if(n==0 || capacity==0)
                return 0;
            
            int dp[][] = new int[n+1][capacity+1];
            for(int[] i : dp)
                Arrays.fill(i,-1);
            if(dp[n][capacity]!=-1)
                return dp[n][capacity];
            
            if(wt[n-1]<=capacity)
                return dp[n][capacity] = Math.max( knapsack(wt,val,n-1,capacity) , val[n-1]+knapsack(wt, val, n-1, capacity - wt[n-1]));
        
                return dp[n][capacity] = knapsack(wt, val, n-1, capacity);
    }




}


