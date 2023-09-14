package class05;

// https://leetcode.com/problems/count-of-range-sum/
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
