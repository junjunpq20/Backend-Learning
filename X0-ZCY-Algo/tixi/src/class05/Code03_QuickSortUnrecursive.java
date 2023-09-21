package class05;

import java.util.Stack;

public class Code03_QuickSortUnrecursive {
  public static void swap(int[] arr, int i, int j) {
    if (i == j) return;

    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  private void quickSort(int[] nums, int L, int R) {
    if (L >= R) return;

    Stack<int[]> stack = new Stack<>();
    stack.push(new int[] {L, R});

    while (!stack.isEmpty()) {
      int[] coords = stack.pop();

      int curL = coords[0], curR = coords[1];
      if (curL >= curR) continue;

      int pivot = nums[curL + (int) (Math.random() * (curR - curL + 1))];
      int[] newCoords = partition(nums, pivot, curL, curR);
      stack.push(new int[] {curL, newCoords[0]});
      stack.push(new int[] {newCoords[1], curR});
    }
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
}
