import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int S = sc.nextInt(); 
      int[] arr = new int[N+10];
      int ans = Integer.MAX_VALUE; 
      
      for(int i=1; i<=N; i++){
          int num = sc.nextInt();
          arr[i] = num;  
      }
      
      int sum = arr[1];
      int len = 1; 
      int start = 1;
      int end = 1; 
      
      while(true){
          
          if( start < end  || start >= N+1){
              break;
          }
          
          if(sum >= S){
              if(ans > len){
                  ans = len;
              }
              sum -= arr[end];
              end++; 
              len--;
          }else{
              
              start++;
              sum += arr[start];
              len++;
          }
          
      }
      
      if(ans == Integer.MAX_VALUE){
          ans = 0; 
      }
      
      System.out.println(ans);
      
      
      
      
      
    }
}
