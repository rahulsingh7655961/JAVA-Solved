package Stack;

import java.util.*;

public class StockSpanProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0; i<n; i++)
                arr[i]=sc.nextInt();
            int[] res = stockSpan(arr, n);
            for (int i = 0; i < n; i++) 
                    System.out.print(res[i] + " ");
             System.out.println();
             sc.close();
         }
    }
    public static int[] stockSpan(int[] arr,int n) {
        int ans[]=new int[n];
        Deque<Integer> s = new LinkedList<>();

        for(int i=0;i<n;i++){

            while(!s.isEmpty() && arr[s.peek()] <= arr[i] )
                s.pop();
            ans[i] = s.isEmpty() ? 1 : i - s.peek();
            s.push(i);
        }
        
        return ans;
    }
}
/*
class StockSpanner {
        Stack<Item> s = new Stack<>();

        public int next(int price) {
            int span = 1;
            while (!s.isEmpty() && s.peek().price <= price)
                span += s.pop().span;
            s.push(new Item(span, price));
            return s.peek().span;
        }

        class Item {
            final int span, price;

            Item(int spanCount, int val) {
                this.span = spanCount;
                this.price = val;
            }
        }
    }
*/
/*
class StockSpanner {
        
    Deque<int[]> s = new LinkedList<>();
    public int next(int price) {
            int span = 1;
            while(!s.isEmpty() && s.peek()[0] <= price )
                span +=s.pop()[1];
            
            s.push(new int[]{price,span});
            return span;
    }
}
*/