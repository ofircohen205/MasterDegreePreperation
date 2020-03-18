package Exponential;

/**
 * FindPrimes 
 * This algorithm finds the prime dividers of number n.
 * However the runtime of this problem is O(2^n) Explain:
 * Express a number k in binary form. The number of bits required to express k in this way is ⌈log2(k)⌉.
 * In the opposite direction, using n bits, you can express numbers from 0 to 2^n−1. Thus the maximum magnitude of an n bit number is O(2^n).
 */
public class FindPrimes {

    public static boolean isPrime(int n){
        for(int i = 2; i < n/2; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static void primeDividers(int n){
        int i = 2;
        while(n > 0 && !isPrime(n)){
            
            if(n % i == 0 && isPrime(i)){
                System.out.print(i + ", ");
                n = n/i;
                i = 2;
                continue;
            }
            i++;
        }
        
        if(n != 0){
           System.out.print(n); 
        }
    }
}