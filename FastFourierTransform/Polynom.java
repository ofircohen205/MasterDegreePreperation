package FastFourierTransform;

import FastFourierTransform.Utils.Complex;

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

    public Polynom(double[] coeffs){
        
        if(coeffs == null || coeffs.length == 0) {
            this.coeffs = new double[0];
            this.degree = 0;
            return;
         }

        this.coeffs = coeffs;
        this.degree = coeffs.length;
    }

    public double[] getCoeffs() {
        return coeffs;
    }

    public void setCoeffs(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return degree > 0 ? degree - 1 : 0;
    }

    // horners rule to evaluate x, complexity (O(n))
    private double hornersRule(double x){
        
        double result = 0;
        
        for(int i = degree - 1; i >= 0; i--){
            result = coeffs[i] + x * result;
        }

        return result;
    }

    public double evaluation(double x){
        return hornersRule(x);
    }

    // adding the 2 vectors of coeffs, complexity (O(n))
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

        return new Polynom(coeffs);
    }

    // using FFT we can multiply 2 polynoms in O(nlogn)
    public Polynom multiplication(Polynom p2){

        // convert this to samples vector FFT(this.coeff)
        // convert p2 to samplse vector   FFT(p2.coeff)
        // multiple them in O(n)          
        // convert result vector to coeff vector INVERSE_FFT(result_vector)

        Complex[] p1Samples = FastFourierTransform.FFT(this.coeffs);
        Complex[] p2Samples = FastFourierTransform.FFT(p2.getCoeffs());

        int degree = p1Samples.length + p2Samples.length - 1;
        Complex[] resultSamples = new Complex[degree];

        int i = 0, j = 0, k = 0;
        while(i < this.degree && j < p2.getDegree()){
            resultSamples[k++] = p1Samples[i++].times(p2Samples[j++]);
        }

        return new Polynom(FastFourierTransform.IFFT(resultSamples));
    }

    @Override
    public String toString(){
        StringBuilder poly = new StringBuilder().append("f(x) = " + this.coeffs[0]);
        for(int i = 1; i < this.degree; i++){
            String term = this.coeffs[i] > 0 ? " + " + this.coeffs[i] + "x^" + i : " " + this.coeffs[i] + "x^" + i;
            poly.append(term);
        }
        return poly.toString();
    }
}