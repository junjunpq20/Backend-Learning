package class01;

/**
 * 实现整数的二进制 32 位全打印
 */
public class Code06_PrintB {

    public static String sol(int num) {
        char[] chars = new char[32];

        for (int i = 0; i < 32; i++) {
            chars[32 - i - 1] = ((1 << i) & num) == 0 ? '0' : '1';
        }

        return new String(chars);
    }

    public static String bf(int num) {
        String res = Integer.toBinaryString(num);
        return "0".repeat(32 - res.length()) + res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            String expected = bf(i);
            String actual = sol(i);
            if (!expected.equals(actual)) {
                System.out.println(">>> expected: " + expected);
                System.out.println(">>> actual: " + actual);
            }

            System.out.println(">>> i, " + i);
            System.out.println(~i + 1);
        }
    }
}
