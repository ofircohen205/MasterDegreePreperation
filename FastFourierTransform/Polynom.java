package FastFourierTransform;

/*
 This class will represent polynom object.
 The class will include API for: 
 Evaluation 
 Addition Of 2 Polynoms
 Multiplication Of 2 Polynoms
*/
public class Polynom {

    private int[] coeffs;
    private int degree;

    // TODO: Padding with 0 in case of coeffs length smaller the degree
    public Polynom(int[] coeffs, int degree){
        this.coeffs = coeffs;
        this.degree = degree;
    }

    public int[] getCoeffs() {
        return coeffs;
    }

    public void setCoeffs(int[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    // horners rule to evaluate x, complexity (O(n))
    private double hornersRule(double x){
        if(degree == 0 || coeffs.length == 0)
            return 0;

        double result = coeffs[0];
        for(int i = 1; i < degree; i++){
            result = result + x * coeffs[i];
        }

        return result;
    }

    public double evaluation(double x){
        return hornersRule(x);
    }

    public Polynom addition(Polynom p2){
        return null;
    }

    public Polynom multiplication(Polynom p2){
        return null;
    }
}