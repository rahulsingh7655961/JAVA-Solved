package DP;
import java.util.*;
public class LCSRecursive {
    public static int lcs(String x,String y,int n,int m){
        //base
        if(n==0||m==0)
            return 0;
        
        //choice Diagram
        if(x.charAt(n-1)==y.charAt(m-1))
            return 1+lcs(x,y,n-1,m-1);
        else
            return Math.max(lcs(x, y, n, m-1) , lcs(x, y, n-1, m));
    }
    static int[][] dp = new int[1001][1001];
    static int lcs1(int x, int y, String s1, String s2)
    {
        if(x==0||y==0)
            return 0;
        
        if(dp[x][y]!=-1)
            return dp[x][y];
        if(s1.charAt(x-1)==s2.charAt(y-1))
            return dp[x][y] = 1+lcs1(x-1,y-1,s1,s2);
        
        else{
            return dp[x][y] = Math.max(lcs1(x,y-1,s1,s2) , lcs1(x-1,y,s1,s2));
        }
            
    }

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abdfhr";
        for(int i=0;i<x.length()+1;i++)
            Arrays.fill(dp[i],-1);
        int lengthLCS = lcs(x,y,x.length(),y.length());
        System.out.println(lengthLCS);

    }


}
class LCSTOPDOWN {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                
            }
        }
        return dp[n][m];
    }
}