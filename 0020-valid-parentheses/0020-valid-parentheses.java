class Solution {
    public boolean isValid(String s) {
        char[] ch = new char[s.length()];
        int top = -1;

        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='[') ch[++top] = c;
            else if(c==')'&&top>=0&&ch[top]=='(') top--;
            else if(c=='}'&&top>=0&&ch[top]=='{') top--;
            else if(c==']'&&top>=0&&ch[top]=='[') top--;
            else return false;
        }
        return top==-1?true:false;
    }
}