package FastFourierTransform;

/*
 This class will represent polynom object.
 The class will include API for: 
 Evaluation 
 Addition Of 2 Polynoms
 Multiplication Of 2 Polynoms
*/
public class Polynom {

    private double[] coeffs;
    private int degree;

    // TODO: Padding with 0 in case of coeffs length smaller the degree
    public Polynom(double[] coeffs, int degree){
        this.coeffs = coeffs;
        this.degree = degree;
    }

    public double[] getCoeffs() {
        return coeffs;
    }

    public void setCoeffs(double[] coeffs) {
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

        int degree = Math.max(this.degree, p2.getDegree());
        double[] coeffs = new double[degree];

        int i = 0, j = 0, k = 0;
        while(i < this.degree && j < p2.getDegree()){
            coeffs[k++] = this.coeffs[i++] + p2.getCoeffs()[j++];
        }

        while(i < this.degree){
            coeffs[k++] = this.coeffs[i++];
        }

        while(j < p2.getDegree()){
            coeffs[k++] = p2.getCoeffs()[j++];
        }

        return new Polynom(coeffs, degree);
    }

    public Polynom multiplication(Polynom p2){
        return null;
    }
}