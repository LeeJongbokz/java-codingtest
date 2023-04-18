// 1sol
// 1. 왜 맞았는가?
// -> Arrays.sort를 구간으로 할 수 있음을 알아두자. 
// -> 이웃하는 것끼리 비교하는 방법을 알아두자. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Main T = new Main();
      Scanner sc = new Scanner(System.in); 
      
      int N = sc.nextInt(); 
      
      long[] arr = new long[N+10];
      
      for(int i=1; i<=N; i++){
          arr[i] = sc.nextLong(); 
      }
      
      Arrays.sort(arr, 1, N+1);
      long ans = arr[1];
      int cnt = 1; 
      int maxCnt = 1;
      
      for(int i=2; i<=N; i++){
          
          if(arr[i-1] == arr[i]){
              cnt++;
          }else{
              cnt = 1;
          }
          
          if(cnt > maxCnt){
              maxCnt = cnt;
              ans = arr[i];
          }
          
          
          
      }
      
      
      
      System.out.println(ans); 
      
      
      
      
    }
}
