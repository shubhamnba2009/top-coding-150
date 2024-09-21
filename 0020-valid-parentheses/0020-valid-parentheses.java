class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char a: s.toCharArray()){
            if(a=='{'||a=='('||a=='[')  st.add(a);

            else if(a=='}'&&!st.isEmpty()&&st.peek()=='{')  st.pop();
            else if(a==')'&&!st.isEmpty()&&st.peek()=='(')  st.pop();
            else if(a==']'&&!st.isEmpty()&&st.peek()=='[')  st.pop();
            else return false;
        }
        if(!st.isEmpty())
            return false;

        return true;
    }
}