public class FindTheKthLargestIntegerInTheArray {
    public String kthLargestNumber(String[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int[] range = partition(nums, left, right);
            if (target < range[0])      right = range[0] - 1;
            else if (target > range[1])      left = range[1] + 1;
            else   return nums[target];
        }
        return nums[target];
    }

    private int compare(String a, String b){
        if(a.length()>b.length())   return 1;
        else if(a.length()<b.length())  return -1;
        else return a.compareTo(b);
    }

    private int[] partition(String[] nums, int left, int right) {
        String pivot = nums[right];
        int low = left, mid = left, high = right;
        while (mid <= high) {
            int cmp = compare(nums[mid], pivot);
            if (cmp < 0) {
                String temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if (cmp > 0) {
                String temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
            else    mid++;
        }
        return new int[]{low, high};
    }
}
