package D2C;

import java.util.Scanner;

public class MaxSumMinK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            int minK = n;
            int maxSum = Integer.MIN_VALUE;
            for (int i = n-1; i >= 0; i--) {
                if(sum%i == 0){
                    if(sum>maxSum){
                        maxSum = sum;
                        minK = i;
                    }
                    else if(sum == maxSum){
                        minK = Math.min(minK, i);
                    }
                }
            }

            System.out.println(minK);
        }
        sc.close();
    }    
}
