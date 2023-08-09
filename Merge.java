//merge all overlapping intervals,
//and return the count of the non-overlapping intervals that cover all the intervals in the input.

import java.util.Arrays;
import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 2;
        int m = 4;

        int[][] mat = new int[n][m];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(mat, (a, b) -> a[0] - b[0]);
        // sorts array based on asc order
        int count = 0;
        int i = 0;
        while (i < n) {
            while (i < n - 1 && mat[i + 1][0] <= mat[i][1]) {
                mat[i + 1][0] = mat[i][0];
                mat[i + 1][1] = Math.max(mat[i][1], mat[i + 1][1]);
                i++;
            }
            i++;
            count++;
        }
        System.out.println("No. of non-overlapping intervals are: " + count);
    }
}
