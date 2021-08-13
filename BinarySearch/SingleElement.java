package BinarySearch;

class SingleElement{
    public static void main(String[] args) {
        int arr[]={1,1,2,2,3,3,4,5,5};

        int singleElement = singleNonDuplicate(arr);
        System.out.println(singleElement);

    }
    public static  int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2; 
        while(low <= high) {
            int mid = (low + high) >> 1; 
            if(nums[mid] == nums[mid^1]) {
                low = mid + 1; 
            } 
            else {
                high = mid - 1; 
            }
        }
        return nums[low]; 
    }
}