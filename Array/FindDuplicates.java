package Array;
import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,2,4,6};
        int ans[] = find(arr);
        int res[] = findDuplicates(arr);
        for(int num:ans){
            if(num!=0)
            System.out.print(num+" ");
        }
        System.out.println();
        for(int num:res){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static int[] findDuplicates(int[] nums) {
    
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            
            if(nums[index]>0){
                nums[index] = -nums[index];
            }
            else{
                ans.add(index+1);
            }
        }
        int res[] = new int[ans.size()];
        for(int i=0;i<res.length;i++)
            res[i]=ans.get(i);
        return res;
    }
    private static int[] find(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num :arr){
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        int ans[] = new int[arr.length];
        int k=0;
        for(int num:map.keySet()){
            if(map.containsKey(num)){
                if(map.get(num)>1)
                    ans[k++]=num;
            }
        }
        return ans;
    }
}
