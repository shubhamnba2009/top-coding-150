class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dphelper(0, candidates, target, res, new ArrayList<>());
        return res;
    }

    public void dphelper(int idx, int[] candidates, int target, List<List<Integer>> res, List<Integer> ds){
        if(idx == candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        if(target>=candidates[idx]){
            ds.add(candidates[idx]);
            dphelper(idx, candidates, target-candidates[idx], res, ds);
            ds.remove(ds.size()-1);
        }

        dphelper(idx+1, candidates, target, res, ds);
    }
}