class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        Function<Stack<Integer>, Integer> add = stck->{
            int nums1 = stck.pop(); int nums2= stck.pop();
            return nums2+nums1;
        };
        Function<Stack<Integer>, Integer> minus = stck->{
            int nums1 = stck.pop(); int nums2= stck.pop();
            return nums2-nums1;
        };
        Function<Stack<Integer>, Integer> div = stck->{
            int nums1 = stck.pop(); int nums2= stck.pop();
            return nums2/nums1;
        };
        Function<Stack<Integer>, Integer> mul = stck->{
            int nums1 = stck.pop(); int nums2= stck.pop();
            return nums2*nums1;
        };
        for(String str : tokens) {
            if(str.equals("+")){
                st.add(add.apply(st));
            } else if (str.equals("-")){
                st.add(minus.apply(st));
            } else if (str.equals("*")){
                st.add(mul.apply(st));
            } else if (str.equals("/")){
                st.add(div.apply(st));
            } else {
                st.add(Integer.valueOf(str));
            }
        }
        return st.pop();

    }
}