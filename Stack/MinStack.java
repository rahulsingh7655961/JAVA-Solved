package Stack;
import java.util.*;
public class MinStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // stackWithExtraSpace s = new stackWithExtraSpace();
        stackWithoutExtraSpace s = new stackWithoutExtraSpace();
        int n =sc.nextInt();
        while(n-- >0){
            int key = sc.nextInt();
            switch (key) {
                case 1: s.push( sc.nextInt());
                    break;
                case 2:s.pop();
                    break;
                case 3:System.out.println( s.peek());
                    break;
                case 4: System.out.println(s.getMin());
            }
        }
        sc.close();
    }
}

class  stackWithoutExtraSpace{
    int minElement;
    Deque<Integer> s = new LinkedList<>();
    int getMin(){
        if(s.isEmpty()) return -1;
        return minElement;
    }
    int peek(){
        if(s.isEmpty()) return -1;
        else{ 
                if(s.peek() > minElement) return s.peek();

                else return minElement;
        }
    }
    int pop(){
        if(s.isEmpty()) return -1;
        int top = s.peek();
        if( top >= minElement) return s.pop();
        else{
                int ans =minElement;
                minElement = 2*minElement - top;
                s.pop();
                return ans;
        }
    }
    void push(int x){
        
        if(s.isEmpty()){
            s.push(x);
            minElement = x;
        }
        else if(x>=minElement) 
            s.push(x);
        else{
             s.push(2*x-minElement);
             minElement = x;       
        }
    }
}
class stackWithExtraSpace{
    int min;
    Deque<Integer> s = new LinkedList<>();
    Deque<Integer> ss = new LinkedList<>();
 
    int getMin()
    {
        if(s.isEmpty()) return -1;
        
        return ss.peek();
    }
    int pop()
    {
		if(s.isEmpty()) return -1;
        int ans = s.pop();
        if(ss.peek()== ans)
            ss.pop();
        return ans;
    }
    void push(int x)
    {
		s.push(x);
        if(ss.isEmpty() || ss.peek() > x)
            ss.push(x);
    }	
}