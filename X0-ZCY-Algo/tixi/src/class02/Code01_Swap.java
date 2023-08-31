package class02;

import class01.Code05_BSNearRight;

public class Code01_Swap {
    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int times = 1000000;
        int arrSize = 100;
        for (int i = 0; i < times; i++) {
            int[] randomArr = Code05_BSNearRight.generateRandomArray(arrSize, 100);

            if (randomArr.length < 2) continue;

            int idx1 = (int) (Math.random() * randomArr.length), idx2 = (int) (Math.random() * randomArr.length);

            int num1 = randomArr[idx2], num2 = randomArr[idx1];
            swap(randomArr, idx1, idx2);

            if (randomArr[idx1] != num1 || randomArr[idx2] != num2) {
                System.out.println("Failed ");
                break;
            }
        }
    }
}
