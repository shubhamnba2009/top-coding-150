class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationHelper(0, candidates, target, res, new ArrayList<>());
        return res;
    }

    public void combinationHelper(int idx, int[] candidates, int target, List<List<Integer>> res, List<Integer> ds){
        if(idx==candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            } return;
        }

        if(candidates[idx]<=target){
            ds.add(candidates[idx]);
            combinationHelper(idx, candidates, target-candidates[idx], res, ds);
            ds.remove(ds.size()-1);
        }

        combinationHelper(idx+1, candidates, target, res, ds);

    }
}