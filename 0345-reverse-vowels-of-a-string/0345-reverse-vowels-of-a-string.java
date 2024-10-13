class Solution {
    public String reverseVowels(String s) {
        int start =0, last = s.length()-1;
        char[] ch = s.toCharArray();
        while(start<last){
            char s1 = ch[start]; char s2 = ch[last];
            while(start<last&&(s1!='a'&&s1!='e'&&s1!='i'&&s1!='o'&&s1!='u'&&s1!='A'&&s1!='E'&&s1!='I'&&s1!='O'&&s1!='U')) s1=ch[++start];
            while(start<last&&(s2!='a'&&s2!='e'&&s2!='i'&&s2!='o'&&s2!='u'&&s2!='A'&&s2!='E'&&s2!='I'&&s2!='O'&&s2!='U')) s2=ch[--last];
            
            ch[start++] = s2;
            ch[last--] = s1;
        }
        return new String(ch);
    }
}