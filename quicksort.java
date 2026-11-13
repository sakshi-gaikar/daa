
import java.util.*;

class QuickSort {
    static int partition(int a[], int low, int high) {
        int pivot = a[high], i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i+1];
        a[i+1] = a[high];
        a[high] = t;

        return i+1;
    }

    // Deterministic Quick Sort
    static void deterministic(int a[], int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            deterministic(a, low, p-1);
            deterministic(a, p+1, high);
        }
    }

    // Randomized Quick Sort
    static void randomized(int a[], int low, int high) {
        if (low < high) {
            int r = low + new Random().nextInt(high-low+1);

            int t = a[r];
            a[r] = a[high];
            a[high] = t;

            int p = partition(a, low, high);
            randomized(a, low, p-1);
            randomized(a, p+1, high);
        }
    }




    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int b[] = a.clone();
        int c[] = a.clone();

        long s = System.nanoTime();
        deterministic(b, 0, n-1);
        System.out.println("Deterministic: " + Arrays.toString(b));
        System.out.println("Time: " + (System.nanoTime() - s) + " ns");

         s = System.nanoTime();
        randomized(c, 0, n-1);
        System.out.println("Randomized: " + Arrays.toString(c));
        System.out.println("Time: " + (System.nanoTime() - s) + " ns");

        sc.close();
    }
}

