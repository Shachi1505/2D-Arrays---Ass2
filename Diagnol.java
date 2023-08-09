public int[] findDiagonalOrder(int[][] mat) {
    int row = mat.length;
    int col = mat[0].length;
    int n = row * col;
    int[] a = new int[n];
    int i = 0, j = 0, k = 0;
    boolean toTop = true;

    while (true) {
        a[k++] = mat[i][j];
        
        if (k == n) break;

        if (toTop) {
            // Check boundary conditions and update i and j
            if (i == 0 && j < col - 1) {
                j++; // Move right within the first row
                toTop = false;
            } else if (j == col - 1) {
                i++; // Move down when at the last column
                toTop = false;
            } else {
                i--; j++; // Move diagonally up
            }
        } else {
            // Check boundary conditions and update i and j
            if (j == 0 && i < row - 1) {
                i++; // Move down within the first column
                toTop = true;
            } else if (i == row - 1) {
                j++; // Move right when at the last row
                toTop = true;
            } else {
                i++; j--; // Move diagonally down
            }
        }
    }
    
    return a;
}
