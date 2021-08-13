package MyImplimentation;
import LinkedList.MyDeque;
public class MyDequeImplimentation {
    public static void main(String[] args) throws Exception {
        MyDeque<Integer> dq = new MyDeque<>();
        dq.addFirst(10);
        dq.addFirst(20); 
        dq.removeLast(); 
        dq.addLast(30);
        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());
        dq.removeFirst();
        dq.dispaly();
    }
   
}
