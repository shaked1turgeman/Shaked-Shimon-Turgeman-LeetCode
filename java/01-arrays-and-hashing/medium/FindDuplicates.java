import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int target = nums[i] - 1;

                int temp = nums[target];
                nums[target] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}
