package BinarySearch;

public class NoOfRotation{
    public static void main(String[] args) {
        //int arr[] = {11,12,15,18,2,5,6,8};
        int arr[] = {8,9,10,11,3,4};
        solution ob = new solution();
        int no = ob.minIndex(arr);
        System.out.println(no);
    }
}
class solution{
    public int minIndex(int arr[]){
        if(arr.length<2)
        return 0;

        int start=0,end=arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid>0 && arr[mid]<arr[mid-1]){
                return mid;
            }
            else if(arr[start]<=arr[mid] && arr[mid]>arr[end])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }   

    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else{
                if(nums[mid+1]<=target && target<=nums[high])
                    low = mid+1;
                else 
                    high = mid-1;
            }
        }
        return -1;
    }
}