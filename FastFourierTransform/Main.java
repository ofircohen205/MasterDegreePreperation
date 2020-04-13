package FastFourierTransform;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        double[] coeffs = {1, 2, -3, 4};
        double[] coeffs2 = {12, 22};
        Polynom p1 = new Polynom(coeffs);
        Polynom p2 = new Polynom(coeffs2);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.getDegree());
    }
}