import java.util.Deque;
import java.util.ArrayDeque;
// Time = O(n)  ,  Space = O(n)
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{')  stack.push(c);
            else if (stack.isEmpty())   return false;
            else{
                if(c==']'   &&  stack.peek()=='[')  stack.pop();
                else if (c=='}'   &&  stack.peek()=='{')  stack.pop();
                else if(c==')'   &&  stack.peek()=='(')  stack.pop();
                else    return false;
            }
        }
        return stack.isEmpty();
    }
}
