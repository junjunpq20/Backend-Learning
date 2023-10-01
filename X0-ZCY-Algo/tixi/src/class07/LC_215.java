package class07;

public class LC_215 {
  // https://leetcode.com/problems/kth-largest-element-in-an-array/
  class Solution {
    // Time complexity: O(N), Space complexity: O(1)
    // Why?
    // 1. The partition function is O(N) in total, N + N / 2 + N / 4 + ... + 1 = 2N
    // 2. The partition function is in-place
    public int findKthLargest(int[] nums, int k) {
      int N = nums.length;
      k = nums.length - k;

      int L = 0, R = N - 1;
      while (L < R) {
        int pivot = nums[L + (int) (Math.random() * (R - L + 1))];
        int[] ltGt = partition(nums, pivot, L, R);
        int lt = ltGt[0], gt = ltGt[1];

        if (k >= gt) {
          L = gt;
        } else if (k <= lt) {
          R = lt;
        } else {
          return nums[k];
        }
      }

      return nums[k];
    }

    private int[] partition(int[] nums, int pivot, int L, int R) {
      int lt = L - 1, gt = R + 1;
      int i = L;
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
      return new int[] {lt, gt};
    }

    private void swap(int[] arr, int i, int j) {
      if (i == j) return;

      arr[i] = arr[i] ^ arr[j];
      arr[j] = arr[i] ^ arr[j];
      arr[i] = arr[i] ^ arr[j];
    }
  }
}
