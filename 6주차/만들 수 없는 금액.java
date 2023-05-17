// 왜 맞았는가?
// -> 다시 한번 풀어보면 좋을 것 같다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int[] arr = new int[N+10];
      
      for(int i=1; i<=N; i++){
          arr[i] = sc.nextInt();
      }
      
      Arrays.sort(arr, 1, N+1);
      int target = 1;
      
      for(int i=1; i<=N; i++){
          if(target < arr[i]){
              break; 
          }
          
          target += arr[i];
      }
      
      System.out.println(target); 
      
      
    }
}
