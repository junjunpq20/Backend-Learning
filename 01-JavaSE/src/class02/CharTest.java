package class02;

public class CharTest {
    public static void main(String[] args) {
//        char c1 = '';
//        System.out.println(">>> c1, " + c1);

//        char c2 = 'x';
//        System.out.println(">>> c2, " + c2);
//
//        char c3 = '\n';
//        System.out.println(">>> c3, " + c3);
//
//        char c4 = '中';
//        System.out.println(">>> c4, " + c4);
//
//        String s1 = "122";
//        System.out.println(">>> s1, " + s1);
//
        String s2 = "123\r456aaaaaa";
        System.out.println(s2);

        String s3 = "123\r456";
        System.out.println(">>> s3, " + s3);

        String s4 = "123aaabbb\r456";
        System.out.println(s4);

        String s5 = "12345678\t123";
        System.out.println(s5);
        System.out.println("1234567812345678");

        System.out.println("123456\t123");
        System.out.println("\t123");
    }
}