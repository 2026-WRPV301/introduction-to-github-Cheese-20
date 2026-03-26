public class Main {
    public static void main(String[] args) {
        int size = 5;
        System.out.println("Testing Random Grid (Size " + size + "):");
        GridJumpSolver solver = new GridJumpSolver(size);
        boolean found = solver.solve(0, 0);
        solver.displayResult(found);

        // Manual Test
        System.out.println("\nTesting Known Path Grid:");
        GridJumpSolver manual = new GridJumpSolver(3);
        manual.grid = new int[][]{
                {2, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        boolean manualFound = manual.solve(0, 0);
        manual.displayResult(manualFound);
    }
}