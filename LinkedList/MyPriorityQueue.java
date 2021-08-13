package LinkedList;

import java.util.PriorityQueue;

public class MyPriorityQueue {
     public static void main(String[] args) {
         PriorityQueue<String> pq = new PriorityQueue<>();

         pq.add("rahul");
         pq.add("vikash");
         pq.add("Alok");
         pq.add("subham");
         System.out.println(pq);

         System.out.println(pq.remove());
         System.out.println(pq.remove());
         System.out.println(pq.remove());
         System.out.println(pq.remove());
     }
}
