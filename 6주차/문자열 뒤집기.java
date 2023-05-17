// 왜 맞았는가?
// 1. 처음에 s.charAt(1) == '1'이라는 실수를 했다.
// -> 이러한 부분에 주의해야 한다. 하나의 디테일한 실수도 용납되어서는 안된다.
// -> 문제의 아이디어에 잘 착안해야 한다.
// -> 0과 1을 그룹으로 나누고, 그 중에서 적은 그룹을 뒤집어 주면 된다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      
      int zeroCnt = 0;
      int oneCnt = 0;
      int curr = 0; 
      
      if(s.charAt(0) == '0'){
          zeroCnt++;
      }else if(s.charAt(0) == '1'){
          curr = 1; 
          oneCnt++; 
      }
      
      for(int i=1; i<s.length(); i++){
          
          int num = s.charAt(i)-'0';
          
          if(curr == num){
              continue;
          }else{
              if(curr == 0){
                  curr = 1;
                  oneCnt++;
              }else{
                  curr = 0;
                  zeroCnt++;
              }
          }
          
      }
      
      int minCnt = Math.min(zeroCnt, oneCnt);
      
      System.out.println(minCnt); 
        
      
    }
}
