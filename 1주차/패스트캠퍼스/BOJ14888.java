import java.util.*; 

public class Main {
    
    
    public static int[] arr;
    public static int[] symbols; 
    public static int minVal = Integer.MAX_VALUE;
    public static int maxVal = Integer.MIN_VALUE; 
    public static int total; 
    
    public static void recursive(int curr, int cnt){
        
        if(cnt == total){
            minVal = Math.min(minVal, curr);
            maxVal = Math.max(maxVal, curr);
            return; 
        }
        
        
        for(int i=0; i<4; i++){
            
            if(symbols[i] != 0){
                
                if(i == 0){
                    curr += arr[cnt+1];         
                }else if(i == 1){
                    curr -= arr[cnt+1];
                }else if(i == 2){
                    curr *= arr[cnt+1];
                }else if(i == 3){
                    curr /= arr[cnt+1];
                }
                
                symbols[i] -= 1;
                recursive(curr, cnt+1);
                symbols[i] += 1;
                
                
                if(i == 0){
                    curr -= arr[cnt+1];         
                }else if(i == 1){
                    curr += arr[cnt+1];
                }else if(i == 2){
                    curr /= arr[cnt+1];
                }else if(i == 3){
                    curr *= arr[cnt+1];
                }
                
            }
            
            
            
        }
        
        
    }
    
    
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in); 
      
      int N = sc.nextInt();
      arr = new int[N];
      symbols = new int[4];
      
      for(int i=0; i<N; i++){
          arr[i] = sc.nextInt();
      }
      
      for(int i=0; i<4; i++){
          symbols[i] = sc.nextInt(); 
          total += symbols[i];  
      }
      
      
      recursive(arr[0], 0);
      
      System.out.println(maxVal);
      System.out.println(minVal);
      
      
    }
}
