package BinarySearch;

import java.util.Scanner;

public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int ans=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of Array:");
        int[] arr = new int[sc.nextInt()];

        System.out.println("Enter elements of Array:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The array is ");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Element to find First or Last Occurrence:");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("Press F for first and L for last Occurence:");
        switch (sc.next()) {
            case "F":
                //  ans =  firstOccurrence(arr,x,0,arr.length-1);
                    ans =  firstOccurrence(arr,x);
                 System.out.println(x+" first occur at "+ans+"th index");
                break;
            case "L":
                 ans = lastOccurrence(arr,x,0,arr.length-1);
                 System.out.println(x+" last occur at "+ans+"th index");
                break;
            default:
                break;
        }
        sc.close();

    }

    private static int lastOccurrence(int[] arr, int x,int left,int right) {
        if(left>right)
        return -1;
        
        int mid = left + (right-left)/2;
        int ans;
        if(x==arr[mid]){
            ans=mid;
            int res=lastOccurrence(arr,x, mid+1,right);
            return res==-1 ? ans : res;
        }

        else if(x>arr[mid])
            return lastOccurrence(arr, x, mid+1, right);
        else return lastOccurrence(arr, x, left, mid-1);
    }

 static int firstOccurrence(int[] arr, int x,int left,int right) {

        if(left>right)
        return -1;

        int mid = left + (right-left)/2;
        int ans;
        if(x==arr[mid]){
            ans=mid;
            int res = firstOccurrence(arr,x, left, mid-1);
            return res==-1 ? ans : res;
        }

        else if(x>arr[mid])
            return firstOccurrence(arr, x, mid+1, right);
        else return firstOccurrence(arr, x, left, mid-1);
    }

    static int firstOccurrence(int[] arr,int x){
        int left = 0;
        int right = arr.length-1;
        int ans=0;
        while(left<=right){
            int mid = left + (right-left)/2;

            if(x==arr[mid]){
                ans = mid;
                right = mid-1;
            }
            else if(mid>arr[x]){
                right = mid-1;
            }
            else left= mid+1;
        }
        return ans;
    }

    static int lastOccurrence(int[] arr,int x){
        int left = 0;
        int right = arr.length-1;
        int ans=0;
        while(left<=right){
            int mid = left + (right-left)/2;

            if(x==arr[mid]){
                ans = mid;
                left = mid+1;
            }
            else if(x<arr[mid]){
                right = mid-1;
            }
            else left= mid+1;
        }
        return ans;
    }

    
}
