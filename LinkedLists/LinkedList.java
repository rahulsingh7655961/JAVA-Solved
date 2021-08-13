package LinkedLists;

import java.util.Scanner;

public class LinkedList {
    
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public  Node takeInput(){
        Node head = null;
        Node tail=null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data of the Linked List:-");
        int data = sc.nextInt();
        while(data!=-1){
            Node newNode = new Node(data);
            if(head==null){
                head=newNode;
                tail=newNode;
            }
            else{
                // O(n^2) time
                // Node temp = head;
                // while(temp.next!=null)
                //     temp = temp.next;
                // temp.next = newNode;

                tail.next = newNode;//O(n) time
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        
        sc.close();
        display(head);
        return head;
    }
    void display(Node head){
        Node temp =head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();     
    }    
    Node addFirst(Node head,int data){
        Node toAdd = new Node(data);
        if(head==null){
            head = toAdd;
            return head;
        }
        toAdd.next = head;
        return toAdd;
    }
    Node addLast(Node h,int data){
        Node head = h;
        Node toAdd = new Node(data);
        if(head==null){
            head = toAdd;
            return head;
        }
       Node temp = head;
       while(temp.next!=null)
            temp = temp.next;
        temp.next= toAdd;
        return temp;     
    }
    Node insert(Node head,int data,int pos){
        Node toInsert = new Node(data);
        if(pos==0){
            toInsert.next = head;
            return toInsert;
        }
        if(head==null)
            return head;
        head.next = insert(head.next,data,pos-1);       
        return head;
    }
    Node removeFirst(Node head){
        if(head==null||head.next==null)
        return null;
        Node temp = head.next;
        head = null;
        head = temp;
        return head;
    }
    Node removeLast(Node h){
        if(h==null||h.next==null)
            return null;
        Node temp=h;
        while(temp.next.next!=null)
            temp = temp.next;
        temp.next=null;
        return h;
    }
    Node delete(Node head,int pos){
        if(head==null)
            return head;
        if(pos==0){
            return head.next;
        }
        head.next = delete(head.next, pos-1);
        return head;
    }
    
     Node mid(Node head){

        if(head==null||head.next==null)
            return head;
        Node slow=head,fast=head;
        boolean isFirstMid=true;
        boolean isSecondMid=!isFirstMid;
        //this will return first mid 
        while(fast.next!=null && fast.next.next!=null && isFirstMid){
            slow = slow.next;
            fast = fast.next.next;
        }
        //for second meet
        while(fast!=null && fast.next!=null && isSecondMid){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    Node reverse(Node head){
        if(head==null||head.next==null)
            return head;
        Node current = head;
        Node previous = null;
        Node forward = null;

        while(current!=null){
            forward = current.next;//backup
            current.next = previous;//Connection

            previous = current;//traverse
            current = forward;     
        }
        return previous;
    }
    Node Reverse(Node head){
        if(head==null || head.next==null)
            return head;
        Node temp=head.next;
        Node smallHead = Reverse(head.next);
        temp.next = head;
        head.next = null;
        return smallHead;
    }
     boolean isPalindrome(Node head){
        if(head==null||head.next==null)
        return true;
        //with changing the original list
        // Node mid = mid(head);
        // mid.next = reverse(mid.next);
        // mid = mid.next;
        // while(mid!=null){
        //     if(head.data != mid.data)
        //         return false;
        //     head = head.next;
        //     mid =mid.next;
        // }
        // mid = mid(head);
        // mid.next = reverse(mid.next);
        // display(head);
        // return true;

        Node mid = mid(head);
        Node newHead = mid.next;
        mid.next=null;
        newHead = reverse(newHead);

        Node c1 = head;
        //display(c1);
        Node c2 = newHead;
        //display(newHead);

        boolean ans = true;
        while(c2!=null){
            if(c1.data != c2.data){
                ans = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        } 
        newHead = reverse(newHead);
        mid.next = newHead;
        display(head);
        return ans;
    }
    
   
    public static void main(String[] args) {
            LinkedList list = new LinkedList();
        //  list.head = new Node(85);
        //  list.head.next = new Node(15);
        //  list.head.next.next = new Node(4);
        //  list.head.next.next.next = new Node(20);
 
        // System.out.println("Given Linked list");
        //  list.display(head);
        Node head = list.takeInput();

        // list.addLast(head, 50);
        // list.display(head);
        // head=list.addFirst(head,10);
        // list.display(head);
        // head = list.removeLast(head);
        // list.display(head);
        // // head = list.removeFirst(head);
        // // list.display(head);
        // Node mid = list.mid(head);
        // list.display(mid);
        head = list.reverse(head);
        System.out.println("Reversed linked list ");
         list.display(head);
        //System.out.println(list.isPalindrome(head)); 
        // list.insert(head, 10, 3);
        list.delete(head, 3);
        list.display(head);
        

    }
} 
