class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String t : tokens){
            if(Character.isDigit(t.charAt(t.length()-1))){
                st.add(Integer.valueOf(t));
            } else {
                int fn = st.pop(), sn = st.pop();
                if(t.charAt(0)=='+')    st.add(fn+sn);
                else if(t.charAt(0)=='-')   st.add(sn-fn);
                else if(t.charAt(0)=='/')   st.add(sn/fn);
                else    st.add(sn*fn);
            }
        }
        return st.pop();
    }
}