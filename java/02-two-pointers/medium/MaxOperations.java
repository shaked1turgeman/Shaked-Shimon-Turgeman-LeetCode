public class MaxOperations {
    //Time = O(n) , Space = O(n)
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> mapK = new HashMap<>();
        int maxi=0;
        for(int i =0; i<nums.length;i++){
            if(!mapK.containsKey(k-nums[i]))  
                mapK.put(nums[i], mapK.getOrDefault(nums[i], 0) + 1);
            else{
                if (mapK.get(k-nums[i])>1) {
                    mapK.put(k-nums[i], mapK.get(k-nums[i]) - 1);
                    maxi++;
                }
                else{
                    mapK.remove(k-nums[i]);
                    maxi++;
                }
            }
        }
        return maxi;
    }

    //Alternative approach: Sorting + Two Pointers
    // Time = O(n * log(n))
    public int maxOperationsWithPointers(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0, r=nums.length-1, maxi=0;
        while(r>l){
            int sum = nums[l]+nums[r];
            if (sum<k)   l++;
            else if (sum>k)   r--;
            else    {maxi++;   l++;    r--;}
        }
        return maxi;
    }    
}
