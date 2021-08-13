package Stack;
import java.io.*;
import java.util.*;


public class MAximumAreaBinaryMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- >0){
		    int m = Integer.parseInt(br.readLine().trim());
            int n = Integer.parseInt(br.readLine().trim());

		    String inputLine[] = br.readLine().trim().split(" ");
            int[][] arr = new int[1000][1000];
		    for(int i=0; i<m; i++)
                for(int j=0;j<n;j++)
                    arr[i][j]=Integer.parseInt(inputLine[i]);

        int maxArea = maxArea(arr,m,n);
        System.out.println(maxArea);  
        }
        br.close(); 
    }
    public static int maxArea(int M[][], int m, int n) {
       
        int maxArea = MAH(M[0],n);
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++)
                if(M[i][j] ==1)
                    M[i][j] += M[i-1][j];
            maxArea = Math.max(maxArea, MAH(M[i],n));
        }
        
        return maxArea;
         /*
        int[] H = new int[m];
        for(int j=0;j<n;j++){
            H[j] = M[0][j];
        }
        int mx = MAH(H);
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]==0)
                    H[j]=0;
                else H[j] = H[j] + M[i][j];
            }
            mx = Math.max(mx , MAH(H));
        }
        return mx;   */
    }
    public static int MAH(int h[],int n){
        
        int[] area = new int[n];
        int[] Left = NearestSmallerLeft(h,n);
        int[] Right = NearetSmallerRight(h,n);
        for(int i=0;i<n;i++){
            area[i] = (Right[i] - Left[i] - 1) * h[i];
        }int maxArea = area[0];
        for(int i=1;i<n;i++){
            if(maxArea<area[i]) 
                maxArea = area[i]; 
        }
     
     return maxArea;
    }
    public static int[] NearestSmallerLeft(int[] h,int n){
        int pseudoIndex =-1;
        Deque<Integer> s = new LinkedList<>();
         int[] left = new int[n];
         for(int i=0;i<n;i++){
            
             while(!s.isEmpty() && h[s.peek()] >= h[i])
                s.pop();
            if(s.isEmpty())
                left[i]=(pseudoIndex);
            else left[i]=(s.peek());
            s.push(i);
         }
         return left;
    }
    public static int[] NearetSmallerRight(int[] h,int n){
        int pseudoIndex =n;
        Deque<Integer> s = new LinkedList<>();
         int[] right = new int[n];
         for(int i=n-1;i>=0;i--){
            
             while(!s.isEmpty() && h[s.peek()] >= h[i])
                s.pop();
            if(s.isEmpty())
                right[i]=(pseudoIndex);
            else right[i]=(s.peek());
            s.push(i);
         }
         return right;
    }

}

/*
class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        
        int maxArea = Integer.MIN_VALUE;
        int height[] = new int[matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(  matrix[i][j]=='0'){
                    height[j] = 0;
                }
                else height[j]++;
            }
            maxArea = Math.max(maxArea,MAH(height));
        }
        
       return maxArea;
    }
    private int MAH(int[] height){
        if(height == null || height.length == 0) return 0;
        Deque<Integer> s = new LinkedList<>();
        int lb=0,rb=0;
        int top=0;
        int area =Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<height.length;i++){
            while(!s.isEmpty() && height[s.peek()] > height[i]){
                rb = i;
                top = s.pop();
                lb = s.isEmpty() ? -1 : s.peek();
                area = height[top] * (rb-lb-1);
                max = Math.max(max,area);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            rb = height.length;
            top = s.pop();
            lb = s.isEmpty() ? -1 : s.peek();
            area = height[top] * (rb-lb-1);
            max = Math.max(max,area);
        }
        return max;
    }
}
*/