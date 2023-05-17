// 왜 맞았는가?
// 1. N, M을 입력 받는다
// 2. 각 행을 돌면서 minNum들을 ArrayList에 넣어준다.
// 3. ArrayList를 내림차순 정렬을 한다.
// 4. 그 값을 추출해준다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int M = sc.nextInt();
      
      int[][] arr = new int[N+10][M+10];
      ArrayList<Integer> minNumbers = new ArrayList<>(); 
      
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
          
          minNumbers.add(minNum);
      }
      
      Collections.sort(minNumbers, Collections.reverseOrder());
      
      System.out.println(minNumbers.get(0));
      
      
      
      
      
    }
}
