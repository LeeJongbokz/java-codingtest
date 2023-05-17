// 왜 맞았는가?
// 1. arr배열에 값을 넣어주고, 2중 for문을 돌면서, 가능한 케이스들을 탐색해줬다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int M = sc.nextInt();
      int ans = 0; 
      int[] arr = new int[N+1];
      
      for(int i=1; i<=N; i++){
          arr[i] = sc.nextInt();
      }
      
      
      for(int i=1; i<=N-1; i++){
          for(int j=i+1; j<=N; j++){
              if(arr[i] != arr[j]){
                  ans++;
              }
          }
      }
      
      System.out.println(ans); 
      
      
    }
}
