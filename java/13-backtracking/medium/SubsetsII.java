import java.util.*;

// Time = O(n*2^n)   ,   Space = O(n*2^n)
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res,new ArrayList<>(),nums,0);
        return res;
    }

    public void backTrack(List<List<Integer>>res,List<Integer> opt,int[] nums,int start) {
        res.add(new ArrayList<>(opt));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            opt.add(nums[i]);
            backTrack(res,opt,nums,i + 1);
            opt.remove(opt.size() - 1); 
        }
    }
}
