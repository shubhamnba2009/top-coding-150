class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int idx, List<List<Integer>> res, List<Integer> ds){
        if(ds.size() == nums.length){
            res.add(new ArrayList<>(ds));
                return;
        }

        for(int n : nums){
            if(!ds.contains(n)) {
                ds.add(n);
                backtrack(nums, idx+1, res, ds);
                ds.remove(ds.size()-1);
            }
        }
    }
}