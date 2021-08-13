package Recursion;

public class QuickSort {
    
    static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    }

    static void quickSort(int arr[],int l,int r){
        if(l>=r) return;

        int pivotIndex = partition(arr,l,r);
        quickSort(arr, l, pivotIndex-1);
        quickSort(arr, pivotIndex+1, r);
    }

     static int partition(int[] arr, int low, int high) {
        
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i<j){

        while(arr[i]<=pivot && i<high)
            i++;
        while(arr[j]>pivot )
            j--;
        if(i<j)
            swap(arr, i, j);
        }
        swap(arr,j,low);
        return j;
        
    }
    static int part(int arr[], int low, int high)
    {
        int pivot = arr[low];
        int i=low;

        for(int j=low+1;j<=high;j++){
           if(pivot>arr[j]){
               i++;
               swap(arr,i,j);
           }
        }
        swap(arr,i,low);
        return i;
    }
    public static void main(String[] args) {
        int arr[]={2,2,1,7,9,5,4,9,3};

         quickSort(arr,0,arr.length-1);
         for(int element:arr)
            System.out.print(element+" ");
    }
}
