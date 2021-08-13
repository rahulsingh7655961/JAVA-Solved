package LinkedList;

public class MyStack<E> {
    MyLinkedList<E> ll = new MyLinkedList<>();
    public void push(E e) {
        ll.add(e);
    }
   public  E pop() throws  Exception{ 
        if(ll.isEmpty())
            throw new Exception("Stack is Empty!");
        return ll.remove();    
    }
    public E peek() throws Exception {
        if(ll.isEmpty())
            throw new Exception("Stack is Empty!");
        return ll.getLast();
    }
    public void display(){
        ll.print();
    }
}
