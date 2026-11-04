package medium;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        picker(res,new ArrayList<>(),nums,0);
        return res;
    }

    public void picker(List<List<Integer>> res, List<Integer> opt, int[] nums, int i){
        if(i==nums.length)  {res.add(new ArrayList<>(opt));  return;}
        picker(res,opt,nums,i+1);
        opt.add(nums[i]);
        picker(res,opt,nums,i+1);
        opt.remove(opt.size() - 1);
    }
}
