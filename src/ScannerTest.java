import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int tempInt;
        String tempStr;

        System.out.println("Read int");
        tempInt = scnr.nextInt();

        System.out.println("Read line");
        tempStr = scnr.nextLine();

        System.out.println(tempStr);
    }
}