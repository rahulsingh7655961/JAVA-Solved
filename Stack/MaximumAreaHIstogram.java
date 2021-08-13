package Stack;

import java.io.*;
import java.util.*;

public class MaximumAreaHIstogram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- >0){
		    long n = Long.parseLong(br.readLine().trim());
		    String s[] = br.readLine().trim().split(" ");
            long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(s[i]);

        long maxArea = largestRectangle(arr,n);
        System.out.println(maxArea);

        br.close();   
    }
}
    public static long largestRectangle(long[] h,long n)  {
        
        long[] area = new long[(int)n];
        long[] Left = NearestSmallerLeft(h,n);
        long[] Right = NearestSmallerRight(h,n);
        for(int i=0;i<n;i++){
            area[i]=(Right[i]-Left[i]-1)*h[(int)i];
        }long maxArea = area[0];
        for(int i=1;i<n;i++){
            if(maxArea<area[i]) 
                maxArea = area[i]; 
        }
     
     return maxArea;
    }
    public static long[] NearestSmallerLeft(long[] h,long n){
        int pseudoIndex =-1;
        Deque<Integer> s = new LinkedList<>();
         long[] left = new long[(int)n];
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
    public static long[] NearestSmallerRight(long[] h,long n){
        int pseudoIndex =(int)n;
        Deque<Integer> s = new LinkedList<>();
         long[] right = new long[(int)n];
         for(int i=(int)n-1;i>=0;i--){
            
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



//  public int largestRectangleArea(int[] heights) {
//         int len = heights.length;
//         Stack<Integer> s = new Stack<>();
//         int maxArea = 0;
//         for (int i = 0; i <= len; i++){
//             int h = (i == len ? 0 : heights[i]);
//             if (s.isEmpty() || h >= heights[s.peek()]) {
//                 s.push(i);
//             } else {
//                 int tp = s.pop();
//                 maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
//                 i--;
//             }
//         }
//         return maxArea;
//     }



//  private int calcArea(int[] heights){   
//         if(heights == null || heights.length == 0) return 0;
//         int ans = 0;
//         LinkedList<Integer> stack = new LinkedList<>();
//         stack.push(-1);
//         for(int i = 0;i<= heights.length;i++){
//             while(stack.peek()!=-1 && (i==heights.length ||  heights[stack.peek()]) > heights[i]){
//                 int top = stack.pop();
//       
//                 int width =  i - stack.peek() - 1;
//                 ans = Math.max(ans,heights[top]*width);
//             }
//             stack.push(i);
//         }
//         return ans;
//     }


// private int MAH(int[] height){
//     if(height == null || height.length == 0) return 0;
//     Deque<Integer> s = new LinkedList<>();
//     int lb=0,rb=0;
//     int top=0;
//     int area =Integer.MIN_VALUE;
//     int max = Integer.MIN_VALUE;
    
//     for(int i=0;i<height.length;i++){
//         while(!s.isEmpty() && height[s.peek()] > height[i]){
//             rb = i;
//             top = s.pop();
//             lb = s.isEmpty() ? -1 : s.peek();
//             area = height[top] * (rb-lb-1);
//             max = Math.max(max,area);
//         }
//         s.push(i);
//     }
//     while(!s.isEmpty()){
//         rb = height.length;
//         top = s.pop();
//         lb = s.isEmpty() ? -1 : s.peek();
//         area = height[top] * (rb-lb-1);
//         max = Math.max(max,area);
//     }
//     return max;
// }
