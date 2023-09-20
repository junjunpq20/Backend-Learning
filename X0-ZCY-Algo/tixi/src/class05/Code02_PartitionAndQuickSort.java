package class05;

// https://leetcode.com/problems/sort-an-array/

public class Code02_PartitionAndQuickSort {
  public static void swap(int[] arr, int i, int j) {
    if (i == j) return;

    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public int[] sortArray(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
    return nums;
  }

  private void quickSort(int[] nums, int L, int R) {
    if (L >= R) return;

    int pivot = nums[L + (int) (Math.random() * (R - L + 1))];

    int lt = L - 1, gt = R + 1;
    int i = L, cur;

    while (i < gt) {
      cur = nums[i];

      if (cur > pivot) {
        swap(nums, i, --gt);
      } else if (cur < pivot) {
        swap(nums, i++, ++lt);
      } else {
        i++;
      }
    }

    quickSort(nums, L, lt);
    quickSort(nums, gt, R);
  }
}
