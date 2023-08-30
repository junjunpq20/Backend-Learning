package class01;

import java.util.Arrays;

public class Code05_BSNearLeft {
    public static int find(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) return -1;

        int L = 0, R = sortedArr.length - 1, M, cur, res = -1;

        while (L <= R) {
            M = L + ((R - L) >> 1);
            cur = sortedArr[M];

            if (cur >= target) {
                R = M - 1;
                res = M;
            } else {
                L = M + 1;
            }
        }

        return res;
    }

    public static int bf(int[] sortedArr, int num) {
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] >= num) {
                return i;
            }
        }
        return -1;
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
        int testTime = 100000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (bf(arr, value) != find(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
