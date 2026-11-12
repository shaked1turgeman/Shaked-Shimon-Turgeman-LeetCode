public class DifferentWaysToAddParentheses {
    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression))   return memo.get(expression);
        if(onlyDig(expression)) return Arrays.asList(Integer.parseInt(expression));
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<expression.length(); i++){
            if(!onlyDig(String.valueOf(expression.charAt(i)))){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for(Integer l : left){
                    for(Integer r : right){
                        switch (expression.charAt(i)) {
                            case '+':
                                res.add(r + l);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(r * l);
                                break;
                        }
                    }
                }
            }
        }
        memo.put(expression, res);
        return res;
    }

    private boolean onlyDig(String exp){
        for(int i=0; i<exp.length(); i++)   
            if(exp.charAt(i)<'0' || exp.charAt(i)>'9')  return false;
        return true;
    }
}
