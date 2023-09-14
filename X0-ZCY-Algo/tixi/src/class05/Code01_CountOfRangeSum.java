package class05;

// https://leetcode.com/problems/count-of-range-sum/
// Given an integer array nums and two integers lower and upper, return the number of range sums
// that lie in [lower, upper] inclusive.
//
// Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j
// inclusive, where i <= j.

// 已知 lower, upper
// 1. 构建前缀和数组，方便计算 Sum(i, j)，定义 PreSum(i) = Sum(0, i)
// 2. 假设我知道了 PreSum(j) = X, 又如果我知道 PreSum(i) lies in [X - upper, X - lower]
// 那么可以断定 Sum(i + 1, j) lies in [lower, upper]，因为 PreSum(i) + Sum(i + 1, j) = PreSum(j)
// 3. 对 PreSum array 做归并排序，在 merge 时，对右数组的每一个 PreSum(j)，利用滑动窗口找到所有满足条件的左数组的 PreSum(i)
// 4. 由于归并排序时左右子数组时已经排好序且递增的，所以滑动窗口的 left right 值只会增加，不会减少，这样就保证了 merge 的效率是正常的
public class Code01_CountOfRangeSum {
  class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
      int N = nums.length;
      if (N < 1) return 0;

      long[] sums = new long[N];
      sums[0] = nums[0];
      for (int i = 1; i < N; i++) {
        sums[i] = sums[i - 1] + nums[i];
      }

      return process(sums, new long[N], 0, N - 1, lower, upper);
    }

    private int process(long[] sums, long[] aux, int L, int R, int lower, int upper) {
      if (L == R) {
        return sums[L] >= lower && sums[R] <= upper ? 1 : 0;
      }
      int M = (L + R) >>> 1;
      return process(sums, aux, L, M, lower, upper)
          + process(sums, aux, M + 1, R, lower, upper)
          + merge(sums, aux, L, M, R, lower, upper);
    }

    private int merge(long[] sums, long[] aux, int L, int M, int R, int lower, int upper) {
      if (L > R) return 0;
      if (L == R) {
        return sums[L] >= lower && sums[R] <= upper ? 1 : 0;
      }

      for (int i = L; i <= R; i++) {
        aux[i] = sums[i];
      }

      int count = 0;

      int j = M + 1;
      int windowL = L, windowR = L;
      while (j <= R) {
        long min = aux[j] - upper, max = aux[j] - lower;

        while (windowL <= M && aux[windowL] < min) {
          windowL++;
        }
        while (windowR <= M && aux[windowR] <= max) {
          windowR++;
        }
        count += windowR - windowL;

        j++;
      }

      int p1 = L, p2 = M + 1;
      for (int k = L; k <= R; k++) {
        if (p2 > R || p1 <= M && aux[p1] < aux[p2]) {
          sums[k] = aux[p1++];
        } else {
          sums[k] = aux[p2++];
        }
      }

      return count;
    }
  }
}
