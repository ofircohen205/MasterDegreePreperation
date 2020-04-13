package DynamicProgramming.Solutions;

/**
 * MatrixMult inpit: array of integers represent the matrix dimension such as:
 * Matrix[i] = input[i - 1], input[i] for i > 0
 * Complexity O(n^3)
 */
public class MatrixMult {

    public static int minMatrixMult(int[] dims){

        int[][] temp = new int[dims.length][dims.length]; // init NxN matrix
        
        // L is chain length. 
        for (int p = 2; p < dims.length; p++) 
        { 
            for (int i = 1; i < dims.length - p + 1; i++) 
            { 
                int j = i + p - 1; 
                
                if(j == dims.length){
                    temp[i][j] = 0;
                    continue;  
                }  

                temp[i][j] = Integer.MAX_VALUE; 
                
                for (int k = i; k < j; k++) 
                { 
                    int q = temp[i][k] + temp[k+1][j] + dims[i-1] * dims[k] * dims[j]; 
                    if (q < temp[i][j]) 
                        temp[i][j] = q; 
                } 
            } 
        }
        
        return temp[1][dims.length - 1];
    }
    
}