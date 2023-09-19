package class05;

public class LC_75 {
  class Solution {
    public void sortColors(int[] nums) {
      int pivot = 1;
      int lt = -1, gt = nums.length;
      int i = 0;

      while (i < gt) {
        int cur = nums[i];

        if (cur > pivot) {
          swap(nums, i, --gt);
        } else if (cur < pivot) {
          swap(nums, i++, ++lt);
        } else {
          i++;
        }
      }
    }

    private void swap(int[] nums, int i, int j) {
      if (i == j) return;

      nums[i] = nums[i] ^ nums[j];
      nums[j] = nums[i] ^ nums[j];
      nums[i] = nums[i] ^ nums[j];
    }
  }
}
