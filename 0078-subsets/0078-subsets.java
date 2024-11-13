class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res,0, nums, new ArrayList<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int idx, int[] nums, List<Integer> ds){
        res.add(new ArrayList<>(ds));

        for(int i = idx; i<nums.length;i++){
                ds.add(nums[i]);
            backtrack(res, i+1, nums, ds);
            ds.remove(ds.size()-1);
        }
    }
}