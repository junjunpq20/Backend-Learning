package class01;

import java.util.Arrays;

public class Code01_SelectionSort {
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] bf(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static int[] randomArray(int size) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = (int) (Math.random() * 10000) - 5000;
        }
        return res;
    }

    public static void main(String[] args) {
        long prevDuration = 0;
        int length = 10;
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println(">>> length, " + length);
            long startTime = System.currentTimeMillis();
            int times = 1000;
            for (int i = 0; i < times; i++) {
                int[] input = randomArray(length);

                int[] expected = bf(Arrays.copyOf(input, input.length));
                int[] actual = selectionSort(Arrays.copyOf(input, input.length));
                if (!Arrays.equals(expected, actual)) {
                    System.out.println(Arrays.toString(expected));
                    System.out.println(Arrays.toString(actual));
                    break;
                }
            }
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println(">>> duration, " + duration + " ms");
            if (prevDuration != 0) {
                long ratio = duration / prevDuration;
                System.out.println(">>> ratio, " + ratio);
            }
            prevDuration = duration;
            length *= 2;
        }
    }
}
