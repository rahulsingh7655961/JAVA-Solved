package DP;
import java.io.*;
// import java.util.*;

public class SubsetSum {

    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(br.readLine());
            }
            int target = Integer.parseInt(br.readLine());
            
            Solution ob = new Solution();
            boolean isPresent = ob.SubsetSum(nums, n, target);
            System.out.println(isPresent);
    }
}
class Solution{
    boolean SubsetSum(int[] nums,int n,int target){
        boolean dp[][] = new boolean[n+1][target+1];
        
        //Initialiazation in other loop to pass all cases
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0)
                    dp[i][j]=false;
                    
                else if(j==0)
                    dp[i][j]=true;
                
                else if(nums[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][target];
    }
}

