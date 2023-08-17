package class02;

public class FloatTest {
    public static void main(String[] args) {
        double d1 = 123;
        System.out.println(">>> d1, " + d1);

        double d2 = 3.14;
        System.out.println(">>> d2, " + d2);
        double d3 = 314E-2;
        System.out.println(">>> d3, " + d3);

        double d4 = 1.2222233333;
        System.out.println(">>> d4, " + d4);
        double d5 = 2.33333444445555566666;
        System.out.println(">>> d5, " + d5);

        double d6 = 1.2F;
        float f1 = 1.2F;
        System.out.println(">>> d6 === f1, " + (d6 == f1));
    }
}