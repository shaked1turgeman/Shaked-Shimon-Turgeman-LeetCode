// Time = O(n), Space = O(1)
/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    let left=0, right=numbers.length-1;
    while(right>left){
        const sum = numbers[left] + numbers[right];
        if(sum>target)     right--;
        else if(sum<target)    left++;
        else    return [left + 1, right + 1];
    }
    return [];
};
