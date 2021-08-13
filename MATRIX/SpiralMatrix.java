package MATRIX;
import java.util.*;

public class SpiralMatrix {

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        int rowB = 0;
        int rowE = matrix.length-1;
        
        int colB = 0;
        int colE = matrix[0].length-1;
        
        while(rowB<=rowE && colB<=colE){
            
            for(int i=colB;i<=colE;i++){
                ans.add(matrix[rowB][i]);
            }
            rowB++;
            
            
            for(int i=rowB;i<=rowE;i++){
                ans.add(matrix[i][colE]);
            }
            colE--;
            
            if(rowB<=rowE){
                for(int i=colE;i>=colB;i--){
                    ans.add(matrix[rowE][i]);
                }
                rowE--;
            }
            
            if(colB<=colE){
                for(int i=rowE;i>=rowB;i--){
                    ans.add(matrix[i][colB]);
                }
                colB++;
            }           
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++) {
                arr[i][j] = sc.nextInt(); 
            }
        }

        List<Integer> ans = spiralOrder(arr);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i));
        }
        System.out.println();
        sc.close();
    }
}