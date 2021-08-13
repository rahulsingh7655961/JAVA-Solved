package LinkedLists;
import java.util.HashMap;
import java.util.Scanner;
public class CopyOfListWithRandomPointers {
    public static void main(String[] args) {
        Node head = takeInput();
        Node newHead = copyRandomList(head);
        display(head);
        System.out.println(head);
        display(newHead);
        System.out.println(newHead);

    }
    

   static Node copyRandomList(Node head) {
            HashMap<Node,Node> map = new HashMap<>();
            Node current = head;
            
            Node newHead = new Node(-1);
            Node previous = newHead;
            
            while(current!=null){
                
                Node node = new Node(current.val);
                previous.next = node;
                map.put(current,node);
                
                previous = previous.next;
                current = current.next;
            }
            newHead = newHead.next;
            
            Node c1 = head;
            Node c2 = newHead;
            
            while(c1!=null){
                c2.random = c1.random!=null ? map.get(c1.random) : null;
                
                c1 = c1.next;
                c2 = c2.next;
            }
            return newHead;
        }
        static void display(Node head){
            Node temp =head;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp = temp.next;
            }
            System.out.println();     
        }   
        static Node takeInput(){
            Node head = null;
            Node tail=null;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter val of the Linked List:-");
            int val = sc.nextInt();
            while(val!=-1){
                Node newNode = new Node(val);
                if(head==null){
                    head=newNode;
                    tail=newNode;
                }
                else{
                    tail.next = newNode;//O(n) time
                    tail = tail.next;
                }
                val = sc.nextInt();
            }
            
            sc.close();
            return head;
        }
 }
class Node{
    int val;
    Node next;
    Node random;
    Node(int val){
        this.val=val;
        this.next=null;
        this.random=null;
    }
}