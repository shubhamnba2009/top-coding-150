class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int idx, List<List<Integer>> res, List<Integer> ds){
        res.add(new ArrayList<>(ds));
        for(int i = idx; i<nums.length;i++){
            ds.add(nums[i]);
            backtrack(nums, i+1, res, ds);
            ds.remove(ds.size()-1);
            }
        }
}