import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter an inter");

        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            System.out.println(">>> num, " + num);
        }
    }
}