package LinkedLists;
import LinkedLists.LinkedList.Node;
public class removeDuplicate {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node head=list.takeInput();
        head = removeDuplicates(head);
        list.display(head);

    }
    private static Node removeDuplicates(Node head) {
        if(head==null || head.next==null)
            return head;
        Node t1=head;
        Node t2=head.next;
        while(t2 != null){
            if(t1.data==t2.data)
                t2 = t2.next;
            else{
                t1.next = t2;
                t2 = t2.next;
                t1 = t1.next;
            }
        } 
        t1.next = t2;
        return head;
    }
}
