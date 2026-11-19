// Time = O(n^2), Space = O(n^2)
/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    const r=board.length, c=board[0].length;
    const cols = Array.from({ length: r }, () => []);
    const boxes = Array.from({ length: 9 }, () => []);
    for(let m=0; m<r; m++){
        if(!isValid(board[m]))   return false;
        for(let j=0; j<c; j++){
            const boxIndex = Math.floor(m / 3) * 3 + Math.floor(j / 3);
            boxes[boxIndex].push(board[m][j]);
            cols[j].push(board[m][j]);
        }  
    }
    for(let i=0; i<r; i++)  if(!isValid(cols[i]))   return false;
    for(let i=0; i<9; i++)  if(!isValid(boxes[i]))   return false;
    return true;
};

function isValid(nums) {
    const filtered = nums.filter(x => x !== ".");
    const set = new Set(filtered);
    return filtered.length === set.size;
}
