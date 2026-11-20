// Time = O(n log n)
/**
 * @param {number[]} people
 * @param {number} limit
 * @return {number}
 */
var numRescueBoats = function(people, limit) {
    people.sort((x,y)=> x-y);
    let min=0, l=0, r=people.length-1;
    while(r>l){
        if(people[l]+people[r]<=limit)  {min++; l++; r--;}
        else r--;
    }
    return min+(people.length-2*min);
};
