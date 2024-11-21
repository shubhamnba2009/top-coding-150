class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> l = new ArrayList<>();

        for(int i = 1;i<=n;i++)l.add(i);

        int startVal = 0;

        while(l.size()>1){
            int eliIdx = (startVal + k-1)%l.size(); 
            l.remove(eliIdx);
            startVal = eliIdx;
        }
        return l.getFirst();
    }
}