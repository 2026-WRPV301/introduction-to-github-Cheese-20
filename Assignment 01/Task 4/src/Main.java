//import Polynomial;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TASK 4: INTEGRATED TEST SUITE ===");

        //Polynomial test case
        System.out.println("\n Polynomial ");
        Polynomial p = new Polynomial();
        p.setCoefficient(2, 1);
        p.setCoefficient(1, -3);
        p.setCoefficient(0, 2);

        System.out.println("1. String Output: " + p.toString());
        System.out.println("2. Evaluate at x=1 (Root): " + p.evaluate(1.0f));
        System.out.println("3. Evaluate at x=0 (Intercept): " + p.evaluate(0.0f));
        System.out.println("4. Derivative: " + p.derivative().toString());
        System.out.println("5. Add scaled poly (p + 2p): " + p.add(2.0, p).toString());

        //   GRID JUMP
        System.out.println("\n GridJumpSolver");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Test Case " + i + ":");
            GridJumpSolver solver = new GridJumpSolver(4);
            boolean success = solver.solve(0, 0);
            solver.displayResult(success);
            System.out.println("==============================");
        }
    }
}