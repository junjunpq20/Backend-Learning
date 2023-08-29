package class01;

import java.util.Arrays;

public class Code04_BSExist {
    public static boolean exist(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) return true;

        int L = 0, R = sortedArr.length - 1, M, cur;

        while (L < R) {
            M = L + ((R - L) >> 1);
            cur = sortedArr[M];

            if (cur == target) {
                return true;
            } else if (cur > target) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }

        return sortedArr[L] == sortedArr[R];
    }

    public static boolean bf(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 1000000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (bf(arr, value) != exist(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
