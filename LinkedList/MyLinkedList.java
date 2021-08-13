package LinkedList;

public class MyLinkedList<E>{
    node<E> head;
    
    public void add(E data){
            node<E> toAdd = new node<E>(data);
            if(head==null){
            head=toAdd;
            return;
            }
            node<E> temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = toAdd;
    }

    public void addAt(int index,E data) throws  IllegalArgumentException  {
            if(index<0)
            throw new IllegalArgumentException("Invalid Index "+index);
            node<E> toAdd = new node<E>(data); 
            if(index== 0) {
                toAdd.next=head;
                head = toAdd;
                return;
            }
            node<E> temp = head;
            for(int i=0;i<index-1;i++){
                temp = temp.next;
                if(temp == null)
                    throw new IllegalArgumentException("Value of "+i+
                    " is greater than the no. of nodes.");
            }
            toAdd.next = temp.next;
            temp.next = toAdd;       
    }
    public E remove() throws IllegalArgumentException{
            
            if (head==null)
                throw new IllegalArgumentException("List is Empty");
            node<E> temp = head;
            if(temp.next==null){
                node<E> toRemove = head;
                head=null;
                return (E)toRemove.data;
            }
            while(temp.next.next!=null){
                temp = temp.next;
            }
            node<E> toRemove=temp.next;
            temp.next =null;
            return (E)toRemove.data;
    }
    public void removeAt(int index){
            if(index == 0)
            head = head.next;
            int num=1;
            node<E> temp = head;
            while(temp!=null && num<index){
                temp = temp.next;
                num++;
            }temp.next = temp.next.next;
    }
    public void deleteAt(int position){
        if(head==null)
            return ;
        if(position==0)
            head = head.next;   
        int num=0;
        node<E> temp=head;
        while(temp.next!=null){
                if(num==position-1){
                    temp.next=temp.next.next;  
                    break;
            }
            temp=temp.next;
            num++;
         }
    }
    public E getLast(){
            if (head==null)
                throw new IllegalArgumentException("List is Empty");
            node<E> temp = head;
            if(temp.next==null){
                node<E> toGet = head;
                return toGet.data;
            }
            while(temp.next.next!=null){
                temp = temp.next;
            }
            node<E> toGet=temp.next; 
            return toGet.data;
    }
    public E getNode(node<E> head, int positionFromTail) {
        node<E>  temp = head;
        for (int i = 0; head.next != null; i++) {
            head = head.next;
            if ( i >= positionFromTail)
             temp = temp.next;
        }
        return temp.data; 
    }
    public node<E> reverse(node<E> head) {
        node<E> curr = head;
        node<E> prev=null;
        node<E> next=null;
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr =next;
        }
        return prev;
    }
    public node<E> Reverse(node<E> head){
        if(head==null||head.next==null){
            return head;
        }
        Reverse(head.next);
        node<E> temp = head.next;//head.next.next=head;
        temp.next = head;        //
        head.next=null;
        return head;
    }
    
    public void print(){
            node<E> temp = head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            } System.out.println();
    }
    public void reversePrint(){
      node<E> temp=head;
       node<E> prev=null;
       node<E> next=null;
        while(temp!=null){
        next=temp.next;
        temp.next=prev;
        prev=temp;
        temp=next;
        }
        while(prev!=null){
            System.out.print(prev.data+" ");
            prev=prev.next;
            }System.out.println();
        }
    public boolean isEmpty(){
        return (head==null);
    }
    public static class node<E>{
            public E data;
            public node<E> next;

        public node(E data){
                this.data = data;
                next = null;
            }
    }
}
