package class06;

// https://leetcode.com/problems/sort-an-array/
public class Code03_HeapSort {
  class Solution {
    public static void swap(int[] arr, int i, int j) {
      if (i == j) return;

      arr[i] = arr[i] ^ arr[j];
      arr[j] = arr[i] ^ arr[j];
      arr[i] = arr[i] ^ arr[j];
    }

    public int[] sortArray(int[] nums) {
      heapSort(nums);
      return nums;
    }

    private void heapSort(int[] nums) {
      // 构建大根堆

      // O(NlogN)
      for (int i = 0; i < nums.length; i++) {
        heapInsert(nums, i);
      }

      //      // OR
      //      // O(N)
      //      for (int i = nums.length - 1; i >= 0; i--) {
      //        heapify(nums, i, nums.length);
      //      }

      int heapSize = nums.length;
      swap(nums, 0, --heapSize);
      while (heapSize > 0) {
        heapify(nums, 0, heapSize);
        swap(nums, 0, --heapSize);
      }
    }

    // 拆入一个元素，不断往上走
    private void heapInsert(int[] arr, int index) {
      while (arr[index] > arr[(index - 1) / 2]) {
        swap(arr, index, (index - 1) / 2);
        index = (index - 1) / 2;
      }
    }

    // 不断往下走，重塑堆结构
    private void heapify(int[] arr, int i, int heapSize) {
      while ((i * 2 + 1) < heapSize) {
        int j = i * 2 + 1;
        if ((j + 1) < heapSize && arr[j + 1] > arr[j]) j++;
        if (arr[i] >= arr[j]) break;
        swap(arr, i, j);
        i = j;
      }
    }
  }
}
