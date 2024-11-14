class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> l = new ArrayList<>();

        for(int i = 1;i<=n;i++)l.add(i);
        int startIdx = 0;
        while(l.size()>1){
            int idx = (startIdx+k-1)%l.size();
            l.remove(idx);
            startIdx = idx;
        }
        return l.getFirst();
    }
}