package Collections;

import java.util.*;

public class ZeroSumSubArray {
    public static void main(String[] args) {
        int a[] = {1,2,4,-8,-1,-10,19};
        boolean found= false;

        //BruteForce Approach
        /* for(int i=0;i<a.length;i++){
            int sum=0;
            for(int j=i;j<a.length;j++){
                sum += a[j];
                if(sum==0){
                    found = true;
                    break;
                }
            }
            if(found) break;
        }       */


        // Optimized Approach Using Hashset

        Set<Integer> set = new HashSet<>();

        int sum=0;
        for(int element:a){
            set.add(sum);
            sum +=  element;
            if(set.contains(sum)){
                found =true;
                break;
            }
        }

        System.out.println((found)? "SubArray found!" : "SubArray not found");
    }
}
