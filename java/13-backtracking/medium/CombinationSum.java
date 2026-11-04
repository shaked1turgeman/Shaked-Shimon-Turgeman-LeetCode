public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<>(),candidates,target,0,0);
        return res;
    }

    public void dfs(List<List<Integer>> res,List<Integer> p, int[] nums, int t, int s, int i){
        if (s == t) {res.add(new ArrayList<>(p));return;}
        if(i==nums.length)  return;
        if(s>t)  return;
        s+=nums[i];
        p.add(nums[i]);
        dfs(res,p,nums,t,s,i);
        s-=nums[i];
        p.remove(p.size() - 1); 
        dfs(res,p,nums,t,s,i+1);
    }
}
