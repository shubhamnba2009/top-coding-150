class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> helper = new Stack<>();

        for(int i =0;i<tokens.length; i++){
            if(tokens[i].equals("+")){
                int sn = helper.pop(), fn = helper.pop();
                helper.add(fn+sn);
            } else if (tokens[i].equals("-")){
                int sn = helper.pop(), fn = helper.pop();
                helper.add(fn-sn);
            } else if(tokens[i].equals("*")){
                int sn = helper.pop(), fn = helper.pop();
                helper.add(fn*sn);
            } else if(tokens[i].equals("/")){
                int sn = helper.pop(), fn = helper.pop();
                helper.add(fn/sn);
            } else {
                helper.add(Integer.parseInt(tokens[i]));
            }
        }

        return helper.pop();
    }
}