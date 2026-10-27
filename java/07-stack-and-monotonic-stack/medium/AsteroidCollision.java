import java.util.Deque;
import java.util.ArrayDeque;
// Time = O(n)   ,   Space = O(n)
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<asteroids.length; i++){
            if(!stack.isEmpty()){
                if(stack.peek()>0 && asteroids[i]<0){
                    int winner=stack.peek();
                    while(!stack.isEmpty() && stack.peek()>0){
                        if(Math.abs(stack.peek())<Math.abs(asteroids[i])) 
                            {winner=asteroids[i];   stack.pop();}
                        else if (Math.abs(stack.peek())==Math.abs(asteroids[i]))
                            {winner=0;   stack.pop();    break;}
                        else    {winner=stack.peek();  break;}
                    }
                    if(winner==asteroids[i])    stack.push(asteroids[i]);
                }
                else{
                    stack.push(asteroids[i]);
                }
            }
            else stack.push(asteroids[i]);
        }
        int[] res = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--) res[i]=stack.pop();
        return res;
    }
}
