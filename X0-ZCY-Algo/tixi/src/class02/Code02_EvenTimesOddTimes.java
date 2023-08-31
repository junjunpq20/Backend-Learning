package class02;

/**
 * <a href="https://leetcode.com/problems/single-number/description/">LeetCode 136. Single Number</a>
 */
public class Code02_EvenTimesOddTimes {

    // arr中，只有一种数，出现奇数次
    public static int printOddTimesNum1(int[] arr) {
        int res = 0;
        for (int i : arr) {
            res ^= i;
        }
        return res;
    }
}
