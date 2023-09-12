package class04;

//  本题测试链接 : https://leetcode.com/problems/reverse-pairs/
public class Code04_BiggerThanRightTwice {
  public int reversePairs(int[] nums) {
    int N = nums.length;
    int[] aux = new int[N];

    int count = 0;

    for (int mergeSize = 1; mergeSize < N; mergeSize *= 2) {
      for (int L = 0; L + mergeSize < N; L += mergeSize * 2) {
        count += merge(nums, aux, L, L + mergeSize - 1, Math.min(N - 1, L + mergeSize * 2 - 1));
      }
    }

    return count;
  }

  private int merge(int[] nums, int[] aux, int L, int M, int R) {
    if (L >= R) return 0;

    for (int i = L; i <= R; i++) {
      aux[i] = nums[i];
    }

    int count = 0;
    int i = L, j = M + 1;

    while (i <= M && j <= R) {
      // 不可以把下面的逻辑放在 for 循环内判断
      // 如果 aux[i] <= (long) 2 * aux[j]，i 应该往右走
      // 但是如果是 merge sort 的 merge 的判断逻辑，此时 j 有可能往右走，例如 aux[i] > aux[j] but aux[i] <= 2 * aux[j]
      // 这会导致 aux[i] <= (long) 2 * aux[j] 这个条件一直存在

      // 例如:
      // left arr: 18 19 20 21
      // right arr: 9 9 9
      // 18 == 9 * 2, but 18 > 9
      if (aux[i] > (long) 2 * aux[j]) {
        count += M - i + 1;
        j++;
      } else {
        i++;
      }
    }

    i = L;
    j = M + 1;

    for (int k = L; k <= R; k++) {
      if (j > R || i <= M && aux[i] < aux[j]) {
        nums[k] = aux[i++];
      } else {
        nums[k] = aux[j++];
      }
    }
    return count;
  }
}
