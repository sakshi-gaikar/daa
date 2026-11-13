import java.util.*;

class NQueen {
    static int n;
    static int[][] board;

    static boolean safe(int row, int col) {
        for (int i = 0; i < row; i++) {
            int d = row - i;

            if (board[i][col] == 1 ||
                (col-d >= 0 && board[i][col-d] == 1) ||
                (col+d < n && board[i][col+d] == 1))
                return false;
        }
        return true;
    }

    static boolean solve(int row) {
        if (row == n) return true;

        for (int col = 0; col < n; col++) {
            if (safe(row, col)) {
                board[row][col] = 1;

                if (solve(row + 1)) return true;

                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        n = sc.nextInt();

        board = new int[n][n];

        System.out.print("Enter first queen column (0 to " + (n-1) + "): ");
        int col = sc.nextInt();

        board[0][col] = 1;

        if (solve(1)) {
            System.out.println("N-Queens Solution:");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
//for (int[] row : board) {
  //  for (int x : row)
    //    System.out.print(x + " ");
    //System.out.println();
//}
        } else {
            System.out.println("No solution exists!");
        }

        sc.close();
    }
}

