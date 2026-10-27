import java.util.Deque;
import java.util.ArrayDeque;
// Time = O(n)   ,   Space = O(n)
public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int candidate = Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0; i--){
            if(stack.isEmpty()) stack.push(nums[i]);
            else if(nums[i]>stack.peek()){
                while(!stack.isEmpty() && nums[i]>stack.peek())
                    {candidate=Math.max(candidate,stack.pop());}
                stack.push(nums[i]);
            }
            else if(nums[i]<stack.peek()){
                if(nums[i]<candidate)   return true;
                else   stack.push(nums[i]);
            }
        }
        return false;
    }
}
