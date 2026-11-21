// Time: O(n log n)
// Space: O(n)
/**
 * @param {number} target
 * @param {number[]} position
 * @param {number[]} speed
 * @return {number}
 */
var carFleet = function(target, position, speed) {
    const cars = position.map((pos, i) => [pos, speed[i]]);
    cars.sort((a, b) => a[0] - b[0]);
    const stack = [];
    stack.push((target - cars[cars.length-1][0]) / cars[cars.length-1][1]);
    for(let i=cars.length-2;i>=0; i--){
        let time = (target - cars[i][0]) / cars[i][1];
        if(stack[stack.length-1]<time)    stack.push(time);
    }
    return stack.length;
};
