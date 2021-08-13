import java.util.Deque;
import java.util.LinkedList;
public class MaxSlidingWindow {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int a[] = { 4, 3, 1, 2, 5, 3, 4, 7, 1, 9 };

        int ans[] = sol.maxSlidingWindow(a,4);
        for(int x:ans)
        System.out.println(x+" ");
        System.out.println();
    }
 static class Solution{
    public int[] maxSlidingWindow(int a[],int k){
        int n = a.length;
        if(n==0) return a;
        Deque<Integer> queue =new LinkedList<>();
        int[] ans = new int[n-k+1];
        int i =0;
        for(;i<k;i++){
            while(!queue.isEmpty() && a[queue.peekLast()]<=a[i])
                queue.pollLast();
            queue.offerLast(i);
        }
        for(;i<n;i++){
            ans[i-k]=a[queue.peekFirst()];
            while(!queue.isEmpty() && queue.peekFirst()<=i-k){
                queue.pollFirst();
            }
            while(!queue.isEmpty() && a[queue.peekLast()]<=a[i])
                queue.pollLast();
            queue.offerLast(i);
        }

        ans[i-k]=a[queue.peekFirst()];
        return ans;
    }
}

}

/*
public class Solution {
   
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int n = A.size();
        if(n==0){
        return new ArrayList<>();
        }
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ANS = new ArrayList<>();
        int i =0;
        for(;i<B;i++){
            while(!queue.isEmpty() && A.get(queue.peekLast())<=A.get(i))
                queue.pollLast();
            queue.offerLast(i);
        }
         if(B == A.size()){
             ANS.add(A.get(queue.peek()));
             return ANS;
         }
        for(;i<n;i++){
            ANS.add(i-B , A.get(queue.peekFirst()));
            while(!queue.isEmpty() && queue.peekFirst()<=i-B)
                queue.pollFirst();
            while(!queue.isEmpty() && A.get(queue.peekLast())<=A.get(i))
                queue.pollLast();
            queue.offerLast(i);
        }
        ANS.add(i-B , A.get(queue.peekFirst()));
        return ANS;
    }
}
*/