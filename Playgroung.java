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
}