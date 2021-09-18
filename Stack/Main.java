package Stack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        System.out.println("Original Deck - " + n + " Cards");
        System.out.println();

        int[] ans = solve(n);
        System.out.println("Method #1 _______ Bruteforce method");
        System.out.println("Last Remaining card - " + ans[0]);
        System.out.println("Iterations " + ans[1]);

        System.out.println();

        int last = lastCard(n);
        int count = findCount(n);
        System.out.println("Method #2 _______ Optimized method");
        System.out.println("Last Remaining card - " + last);
        System.out.println("Iterations " + count);

        sc.close();
    }

    private static int[] solve(int n) {
        Queue<Integer> stack = new LinkedList<>();
        int ans[] = new int[2];
        int count = 2;
        for (int i = 1; i <= n; i++) {
            stack.add(i);
        }

        while (stack.size() >= 2) {
            stack.remove();
            stack.add(stack.peek());
            stack.remove();
            count++;
        }
        ans[0] = stack.peek();
        ans[1] = count;

        return ans;
    }

    private static int lastCard(int n) {
        if ((n & (n - 1)) == 0)
            return n;
        int log = findCount(n);
        int diff = n - (1 << log);

        return (diff << 1);
    }

    private static int findCount(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n >> 1;
        }
        return count - 1;
    }
}
