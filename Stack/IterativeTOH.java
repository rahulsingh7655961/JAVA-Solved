package Stack;

import java.util.Stack;

public class IterativeTOH {
    
    public static void solveTowerOfHanoi(int n){
        Stack<Integer> source = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        char s = 'A';
        char d = 'C';
        char a = 'B';
        int totalNumberMoves = (int)Math.pow(2, n) - 1;
        if(n%2==0){
            char temp = d;
            d = a;
            a = temp;
        }
        System.out.println("Total Number of Moves :"+totalNumberMoves);
        for(int i=n; i>=1; i--)
            source.push(i);
        
        for(int i=1; i<=totalNumberMoves; i++){
            
            if(i%3==1){
            moveDisk(source, destination, s, d);
            }
            else if(i%3==2)
            moveDisk(source, aux, s, a);
        
            else if(i%3==0)
            moveDisk(destination, aux, d, a);
        
        }
    }
    public static void moveDisk(Stack<Integer> source,Stack<Integer> destination,char sChar,char dChar){
        int x;
        if(!source.isEmpty() && (destination.isEmpty() || destination.peek()>source.peek())){
            x = source.pop();
            destination.push(x);
            System.out.println(x +" Moved From "+sChar +" to "+ dChar);
        }
        else if(!destination.isEmpty()){
            x = destination.pop();
            source.push(x);
            System.out.println(x +" Moved From "+dChar +" to "+ sChar);
        }
    }
    public static void main(String[] args) {
            int n=3;
            solveTowerOfHanoi(n);
        }
}
