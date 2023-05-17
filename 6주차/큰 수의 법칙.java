// 왜 맞았는가?
// 1. 내림차순으로 정렬을 해줘야 한다
// 2. K번 연속으로 제일 큰 수를 선택하면, 그 다음 1번만 두 번째 큰 수를 선택한다
// 3. 그 다음에 다시 K번 연속으로 제일 큰 수를 선택하는 식으로 접근한다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int M = sc.nextInt();
      int K = sc.nextInt();
      
      ArrayList<Integer> arr = new ArrayList<>();
      
      for(int i=1; i<=N; i++){
          int num = sc.nextInt();
          arr.add(num);
      }
      
      Collections.sort(arr, Collections.reverseOrder());
      
      int sum = 0; 
      
      for(int i=1; i<=M; i++){
          
          if(i % (K+1) != 0){
            sum += arr.get(0);
          }else{
            sum += arr.get(1);
          }
      }
      
      System.out.println(sum); 
      
      
    }
}
