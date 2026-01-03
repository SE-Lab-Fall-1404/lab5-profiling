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

    /**
     * Original inefficient method (replaced by tempOptimized)
     * This method used ArrayList which caused boxing/unboxing overhead
     * and excessive memory allocation due to dynamic resizing.
     * 
     * Original code:
     * public static void temp() {
     *     ArrayList a = new ArrayList();
     *     for (int i = 0; i < 10000; i++) {
     *         for (int j = 0; j < 20000; j++) {
     *             a.add(i + j);
     *         }
     *     }
     * }
     */
    
    /**
     * Optimized version using int[] array instead of ArrayList to avoid
     * boxing/unboxing overhead and StringBuilder for efficient string building.
     * This significantly reduces memory allocation and improves performance.
     */
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