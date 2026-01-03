import java.util.Scanner;

public class JavaCup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press number1: ");
        int i = scanner.nextInt();
        System.out.println("Press number2: ");
        int j = scanner.nextInt();
        System.out.println("Press number3: ");
        int k = scanner.nextInt();
        tempOptimized();
        eval(i, j, k);
    }

    public static void eval(int i, int j, int k) {
        if (i * i + j * j == k * k || i * i == j * j + k * k || j * j == i * i + k * k) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void tempOptimized() {
        int rows = 10000;
        int cols = 20000;
        int total = rows * cols;
        int[] array = new int[total];
        StringBuilder sb = new StringBuilder(total * 2);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = i + j;
                array[i * cols + j] = value;
                sb.append(value).append(' ');
            }
        }
        String result = sb.toString();
        System.out.println("Processed " + result.length() + " characters.");
    }
}