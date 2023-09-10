package class04;

public class Code01_MergeSort {
  public static void mergeSortIter(int[] arr) {
    if (arr == null) return;

    int N = arr.length;
    for (int stepSize = 1; stepSize < N; stepSize *= 2) {
      for (int L = 0; L + stepSize < arr.length; L += stepSize * 2) {
        merge(arr, L, L + stepSize - 1, Math.min(L + stepSize * 2 - 1, N - 1));
      }
    }
  }

  public static void mergeSortRecur(int[] arr) {
    if (arr == null) return;

    mergeSortRecurHelper(arr, 0, arr.length - 1);
  }

  private static void mergeSortRecurHelper(int[] arr, int L, int R) {
    if (L >= R) return;

    int M = L + ((R - L) >> 1);
    mergeSortRecurHelper(arr, L, M);
    mergeSortRecurHelper(arr, M + 1, R);
    merge(arr, L, M, R);
  }

  private static void merge(int[] arr, int L, int M, int R) {
    if (L >= R) return;

    int[] help = new int[R - L + 1];
    int p1 = L, p2 = M + 1, i = 0;

    while (p1 <= M || p2 <= R) {
      help[i++] = p2 > R || p1 <= M && arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
    }

    System.arraycopy(help, 0, arr, L, help.length);
  }

  // for test
  public static int[] generateRandomArray(int maxSize, int maxValue) {
    int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
    }
    return arr;
  }

  // for test
  public static int[] copyArray(int[] arr) {
    if (arr == null) {
      return null;
    }
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[i];
    }
    return res;
  }

  // for test
  public static boolean isEqual(int[] arr1, int[] arr2) {
    if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
      return false;
    }
    if (arr1 == null && arr2 == null) {
      return true;
    }
    if (arr1.length != arr2.length) {
      return false;
    }
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }

  // for test
  public static void printArray(int[] arr) {
    if (arr == null) {
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  // for test
  public static void main(String[] args) {
    int testTime = 500000;
    int maxSize = 100;
    int maxValue = 100;
    System.out.println("测试开始");
    for (int i = 0; i < testTime; i++) {
      int[] arr1 = generateRandomArray(maxSize, maxValue);
      int[] arr2 = copyArray(arr1);
      mergeSortRecur(arr1);
      mergeSortIter(arr2);
      if (!isEqual(arr1, arr2)) {
        System.out.println("出错了！");
        printArray(arr1);
        printArray(arr2);
        break;
      }
    }
    System.out.println("测试结束");
  }
}
