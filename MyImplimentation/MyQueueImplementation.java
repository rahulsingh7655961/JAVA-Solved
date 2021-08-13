package MyImplimentation;
import LinkedList.MyQueue;

public class MyQueueImplementation {
    public static void main(String[] args) {

    MyQueue<Integer> mq = new MyQueue<>();
    
    mq.enqueue(10);
    mq.enqueue(20);
    mq.enqueue(30);
    mq.enqueue(40);
    mq.enqueue(50);
    mq.enqueue(60);

    System.out.println(mq.dequeue());
    System.out.println(mq.dequeue());
    System.out.println(mq.dequeue());
    System.out.println(mq.dequeue());
    System.out.println(mq.dequeue());
    System.out.println(mq.dequeue());
    System.out.println(mq.dequeue());

    
    }
}
