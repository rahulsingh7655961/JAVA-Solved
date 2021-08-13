package Stack;
import java.util.*;
public class stack_UsingHeap {
    
        PriorityQueue<node> pq = new PriorityQueue<node>(new StackComparator());
        int count=0;
        public boolean push(int data){
            
            node n = new node(count++,data);
            return pq.add(n);
        }
    
        public int pop(){
            return pq.poll().data;
        }
        
        int  peek(){
            if(pq.isEmpty()) return -1;
            return pq.peek().data;
        }
    
        class StackComparator implements Comparator<node>{
            @Override
            public int compare(node a,node b){
                return b.count.compareTo(a.count);
            }
        }
    
        class node{
            Integer count;
            Integer data;
            node(int count,int data){
                this.count = count;
                this.data = data;
            }
        }
}

