// 왜 맞았는가?
// 1. 각 단계에서 최적의 선택을 했다.
// 2. 최소 개수를 선택하기 위해서 가장 큰 것부터 선택을 해줬다. 
// 3. 전체 선택된 것들의 합을 더해줬다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in); 
      int N = sc.nextInt();
      
      int remain = 1000-N;
      int[] money = {500, 100, 50, 10, 5, 1};
      int pos = 0;
      int ans = 0; 
      
      while(true){
          
          int cnt = remain / money[pos];
          remain -= cnt*money[pos++];
          ans += cnt;
          if(remain == 0){
              break; 
          }
      }
      
      System.out.println(ans); 
      
      
      
    }
}
