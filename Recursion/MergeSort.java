package Recursion;

public class MergeSort {
    
public static void mergeSort(int arr[],int low,int high){
        if(low>=high) return;

        int mid = (low + high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        //merge(arr,low,high);
        merge(arr,low,mid,high);
    }

    public static void merge(int[] arr, int low, int high) {
        int mid = (low+high)/2;

        int ans[] = new int[high - low + 1];
        int i = low;
        int j =mid+1;
        int k = 0;

        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                ans[k]=arr[i];
                i++;
                k++;
            }
            else{
                ans[k]=arr[j];
                k++;
                j++;
            }
        }
        while(i<=mid){
            ans[k]=arr[i];
                i++;
                k++;
        }
        while(j<=high){
            ans[k]=arr[j];
                k++;
                j++;
        }
        for(int index=0;index<ans.length;index++){
            arr[low+index] = ans[index];
        }
 
    }

    public static void main(String[] args) {
         
        int arr[]={2,2,1,7,9,5,4,9,3};

         mergeSort(arr,0,arr.length-1);
         for(int element:arr)
            System.out.print(element+" ");
    }

    static void merge(int arr[],int low,int mid,int high){
        int b[]= new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=high){

            if(arr[i]<arr[j]){
                b[k]=arr[i];
                i++;
            }
            else{
                b[k]=arr[j];
                j++;
            } 
             k++;
        }
       while(j<=high){
                    b[k]=arr[j];
                    j++;
                    k++;
        }
        while(i<=mid){
                    b[k]=arr[i];
                    i++;
                    k++;
        }
        
        for( k=0;k<b.length;k++)
            arr[low+k]=b[k];
    }

}
