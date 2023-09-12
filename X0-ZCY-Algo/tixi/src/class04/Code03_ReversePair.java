package class04;

public class Code03_ReversePair {

  public static int reverPairNumber(int[] arr) {
    if (arr == null || arr.length < 2) {
      return 0;
    }

    int[] aux = new int[arr.length];
    int N = arr.length;
    int count = 0;
    for (int stepSize = 1; stepSize < N; stepSize *= 2) {
      for (int L = 0; L + stepSize < arr.length; L += stepSize * 2) {
        count += merge(arr, aux, L, L + stepSize - 1, Math.min(L + stepSize * 2 - 1, N - 1));
      }
    }

    return count;
  }

  private static int merge(int[] arr, int[] aux, int L, int M, int R) {
    if (L >= R) return 0;

    for (int k = L; k <= R; k++) {
      aux[k] = arr[k];
    }

    int count = 0;
    int p1 = L, p2 = M + 1;

    while (p1 <= M && p2 <= R) {
      if (aux[p1] > aux[p2]) {
        count += (M - p1 + 1);
        p2++;
      } else {
        p1++;
      }
    }

    p1 = L;
    p2 = M + 1;
    for (int k = L; k <= R; k++) {
      if (p2 > R || p1 <= M && aux[p1] < aux[p2]) {
        arr[k] = aux[p1++];
      } else {
        arr[k] = aux[p2++];
      }
    }

    return count;
  }

  // for test
  public static int comparator(int[] arr) {
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          ans++;
        }
      }
    }
    return ans;
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
      if (reverPairNumber(arr1) != comparator(arr2)) {
        System.out.println("Oops!");
        printArray(arr1);
        printArray(arr2);
        break;
      }
    }
    System.out.println("测试结束");
  }
}
