package Stack;
import java.util.*;
public class RainWaterTrap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            int maxWater = rainWaterTrap(arr,n);
            System.out.println(maxWater);
        }
        sc.close();
    }

     static int rainWaterTrap(int[] arr,int n){
        int leftMax=0;
        int rightMax=0,totalWater=0;
        int left = 0;
        int right = n-1;
        while(left < right){
            if(arr[left] < arr[right]){
                
                if(arr[left] > leftMax) leftMax = arr[left];
                else totalWater += leftMax - arr[left];
                left++;
            }
            else{

                if(arr[right] > rightMax) rightMax = arr[right];
                else totalWater += rightMax - arr[right];
                right--;
            }
        }
        return totalWater;
        
    }
}
   /*      -------------------BRUTEFORCE-----------
    private static int rainWaterTrap(int[] arr,int n){
        int totalWater=0;
        for(int i=1;i<n-1;i++){
            
            int leftMax=arr[i];
            for(int j=i-1;j>=0;j--){
                if(leftMax < arr[j])
                    leftMax = arr[j];
            }
            int rightMax=arr[i];
            for(int j=i+1;j<n;j++){
                if(rightMax< arr[j])
                    rightMax=arr[j];
            }
             
            totalWater += Math.min(leftMax,rightMax)-arr[i];
        }
        
        return totalWater;
    }
    */
/*              leftarray and rightarray to store leftmax and rightmax
static int trappingWater(int arr[], int n) { 
        
        int left[] = new int[n];
        left[0] = arr[0];
        
        for(int i=1; i<n; i++){
            if(arr[i] > left[i-1]){
                left[i] = arr[i];
            }else{
                left[i] = left[i-1];
            }
        }
        
        int[] right = new int[n];
        right[n-1] = arr[n-1];
        
        for(int i=n-2; i>0; i--){
            if(arr[i] > right[i+1]){
                right[i] = arr[i];
            }else{
                right[i] = right[i+1];
            }
        }
        
        int totalWater = 0;
        for(int i=1; i<n-1; i++){
            totalWater += (Math.min(left[i], right[i]) - arr[i]);
        }
        return totalWater;
    } 
*/