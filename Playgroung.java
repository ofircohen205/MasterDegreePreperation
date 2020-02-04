class LcsNode{
    
    private double x;
    private double y;
    private int value;
    
    public LcsNode(double x, double y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public int getValue() { return value; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setValue(int value) { this.value = value; }
}

class Playground {
    public static void main(String[ ] args) {
        int[] a = {10, 9, 20, 33, 24, 1, 30, 40, 50, 60};
        System.out.println(lis(a));
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
        
        int row = a.length() + 1, columns = b.length() + 1;
        
        LcsNode[][] result = new LcsNode[row][columns];
        
        /* Initilizer
            00000
            0
            0
            0
        */
        
        for(int i = 0; i < result[0].length; i++){
            LcsNode lcsNode = new LcsNode(0, i, 0);
            result[0][i] = lcsNode;
        }
        
        for(int i = 0; i < result.length; i++){
            LcsNode lcsNode = new LcsNode(i, 0, 0);
            result[i][0] = lcsNode;
        }
        
        for(int i = 1; i < a.length(); i++){
            for(int j = 1; j < b.length(); j++){
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
        
        for(int i = 0; i < a.length(); i++){
            for(int j = 0; j < b.length(); j++){
                if(result[i][j] != null)
                    System.out.print(result[i][j].getValue());
            }
            System.out.println("");
        }
        
        /* For example: Longest common subsequence("ABCD","ACBAD")
            00000
            01111
            01122
            01222
        */
    }
}