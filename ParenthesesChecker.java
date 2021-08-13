import java.util.Deque;
import java.util.LinkedList;
public class ParenthesesChecker {
    public static void main(String[] args) {
        String str ="(){[]{}{}{})()()";
        boolean isPar=checkParentheses(str);
        System.out.println(isPar);
    }
    static boolean checkParentheses(String x){
        Deque<Character> Stack = new LinkedList<>();
        for(int i=0;i<x.length();i++){
            char check = x.charAt(i);
            if(check == '(' || check == '{' || check == '['){
                Stack.push(check);
                continue;
            }
            if(Stack.isEmpty()) return false;
            if(check == ')'){
                if(Stack.peek()=='(')
                    Stack.pop();
                else return false;
            }
            if(check == '}'){
                if(Stack.peek()=='{')
                    Stack.pop();
                else return false;
            }
            if(check == ']'){
                if(Stack.peek()=='[')
                    Stack.pop();
                else return false;
            }
        }
        return (Stack.isEmpty());
    }

}
/*
public boolean isValid(String s) {
Deque<Character> stack = new LinkedList<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
*/