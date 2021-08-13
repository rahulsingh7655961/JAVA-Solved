package Array;
import java.util.*;
public class FindRepeatingandMissingNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        find(arr,n);
        int ans[] = findTwoElement(arr,n);
        System.out.print(ans[0]+" "+ans[1]);
        sc.close();
    }
    static int[] findTwoElement(int arr[], int n) {
        // code here
        int ans[] = new int[2];
        
        int i;
        for(i=0;i<n;i++){
            int index = Math.abs(arr[i]);
            if(arr[index-1]>0)
                arr[index-1] *= -1;
            else 
                ans[0]=index;
        }
        // all the original arr elements will be negative instead of the repeating one
        // the repeating no is in place of the missing number
        // index of repeating no + 1 will the missing number
        for(i=0;i<n;i++){
            if(arr[i]>0)
            ans[1]=i+1;
        }
        return ans;
    }
    static void find(int arr[],int n){
        int rep=0,mis=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i]))
                rep = arr[i];
            else 
                map.put(arr[i],1);
        }
        for(int i=0;i<n;i++){
            if(!map.containsKey(i+1))
                mis = i+1;
        }
        System.out.print(mis+","+rep);
        System.out.println();
    }
}

