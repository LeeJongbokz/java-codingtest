// 왜 맞았는가?
// 1. 바로 행을 돌때마다, 최대값을 찾아주면, 굳이 ArrayList를 쓸 필요가 없다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int M = sc.nextInt();
      
      int[][] arr = new int[N+10][M+10];
      int ans = Integer.MIN_VALUE; 
      
      for(int i=1; i<=N; i++){
          for(int j=1; j<=M; j++){
              arr[i][j] = sc.nextInt(); 
          }
      }
      
      for(int i=1; i<=N; i++){
          int minNum = Integer.MAX_VALUE;
          
          for(int j=1; j<=M; j++){
            if(arr[i][j] <= minNum){
                minNum = arr[i][j];
            }    
          }
          
          ans = Math.max(ans, minNum);
      }
      
      
      System.out.println(ans);
      
      
      
      
      
    }
}
