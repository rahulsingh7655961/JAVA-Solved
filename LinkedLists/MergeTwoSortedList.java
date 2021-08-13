package LinkedLists;
import LinkedLists.LinkedList.Node;
public class MergeTwoSortedList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        
        Node head = new  Node(-1);
        l1.addLast(head, 10);
        l1.addLast(head,25);
        l1.addLast(head,30);
        head=l1.removeFirst(head);
        l1.display(head);
        // Node head1 = new Node(10);
        // l2.addLast(head1, 5);
        // l2.addLast(head1,27);
        // l2.addLast(head1,54);
        // head1=l2.removeFirst(head1);
        // l2.display(head1);
        Node head1 = l2.takeInput();
        
        head = merge(head, head1);
        l1.display(head);

    }

    private static Node merge(Node l1,Node l2) {
         if(l1 == null || l2 == null)
          return l1!=null ? l1 : l2;

        Node c1 = l1;
        Node c2 = l2;
        Node dummy = new Node(-1);
        Node prev = dummy;
        while(c1!=null && c2!=null){
            if(c1.data<c2.data){
                prev.next = c1;
                c1 = c1.next;
            }
            else{
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = c1!=null ? c1 : c2;
        return dummy.next;
    }
}
