class Solution {
    public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
    for(char ch:s.toCharArray()){
        if(ch=='('||ch=='{'||ch=='[') st.add(ch);
        else if(!st.isEmpty()&&ch==')'&&st.peek()=='(') st.pop();
        else if(!st.isEmpty()&&ch=='}'&&st.peek()=='{') st.pop();
        else if(!st.isEmpty()&&ch==']'&&st.peek()=='[') st.pop();
        else st.add(ch);
    }
    return st.isEmpty();
    }
}