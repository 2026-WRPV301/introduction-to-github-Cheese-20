import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Float> coefficient;

    public Polynomial(){
        coefficient = new ArrayList<>();
    }


    public float getCoefficient(int power) {
        if (power < 0 || power >= coefficient.size()) {
            return 0.0f;
        }
        return coefficient.get(power);
    }

    public void setCoefficient(int power, float value){
        while (coefficient.size() <= power) {
            coefficient.add(0.0f);
        }
        coefficient.set(power, value);
    }


    public float evaluate(float x){
        float total = 0;
        for (int i = 0; i < coefficient.size(); i++) {
            total += coefficient.get(i) * (float) Math.pow(x, i);
        }
        return total;
    }

    public Polynomial add(double scalar, Polynomial other) {
        int maxDegree = Math.max(this.coefficient.size(), other.coefficient.size()) - 1;
        Polynomial result = new Polynomial();

        for (int i = 0; i <= maxDegree; i++) {
            float val1 = this.getCoefficient(i);
            float val2 = other.getCoefficient(i);


            result.setCoefficient(i, (float)(val1 + (scalar * val2)));
        }
        return result;
    }

    public Polynomial derivative() {
        Polynomial derived = new Polynomial();


        if (coefficient.size() <= 1) {
            derived.setCoefficient(0, 0.0f);
            return derived;
        }

        for (int i = 1; i < coefficient.size(); i++) {
            float newCoeff = i * coefficient.get(i);
            derived.setCoefficient(i - 1, newCoeff);
        }
        return derived;
    }

    @Override
    public String toString() {
        if (coefficient.isEmpty()) return "0";

        boolean allZero = true;
        for (Float c : coefficient) {
            if (c != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) return "0";

        StringBuilder sb = new StringBuilder();


        for (int i = coefficient.size() - 1; i >= 0; i--) {
            float coeff = coefficient.get(i);


            if (coeff == 0) continue;


            if (coeff > 0 && sb.length() > 0) {
                sb.append("+");
            } else if (coeff < 0) {
                sb.append("-");
            }


            float absCoeff = Math.abs(coeff);


            if (absCoeff != 1.0f || i == 0) {

                if (absCoeff == (int) absCoeff) {
                    sb.append((int) absCoeff);
                } else {
                    sb.append(absCoeff);
                }
            }

            if (i > 0) {
                sb.append("x");
                if (i > 1) {
                    sb.append("^").append(i);
                }
            }
        }

        return sb.toString();
    }
}