package medium;

import java.util.*;

// Time = O(n*n!)   ,   Space = O(n*n!)
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        path(res,new ArrayList<>(),nums,used);
        return res;
    }

    public void path(List<List<Integer>> res, List<Integer> perm, int[] nums, boolean[] used){
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                perm.add(nums[i]);
                used[i]=true;
                path(res,perm,nums,used);
                perm.remove(perm.size() - 1);
                used[i]=false;
            }
        }
    }
}
