package DP;
import java.io.*;
// import java.util.*;

class LongestCommonSubstring
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            LCSubstring ob = new LCSubstring();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}

class LCSubstring{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0||j==0)
                dp[i][j]=0;
                
                else if(S1.charAt(i-1)==S2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return max;
    }
}