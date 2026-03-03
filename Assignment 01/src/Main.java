public class Main {
    public static void main(String[] args) {
        Polynomial f = new Polynomial();
        f.setCoefficient(2, 3.0f);
        f.setCoefficient(1, -2.0f);
        f.setCoefficient(0, 10.0f);
        System.out.println("f(x) = " + f);

        System.out.println("f(7.0) = " + f.evaluate(7.0f));

        Polynomial g = new Polynomial();
        g.setCoefficient(2, 3.0f);
        g.setCoefficient(1, 1.0f);
        g.setCoefficient(0, -2.0f);

        Polynomial h = f.add(2.0, g);
        System.out.println("h(x) = f(x) + 2g(x) = " + h);

        System.out.println("f'(x) = " + f.derivative());
    }
}