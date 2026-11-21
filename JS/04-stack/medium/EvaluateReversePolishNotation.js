// Time: O(n)
// Space: O(n)
/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
    const stack = [];
    let i=0;
    while(i<tokens.length){
        if(tokens[i]!=="+" && tokens[i]!=="-" && tokens[i]!=="*" && tokens[i]!=="/" )
            stack.push(Number(tokens[i]));
        else if(tokens[i]==="+")    stack.push(stack.pop()+stack.pop());
        else if(tokens[i]==="*")    stack.push(stack.pop()*stack.pop());
        else if(tokens[i]==="/")
            {let a=stack.pop();     stack.push(Math.trunc(stack.pop() / a));}
        else
            {let a=stack.pop();     stack.push(stack.pop() - a);}
        i++;
    }
    return stack.pop();
};
