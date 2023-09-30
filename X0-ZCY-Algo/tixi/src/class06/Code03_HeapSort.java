package class06;

// https://leetcode.com/problems/sort-an-array/
public class Code03_HeapSort {
  class Solution {
    public int[] sortArray(int[] nums) {
      int N = nums.length;

      // for (int i = 0; i < N; i++) {
      //     heapInsert(nums, i);
      // }

      for (int i = N - 1; i >= 0; i--) {
        heapify(nums, i, N);
      }

      for (int i = N - 1; i >= 0; i--) {
        swap(nums, 0, i);
        heapify(nums, 0, i);
      }

      return nums;
    }

    // 大根堆
    private void heapInsert(int[] arr, int i) {
      while (arr[i] > arr[(i - 1) / 2]) {
        swap(arr, i, (i - 1) / 2);
        i = (i - 1) / 2;
      }
    }

    private void heapify(int[] arr, int i, int heapSize) {
      while ((i * 2 + 1) < heapSize) {
        int j = i * 2 + 1;
        j = j + 1 < heapSize && arr[j + 1] > arr[j] ? j + 1 : j;
        if (arr[i] >= arr[j]) break;
        swap(arr, i, j);
        i = j;
      }
    }

    private void swap(int[] arr, int i, int j) {
      if (i == j) return;

      arr[i] = arr[i] ^ arr[j];
      arr[j] = arr[i] ^ arr[j];
      arr[i] = arr[i] ^ arr[j];
    }
  }
}
