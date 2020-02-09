class LcsNode{
    
    private int x;
    private int y;
    private int value;
    
    public LcsNode(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getValue() { return value; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setValue(int value) { this.value = value; }
}

class Playground {
    public static void main(String[ ] args) {
        int[] a = {10, 9, 20, 33, 24, 1, 30, 40, 50, 60};
        System.out.println(lis(a));
        lcs("ABCD","ACBAD");
    }
    
    /*
        Longest increasing subsequence (O(n^2)), Can be improved with binary search
    */
    public static int lis(int[] arr){
        int[] temp = new int[arr.length];
        
        for(int i = 0; i < temp.length; i++){
            temp[i] = 1;
        }
        
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    temp[i] = Math.max(temp[i], temp[j] + 1);
                }
            }
        }
        int lis = temp[0];
        
        for(int i = 1; i < temp.length; i++){
            if(temp[i] > lis){
                lis = temp[i];
            }
        }
        return lis;
    }

    /*
        Longest common subsequence problem (O(n^2))
    */
     public static void lcs(String a, String b) {
        
        int rows = a.length() + 1, columns = b.length() + 1;
        
        LcsNode[][] result = new LcsNode[rows][columns];
        
        /* Initilizer
            000000
            0
            0
            0
            0
        */
        
        for(int i = 0; i < columns; i++){
            LcsNode lcsNode = new LcsNode(0, i, 0);
            result[0][i] = lcsNode;
        }
        
        for(int i = 0; i < rows; i++){
            LcsNode lcsNode = new LcsNode(i, 0, 0);
            result[i][0] = lcsNode;
        }
        
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < columns; j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    int value = result[i - 1][j - 1].getValue() + 1;
                    LcsNode lcsNode = new LcsNode(i - 1, j - 1, value);
                    result[i][j] = lcsNode;
                }else{
                    LcsNode lcsNode = null;
                    int value1 = result[i - 1][j].getValue();
                    int value2 = result[i][j - 1].getValue();
                    if(value1 > value2){
                        lcsNode = new LcsNode(i - 1, j, value1);
                    }
                    else{
                        lcsNode = new LcsNode(i, j - 1, value2);
                    }
                    result[i][j] = lcsNode;
                }
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(result[i][j] != null)
                    System.out.print(result[i][j].getValue());
            }
            System.out.println("");
        }

        int i = rows - 1, j = columns - 1;

        while(i > 0 && j > 0){
            if(result[i][j].getX() == i - 1 &&  result[i][j].getY() == j - 1){
                System.out.print(b.charAt(j - 1));
            }
            i = result[i][j].getX();
            j = result[i][j].getY();
        }
        
        /* For example: Longest common subsequence("ABCD","ACBAD")
            000000
            011111
            011222
            012222
            012223
        */
    }

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