// 왜 맞았는가?
// 1. 문제를 잘 읽어야 한다
// 2. 몇 명의 모험가는 마을에 그대로 남아 있어도 된다.
// -> 즉, 모든 모험가가 선택될 필요가 없다
// -> 또한, 이러한 조건 하에서 선택할 수 있는 모험가 그룹을 최대화해야 한다.
// -> 최대화하기 위해서는 작은 수부터 선택해주는 것이 바람직하므로,
// -> 오름차순 정렬을 해야 한다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      ArrayList<Integer> arr = new ArrayList<>(); 
      int ans = 0; 
      
      
      for(int i=1; i<=N; i++){
          int num = sc.nextInt();
          arr.add(num);
      }
      
      Collections.sort(arr);
      int count = 0; 
      
      for(int i=0; i<arr.size(); i++){
          count++; 
          int num = arr.get(i);
          if(count == num){
              ans++;
              count = 0; 
          }
      }
      
      System.out.println(ans);
        
      
    }
}
