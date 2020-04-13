package FastFourierTransform;

/*
 FFT to calculate DFT of polynom A
 We want to achive the following operation in O(nlogn) time
 Evaluation 
 Addition
 Multiplication

 Polynom can be represented by his: coeffs, roots, samples, here we will focus on
 coeffs and samples representation.
 with FFT, polynom that represented with his coeffs can be converted to samples representation and vice versa in O(nlogn)

*/
public class FastFourierTransform {

    // create unity cycle -> xK e^(ijk2*pi)/n
    // create the complex conjugate of xK e^(-ijk2*pi)/n
    private double tau = Math.PI * 2;

    // FFT O(nlogn)
    public static double[] FFT(){
        return null;
    }

    // Inverse FFT O(nlogn)
    public static double[] IFFT(){
        return null;
    }
}