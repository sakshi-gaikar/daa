
import java.util.*;

class Fibonacci {

    // Non-recursive method
    static void iterative(int n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    // Recursive method
    static int recursive(int n) {
        if (n <= 1)
            return n;

        return recursive(n - 1) + recursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        long s = System.nanoTime();
        System.out.print("Non-recursive: ");
        iterative(n);
        System.out.println("\nTime: " + (System.nanoTime() - s) + " ns");

        s = System.nanoTime();
        System.out.print("Recursive: ");
        for (int i = 0; i < n; i++)
            System.out.print(recursive(i) + " ");

        System.out.println("\nTime: " + (System.nanoTime() - s) + " ns");

        sc.close();
    }
}

