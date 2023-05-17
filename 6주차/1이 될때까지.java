// 왜 맞았는가?
// 1. 항상 나누는 경우가 빼는 경우보다 낫다는 점을 잘 상기해야 한다
// 2. 그 점을 잘 기억하면 식을 잘 세울 수 있다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int K = sc.nextInt();
      
      int curr = N; 
      int ans = 0; 
      
      while(true){
          
          if(curr == 1){
              break; 
          }
          
          if(curr % K == 0){
             curr /= K;   
          }else{
             curr--;
          }

          ans++;
      }
      
      
      System.out.println(ans);       
      
      
      
      
    }
}
