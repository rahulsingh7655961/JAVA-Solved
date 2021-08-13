package LinkedLists;
import java.util.*;
public class MergeKsorteLists {

        public static Scanner sc = new Scanner(System.in);
    
        public static class ListNode {
            int val = 0;
            ListNode next = null;
    
            ListNode(int val) {
                this.val = val;
            }
        }
    
        public static ListNode mergeKLists(ListNode[] lists) {
            if(lists.length==0)
            return null;

            return mergeKLists(lists,0,lists.length-1);
        }
    
        private static ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if(start>end) return null;
            if(start==end) return lists[start];
            int mid = start + (end-start)/2;

            ListNode l1 = mergeKLists(lists, start, mid);
            ListNode l2 = mergeKLists(lists, mid+1, end);

            return merge(l1,l2);
        }
       
        private static ListNode merge(ListNode l1, ListNode l2) {
            if(l1 == null || l2 == null)
            return l1!=null ? l1 : l2;
  
          ListNode c1 = l1;
          ListNode c2 = l2;
          ListNode dummy = new ListNode(-1);
          ListNode prev = dummy;
          while(c1!=null && c2!=null){
              if(c1.val<c2.val){
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


        public static void printList(ListNode node) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
        }
    
        public static ListNode createList(int n) {
            ListNode dummy = new ListNode(-1);
            ListNode prev = dummy;
            while (n-- > 0) {
                prev.next = new ListNode(sc.nextInt());
                prev = prev.next;
            }
    
            return dummy.next;
        }
    
        public static void main(String[] args) {
            int n = sc.nextInt();
            ListNode[] list = new ListNode[n];
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                list[i] = createList(m);
            }
    
            // ListNode head = mergeKLists(list);
            // printList(head);
            ListNode head1 = mergeKlistsPQ(list);
            printList(head1);

        }
        static ListNode mergeKlistsPQ(ListNode[] lists){
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{return a.val - b.val;});

            for(ListNode l : lists)
                if(l!=null)
                    pq.add(l);
            ListNode dummy = new ListNode(-1);
            ListNode prev = dummy;
            while(!pq.isEmpty()){
                ListNode node = pq.remove();
                prev.next = node;
                prev = prev.next;
                node = node.next;

                if(node!=null)
                    pq.add(node);
            }
            return dummy.next;
        }
    }
