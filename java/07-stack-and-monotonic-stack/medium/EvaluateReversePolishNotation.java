import java.util.Deque;
import java.util.ArrayDeque;
// Time = O(n)   ,   Space = O(n)
public class EvaluateReversePolishNotation
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack= new ArrayDeque<>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+"))   {int j=stack.pop()+stack.pop();  stack.push(j);}
            else if(tokens[i].equals("-")) 
                {int k =stack.pop();    int j=stack.pop()-k;  stack.push(j);}
            else if(tokens[i].equals("*")) {int j=stack.pop()*stack.pop();  stack.push(j);}
            else if(tokens[i].equals("/")) 
                {int k =stack.pop(); int j=stack.pop()/k;  stack.push(j);}
            else stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}
