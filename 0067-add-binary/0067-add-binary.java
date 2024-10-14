class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length()-1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0||j>=0){
            if(i>=0)    carry+=a.charAt(i--)-'0';
            if(j>=0)    carry+=b.charAt(j--)-'0';

            sb.append(carry%2);
            carry = carry/2;
        }
        if(carry==1)    sb.append('1');
        return sb.reverse().toString();
    }
}