public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int shouldBeReplaced = nums.length - 2;
        while (shouldBeReplaced >= 0 && nums[shouldBeReplaced] >= nums[shouldBeReplaced + 1]) shouldBeReplaced--;
        if (shouldBeReplaced >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[shouldBeReplaced]) j--;
            swap(nums, shouldBeReplaced, j);
        }
        reverse(nums, shouldBeReplaced + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}