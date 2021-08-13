package Stack;
import java.util.*;
public class StackUsingHeap {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        stack_UsingHeap s = new stack_UsingHeap();
        int n =sc.nextInt();
        while(n-- >0){
            int key = sc.nextInt();
            switch (key) {
                case 1: boolean a =s.push( sc.nextInt());
                        System.out.println(a);
                    break;
                case 2:
                    System.out.println(s.pop()+" Popped");
                    break;
                case 3:System.out.println( s.peek());
                    
                //case 4: System.out.println(s.getMin());
            }
        }
        sc.close();
    }
}
/*
import java.util.Comparator;
import java.util.PriorityQueue;

public class StacksUsingPriorityQueue {

static class pair{

int val;
int key;

public pair(int val, int key) {
this.val = val;
this.key = key;
}

public int getVal() {
return val;
}

public void setVal(int val) {
this.val = val;
}

public int getKey() {
return key;
}

public void setKey(int key) {
this.key = key;
}

@Override
public String toString() {
return "pair{" +
"val=" + val +
", key=" + key +
'}';
}
}
static class KeyComparator implements Comparator<pair> {

// Overriding compare()method of Comparator
// for descending order of cgpa
public int compare(pair p1, pair p2) {
if (p1.key < p2.key)
return 1;
else if (p1.key>p2.key)
return -1;
return 0;
}

}

static class Stack {

PriorityQueue<pair> stack;
int order;

public Stack(){
stack=new PriorityQueue<pair>( 10, new KeyComparator() );
order=0;
}
public void push(int val){
pair newpair= new pair(val,order++);
stack.add( newpair);
}

public void pop(){
stack.remove( );
order--;
}

public int peek(){
return stack.peek().val;
}

public void print(){
Object[] array= stack.toArray();
for(Object val:array){
System.out.println(val.toString());
}
}

}

public static void main(String[] args) {
Stack stack=new Stack();
stack.push( 50 );
stack.push( 29 );
stack.push( 30 );
stack.push( 67 );
stack.print();

stack.pop();
System.out.println("After popping");
stack.print();
}
}


*/