package BinarySearch;
import java.util.*;
class BS{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int x = sc.nextInt();

       int arr[] = new int[n];
       for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();           
       }

       int ans = BinarySearch(arr, x);
       System.out.println(ans);
       sc.close();
    }

    static int BinarySearch(int arr[],int x){
      int low = 0;
      int high = arr.length-1;

      while(low<=high){
          int mid = low+(high-low)/2;
          if(arr[mid]==x)
              return mid;
          else if(arr[mid]>x){
              high = mid-1;
          }
          else
              low = mid+1;
      }
      return  -1;
    }

    private static int recursiveBinarySearch(int[] arr, int x,int left,int right) {
        if(left>right)
        return -1;
        int mid = left + (right-left)/2;
        if(x==arr[mid])
            return mid;
        else if(x>arr[mid])
            return recursiveBinarySearch(arr, x, mid+1, right);
        else return recursiveBinarySearch(arr, x, left, mid-1);
    }

    static int binSearchReverse(int arr[],int x){
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]<x){
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return  -1;
    }

    static int orderNotKnownBinarySearch(int[] arr,int x){

        if(arr[0]<arr[1])
            return recursiveBinarySearch(arr,x,0,arr.length);
        else 
            return binSearchReverse(arr,x);
    }
}