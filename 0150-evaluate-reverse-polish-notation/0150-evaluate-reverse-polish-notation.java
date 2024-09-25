class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==1)
            return Integer.valueOf(tokens[0]);
        Stack<Integer> st = new Stack<>();
        for(String s:tokens){
            if(!Character.isDigit(s.charAt(s.length()-1))){
                int first = st.pop();
                int second = st.pop();
                if(s.charAt(0)=='+') st.add(first+second);
                else if(s.charAt(0)=='-') st.add(second-first);
                else if (s.charAt(0)=='*') st.add(first*second);
                else st.add(second/first);
            } else {
                st.add(Integer.valueOf(s));
            }
        }
        return Integer.valueOf(st.pop());
    }
}