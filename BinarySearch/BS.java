package BinarySearch;

class BS{
    public static void main(String[] args) {
        int arr[] = {1,3,5,7,8,10,12,56,78,90,344};//Array should be sorted.......
        int arr1[] ={10,9,8,7,6,5,3,2,1};
        int ans= BinarySearch(arr,344);
//      int ans = recursiveBinarySearch(arr,75,0,arr.length-1);
        int ans1 = binSearchReverse(arr1,2);

//      int ans = orderNotKnownBinarySearch(arr, 56);
//      int ans1 = orderNotKnownBinarySearch(arr1, 6);

        System.out.println((ans==-1)?"Element not found!!":"Element found at "+ans+"th index");
        System.out.println((ans1==-1)?"Element not found!!":"Element found at "+ans1+"th index");
        
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