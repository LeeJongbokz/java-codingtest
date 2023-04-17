import java.util.*; 

public class Main {
    
    public static int N;
    public static int S;
    public static int[] arr;
    public static int ans; 
    
    public static void recursive(int sum, int pos){
        
        if(pos == N){
            
            if(sum == S){
                ans++;
            }
            
            return; 
            
        }
        
        
        recursive(sum+arr[pos], pos+1);
        recursive(sum, pos+1);
        
        
        
        
    }
    
    public static void main(String args[]) {
      
      Main T = new Main();
      arr = new int[30];
      
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      S = sc.nextInt();
      ans = 0; 
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          arr[i] = num;
      }
      
      int sum = 0; 
      int pos = 0;
      
      recursive(0, 0);
     
      if(S == 0){
          ans--;
      }
      
     
      System.out.println(ans);
      
       
      
    }
}
