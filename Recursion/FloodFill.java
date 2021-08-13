package Recursion;

public class FloodFill {
    public static void main(String[] args) {
        int a[][] =     {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
            };

            floodFill(a,0,4,9,1);
            printMatrix(a);
    }

    private static void printMatrix(int[][] a) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }
            
    }

    private static void floodFill(int[][] a, int r, int c, int toFill, int prevFill) {
        
        int rows = a.length;
        int cols = a[0].length;

        if(r<0 || r >= rows || c<0 ||c >= cols) return;

        if(a[r][c] != prevFill) return;

        a[r][c] = toFill;

        floodFill(a, r-1, c, toFill, prevFill);
        floodFill(a, r, c-1, toFill, prevFill);
        floodFill(a, r+1, c, toFill, prevFill);
        floodFill(a, r, c+1, toFill, prevFill);    
    }
}
class Solution {
    private void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
         if(sr >=0 && sr < image.length && sc >= 0 && sc < image[0].length) {
             if(image[sr][sc] == oldColor) {
                 image[sr][sc] = newColor;
                 fill(image, sr+1, sc, oldColor, newColor);
                 fill(image, sr-1, sc, oldColor, newColor);
                 fill(image, sr, sc+1, oldColor, newColor);
                 fill(image, sr, sc-1, oldColor, newColor);
             }
         }
             
     }  
     
     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
         int oldColor = image[sr][sc];
         if(oldColor != newColor)
             fill(image, sr, sc, oldColor, newColor);
         return image;        
     }
 }