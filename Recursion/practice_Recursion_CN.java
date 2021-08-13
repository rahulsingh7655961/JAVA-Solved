package Recursion;

import java.util.Scanner;

public class practice_Recursion_CN {
    static int countSteps=0;

    static int[] frequencyIndex(int arr[],int idx,int x,int fsf){
        if(idx == arr.length)
            return new int[fsf];
        int iarr[];
        if(arr[idx]==x){
            iarr = frequencyIndex(arr, idx+1, x, fsf+1);
            iarr[fsf] = idx; 
        }else
            iarr = frequencyIndex(arr, idx+1, x, fsf);
        
        return iarr;
    }
    //                  Index should be arr.length-1
    // public static int lastIndex(int[] arr, int idx, int x){
    //     if(idx < 0)
    //         return -1;
       
    //     if(arr[idx]==x)return idx;
    //     return lastIndex(arr,idx-1,x);
    // }

    static int lastIndex(int[] arr,int idx,int x){
        countSteps++;

        if(idx == arr.length)return -1;

        int ans = lastIndex(arr, idx+1, x);

        if(ans==-1) return arr[idx]==x ? idx : -1;
        else return ans;
    }
    static int firstIndex(int[] arr,int idx,int x){
        countSteps++;
        if(idx == arr.length) return -1;
        if(arr[idx]==x) return idx;
        return firstIndex(arr, idx+1, x);
    }
    static boolean isPresent(int[] arr,int idx,int size,int x){
        countSteps++;
        if(idx>size-1) return false;
    
        if(arr[idx]== x){
            return true ;
        }
       if(arr[size-1]==x){
            return true;
         }
        return isPresent(arr,idx+1,size-1,x);
    
    }
    public static int sumArray(int[] arr,int n){
        if(n==1)
            return arr[n-1];
        
        return arr[n-1] + sumArray(arr,n-1);  
    }
    public static void print(int n){
		if(n<0) return;
		if(n == 0){
			System.out.println(n);
			return;
		}
		print(n-1);
		System.out.print(n+" ");
	}
    public static int countDigit(int n){
         countSteps++;
        if(n/10==0)
            return 1;
        return 1 + countDigit(n/10);
    }
    public static void printNaturalNumber(int n){
        countSteps++;
        if(n==0)
         return;
            
        printNaturalNumber(n-1);
        System.out.print(n+" ");

    }
    //O(n)
    public static int pow(int a,int b){
        countSteps++;
        if(b==0) return 1;
        return a * pow(a,b-1);
    }
    //O(logn)
    public static int fastPower(int a,int b){
        countSteps++;
        if(b==0)return 1;
        else if(b%2==0) return fastPower(a*a, b/2);
        else return a * fastPower(a, b-1);
    }

    public static void main(String[] args) {
        // System.out.println(pow(2,30));
        // System.out.println(countSteps);
        // countSteps=0;
        // System.out.println(fastPower(2, 30));
        // System.out.println(countSteps);

        // printNaturalNumber(10);
        // System.out.println();
        // System.out.println(countSteps);

        // System.out.println(countDigit(194765943));
        // System.out.println(countSteps);

        //print(3);

        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

       // int sum = sumArray(arr, n);
        
       int x = sc.nextInt();

        // boolean present = isPresent(arr,0,n,x);
        // System.out.println(present);

        System.out.println(firstIndex(arr,0,x));
        System.out.println(lastIndex(arr, 0, x));
        int ans[] = frequencyIndex(arr, 0, x, 0);
        for(int e : ans){
            System.out.print(e+" ");
        }
        sc.close();
    }
}
