package Stack;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> mainStack = new LinkedList<>();
        Deque<Integer> maxStack = new LinkedList<>();
        maxStack.push(Integer.MIN_VALUE);

        int n =sc.nextInt();
        while(n-- >0){
            int key = sc.nextInt();
            switch (key) {
                case 1:
                    int toAdd = sc.nextInt();
                    mainStack.push(toAdd);
                    int currmax = maxStack.peek();
                    maxStack.push(Math.max(toAdd, currmax));
                    break;
                case 2:
                    mainStack.pop();
                    maxStack.pop();
                    break;
                case 3:
                    System.out.println(maxStack.peek());
            }
        }
        sc.close();
    }
}
