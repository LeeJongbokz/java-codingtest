import java.util.*; 


public class Main {
    
    public static int start;
    public static int end; 
    public static int ans; 

    
    public static void main(String args[]) {
    
      Scanner sc = new Scanner(System.in);
      
      start = sc.nextInt();
      end = sc.nextInt(); 
      long ans = 0; 
      long N = 0;
      long sub = end-start; 
      
      if(start == end){
          System.out.println(0);
          return; 
      }
      
      
      while(N*N <= sub){
          N++;
      }
      
      N--;
      sub -= (N*N);
      ans += (2*N-1);
      
      
      while(sub > 0){
          
          for(long i=N; i>=1; i--){
              if(i<=sub){
                  sub -=i;
                  ans +=1;
                  break;
              }else{
                  continue;
              }
          }
      }
      
      
      
      System.out.println(ans); 
      
      
      
    
    
    }
}
