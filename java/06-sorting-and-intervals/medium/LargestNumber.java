// Time = O(n * k * log(n))  ,  Space = O(n*k)
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] arr = Arrays.stream(nums)
                     .mapToObj(x -> String.valueOf(x)).toArray(size -> new String[size]);
        Arrays.sort(arr, (a, b) -> {
                    String ab = a + b;
                    String ba = b + a;
                    return ba.compareTo(ab);});
        String result = String.join("", arr);
        if (arr[0].equals("0"))    return "0";
        return result;
    }
}
