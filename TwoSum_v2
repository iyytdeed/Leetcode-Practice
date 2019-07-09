class TwoSum_v2 {
    // 1. sort and SAVE IDX_ARRAY(hash) after sort
    // 2. find
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        int[] hash = new int[nums.length];
        for(int i = 0; i < hash.length; i++) hash[i] = i;
        myQuickSort(nums, hash,0 , nums.length - 1);
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            if(nums[lo] + nums[hi] < target) lo++;
            else if (nums[lo]+ nums[hi] > target) hi--;
            else {
                ret[0] = hash[lo];
                ret[1] = hash[hi];
                return ret;
            }
        }
        return ret;
    }

    private int myQuickSort(int[] nums, int[] hash, int lo, int hi){
        if(hi <= lo) return -1;
        int mi = partition(nums, hash, lo, hi);
        myQuickSort(nums, hash, lo, mi - 1);
        myQuickSort(nums, hash, mi + 1, hi);
        return 1;
    }

    private int partition(int[] nums, int[] hash, int lo, int hi){
        if(lo > hi) return -1;
        int base = nums[lo];
        int base_idx = hash[lo];
        while(lo < hi){
            while(lo < hi && nums[hi] >= base) hi--;
            if(lo >= hi) break;
            else{
                nums[lo] = nums[hi];
                hash[lo] = hash[hi];
            }
            while(lo < hi && nums[lo] <= base) lo++;
            if(lo >= hi) break;
            else {
                nums[hi] = nums[lo];
                hash[hi] = hash[lo];
            }
        }
        nums[lo] = base;
        hash[lo] = base_idx;
        return lo;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main solution = new Main();
        int[] nums = {-1,-2,-3,-4,-5};
        int[] ret = solution.twoSum(nums, -8);
        return;
    }
}
