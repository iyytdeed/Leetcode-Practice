class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        int[] hash = new int[nums.length];
        for(int i = 0; i < hash.length; i++) hash[i] = i;
        myQuickSort(nums, hash,0 , nums.length - 1);

        for(int i = 0; i < nums.length - 1; i++){
            int find = mySearch(nums, i + 1, nums.length, target - nums[i]);
            if(find != -1){
                ret[0] = hash[i];
                ret[1] = hash[find];
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
        if(hi - lo == 0) return lo;
        if(hi - lo == 1){
            if(nums[lo] > nums[hi]){
                int tmp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = tmp;
                tmp = hash[lo];
                hash[lo] = hash[hi];
                hash[hi] = tmp;
                return hi;
            }
            else return lo;
        }

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

    private int mySearch(int[] nums, int lo, int hi, int target){
        if(lo < 0) lo = 0;
        if(hi > nums.length) hi = nums.length;
        while(lo < hi){
            int mi = lo + (hi - lo)/2;
            if(nums[mi] > target) hi = mi;
            else if(nums[mi] < target) lo = mi + 1;
            else return mi;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main solution = new Main();
        int[] nums = {-1,-2,-3,-4,-5};
        int[] ret = solution.twoSum(nums, -8);
        return;
    }
}
