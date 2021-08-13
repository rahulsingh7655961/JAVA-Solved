package MyImplimentation;
import LinkedList.MyStack;
public class MyStackImplimentation {
    public static void main(String[] args) throws Exception {
        MyStack<Integer> stack= new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        int popped=stack.pop();
        System.out.println("\n"+popped);
        stack.push(100);
        int peeked=stack.peek();
        System.out.println(peeked);
        stack.display();
        
    }
    
}
