import java.util.Random;

public class GridJumpSolver {
    int[][] grid;
    private char[][] pathMap;
    private boolean[][] visited;
    private int n;
    private int pathLength = 0;


    public GridJumpSolver(int n) {
        this.n = n;
        this.grid = new int[n][n];
        this.pathMap = new char[n][n];
        this.visited = new boolean[n][n];
        generateGrid();
    }

    // Generate n x n grid
    private void generateGrid() {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                grid[i][j] = rand.nextInt(n - 1) + 1;
            }
        }

    }

    public boolean solve(int r, int c) {
        //  Check Bounds
        if (r < 0 || r >= n || c < 0 || c >= n) return false;

        // Check if Goal Reached (Bottom-Right)
        if (r == n - 1 && c == n - 1) {
            pathMap[r][c] = 'G';
            return true;
        }

        // Avoid Cycles
        if (visited[r][c]) return false;

        visited[r][c] = true;
        int jump = grid[r][c];

        // DOWN
        if (solve(r + jump, c)) {
            pathMap[r][c] = 'D';
            pathLength++;
            return true;
        }
        // RIGHT
        if (solve(r, c + jump)) {
            pathMap[r][c] = 'R';
            pathLength++;
            return true;
        }
        // UP
        if (solve(r - jump, c)) {
            pathMap[r][c] = 'U';
            pathLength++;
            return true;
        }
        // LEFT
        if (solve(r, c - jump)) {
            pathMap[r][c] = 'L';
            pathLength++;
            return true;
        }

        visited[r][c] = false;
        return false;
    }

    public void displayResult(boolean success) {
        if (!success) {
            System.out.println("No path found for this grid.");
            printRawGrid();
            return;
        }

        System.out.println("Path Found! Length: " + pathLength);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String val = String.valueOf(grid[i][j]);
                char dir = pathMap[i][j];
                // show space if null
                System.out.printf("%2s(%s) ", val, (dir == 0 ? " " : dir));
            }
            System.out.println();
        }
    }

    private void printRawGrid() {
        for (int[] row : grid) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}