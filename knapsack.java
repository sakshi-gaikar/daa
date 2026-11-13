
import java.util.*;

class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] w = new int[n];
        int[] p = new int[n];
        int[] id = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and profit of item " + (i + 1) + ": ");
            w[i] = sc.nextInt();
            p[i] = sc.nextInt();
            id[i] = i + 1;
        }

        System.out.print("Enter knapsack capacity: ");
        int cap = sc.nextInt();

        // Sort by profit/weight ratio
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((double)p[i] / w[i] < (double)p[j] / w[j]) {

                    int t = p[i];
                    p[i] = p[j];
                    p[j] = t;

                    t = w[i];
                    w[i] = w[j];
                    w[j] = t;

                    t = id[i];
                    id[i] = id[j];
                    id[j] = t;
                }
            }
        }

        double total = 0;

        System.out.println("\nSelected Items:");

        for (int i = 0; i < n && cap > 0; i++) {

            if (w[i] <= cap) {
                total += p[i];
                cap -= w[i];

                System.out.println("Item " + id[i] +
                        ": 100% - Full Item");

            } else {
                int selectedWeight = cap;

                total += (double)p[i] / w[i] * selectedWeight;

                double percentage =
                        (double) selectedWeight / w[i] * 100;

                System.out.printf(
                        "Item %d: %.2f%% - Partial Item%n",
                        id[i], percentage);

                cap = 0;
            }
        }

        System.out.println("\nMaximum Profit = " + total);

        sc.close();
    }
}

