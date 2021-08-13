package BinarySearch;

public class CountElement {
    public static void main(String[] args) {
        int arr[] = {1,2,3,3,3,3,3,3,4,5,6};

        int count = CountElementBS(arr,4);
        System.out.println(count);
    }

    private static int CountElementBS(int[] arr, int x) {
        
            int first = BinarySearch(arr,x,true);
            int last = BinarySearch(arr,x,false);

            if(first==-1) return 0;
            else if(last==-1) return 1;
            else 
                return last-first+1;    
    }
    

    private static int BinarySearch(int[] arr, int x, boolean isFirst) {
        int left = 0;
        int right = arr.length-1;
        int ans=0;
        while(left<=right){
            int mid = left + (right-left)/2;

            if(x==arr[mid]){
                ans = mid;
                if(isFirst)right = mid-1;
                else left = mid+1;
            }
            else if(x<arr[mid]){
                right = mid-1;
            }
            else left= mid+1;
        }
        return ans;
    }
}
