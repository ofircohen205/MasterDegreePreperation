package FastFourierTransform;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        double[] coeffs = new double[4];
        
        for(int i = 0; i < 4; i++){
            coeffs[i] = i + 1;
        }

        Polynom p1 = new Polynom(coeffs);
        System.out.println(p1);
        
    }
}