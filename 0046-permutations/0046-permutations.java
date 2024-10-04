class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutation(nums, res, new ArrayList<>());
        return res;
    }

    public void permutation(int[] nums,  List<List<Integer>> res, List<Integer> curr){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int num:nums){
            if(!curr.contains(num)){
                curr.add(num);
                permutation(nums, res, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}