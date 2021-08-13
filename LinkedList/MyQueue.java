package LinkedList;
import LinkedList.MyLinkedList.node;
public class MyQueue<E> {
    private node<E> front,rear;

    public void enqueue(E e){ 
        node<E> toAdd = new node<>(e); 
        if(front == null){
            front = rear = toAdd;
            return;
        }
        rear.next = toAdd;
        rear = rear.next;
    }

    public E dequeue(){
        node<E> temp = front;
       
        if(front==null){
            return null;
        }   
        front = front.next;
        if(front == null){
            rear =null;
        }
        return temp.data;
    }

}
