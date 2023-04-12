class Solution {
   
    public boolean isSame(int[][] arr, int rs, int re, int cs, int ce){
        
        if( re - rs == 1 && ce-cs == 1){
            return true;
        }
        
        int num = arr[rs][cs];
        
        for(int i=rs; i<re; i++){
            for(int j=cs; j<ce; j++){
                if(num != arr[i][j]){
                    return false;
                }
            }
        }
        
        
        return true; 
        
    }
    
    
    public String divide(int[][] arr, int rs, int re, int cs, int ce){
        
        boolean result = isSame(arr, rs, re, cs, ce);
        
        if(result){
            return Integer.toString(arr[rs][cs]); 
        }
        
        int half = (re-rs)/2; 
        
        return divide(arr, rs, rs+half, cs, cs+half)+ divide(arr, rs, rs+half, cs+half, ce)+divide(arr, rs+half, re, cs, cs+half)+divide(arr, rs+half, re, cs+half, ce);
        
    }
    
    
    public int[] solution(int[][] arr) {
        
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0; 
        
        int row = arr.length;
        int col = arr[0].length;
        
        String str = divide(arr, 0, row, 0, col);
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            
            if(c == '1'){
                answer[1] += 1;
            }else if(c == '0'){
                answer[0] += 1;
            }
        }
        
        
        return answer;
    }
}
