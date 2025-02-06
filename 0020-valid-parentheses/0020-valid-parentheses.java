class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char a:s.toCharArray()){
            if(a=='('||a=='['||a=='{') st.add(a);
            else if(!st.isEmpty()&&a==')'&&st.peek()=='(') st.pop();
            else if(!st.isEmpty()&&a==']'&&st.peek()=='[') st.pop();
            else if(!st.isEmpty()&&a=='}'&&st.peek()=='{') st.pop();
            else return false;
        }

        return st.isEmpty()?true:false;
    }
}