public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for(int i=1; i<nums.length; i++){
            int l=0,    r=nums.length-1;
            while(r>l   && i!=l &&  i!=r){
                if (Math.abs(target-(nums[l]+nums[r]+nums[i]))<Math.abs(target-sum))
                    sum=nums[l]+nums[r]+nums[i];
                if(target==nums[l]+nums[r]+nums[i]) return target;
                else if(target<(nums[l]+nums[r]+nums[i]))    r--;
                else    l++;
            }
        }
        return sum;
    }
}
