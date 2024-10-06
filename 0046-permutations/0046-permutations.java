class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        premuteHelper(nums, res, new ArrayList<>());

        return res;
    }

    public void premuteHelper(int[] nums, List<List<Integer>> res, List<Integer> ds){
        if(ds.size()==nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int n:nums){
            if(!ds.contains(n)){
                ds.add(n);
                premuteHelper(nums, res, ds);
                ds.remove(ds.size()-1);
            }
        }
    }
}