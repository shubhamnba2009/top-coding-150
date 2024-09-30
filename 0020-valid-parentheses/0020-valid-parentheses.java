class Solution {
    public boolean isValid(String s) {
        char[] st = new char[s.length()];
        int top =-1;

        for(char c: s.toCharArray()){
            if(c=='('||c=='{'||c=='[')  st[++top] = c;
            else if(top>-1&&st[top]=='{'&&c=='}') top--;
            else if(top>-1&&st[top]=='['&&c==']') top--;
            else if(top>-1&&st[top]=='('&&c==')') top--;
            else return false;
        }

        return top==-1?true:false;
    }
}