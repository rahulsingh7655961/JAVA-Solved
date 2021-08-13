package LinkedList;

public class MyDeque<E> {
   
    Node<E> head,tail;
    public boolean addFirst(E data){
        offerFirst(data);
        return true;
    }
    public void offerFirst(E data){
        Node<E> toAdd = new Node<>(data);
        if(head==null){
            head = tail = toAdd;
            return;
        }
        toAdd.next = head;
        head.prev = toAdd;
        head = toAdd;
    }
    public boolean addLast(E data){
        offerLast(data);
        return true;
    } 
    public void offerLast(E data){
        Node<E> toAdd = new Node<>(data);
        if(head==null){
            head = tail = toAdd;
            return;
        }
        tail.next=toAdd;
        toAdd.prev=tail;
        tail=toAdd;
    }
    public E removeFirst() throws Exception{ 
        E data = pollFirst();
        if(data==null)
            throw new Exception("Deque is Empty");
        return data;
    }
    public E pollFirst() {
      Node<E> toRemove = head;
      if(head == null)
        return null;
     head = head.next;
     return toRemove.data;
    }
    public E removeLast() throws Exception {
        E data = pollLast();
        if(data==null)
            throw new Exception("Deque is Empty");
        return data;
    }
    public E pollLast()  {
        if(head==null)  
            return null; 
        Node<E> toRemove = tail;
        tail=tail.prev; 
        tail.next = null;
        if(tail==null){
            head = null;
        }
        return toRemove.data;
    }
    public E getFirst() throws Exception{
        E data = peekFirst();
        if(data==null)
            throw new Exception("Deque is Empty");
        return data;
    }
    public E peekFirst() {
        if(head==null)
            return null;
        return head.data;
    }
    public E getLast() throws Exception{
        E data = peekLast();
        if(data==null)
            throw new Exception("Deque is Empty");
        return data;
    }
    public E peekLast() {
        if(head==null)
            return null;
        return tail.data;
    }
    public void dispaly(){
        Node<E> temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static class Node<E>{
        E data;
        Node<E> next,prev;
       public Node(E data){
            this.data=data;
            this.next = this.prev = null;
        }
    }

}
