public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int k=0;
        for(int i=1; i< nums.length; i++){
            if(nums[i] != nums[k]) nums[++k] = nums[i];
        }
        return k+1;
    }
}