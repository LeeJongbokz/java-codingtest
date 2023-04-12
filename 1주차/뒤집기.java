// 1sol
// 18분
// 이 문제 같은 경우는, 문제의 조건에 따라 0과 1이 연속하는 케이스를 각각 구하고
// 그 중에서 더 적은 케이스를 답으로 구하면 되는 문제였습니다.
// 더 적은 케이스를 답으로 하는 것이 가능한 이유는
// 둘 중에 더 적은 쪽을 뒤집어주면 같은 수로 만들 수 있기 때문입니다.

// 왜 맞았는가?
// 1. 문제의 조건을 잘 이해하고, 알맞은 아이디어를 도출할 수 있었다.
// 2. 아이디어를 적절한 코드로 변환하고, 테스트 케이스로 이에 대한 테스트를 수행했다. 



import java.util.*; 

public class Main {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      int zero = 0;
      int one = 0; 
      
      String str = sc.next(); 
      
      int curr = str.charAt(0)-'0';
      
      for(int i=1; i<str.length(); i++){
          
          int num = str.charAt(i)-'0';
          
          if(curr == num){
              continue;
          }else{
              if(curr == 0){
                  zero++;
                  curr = 1;
              }else{
                  one++;
                  curr = 0; 
              }
          }
      }
      
      if(curr == 0){
          zero++;
      }else{
          one++; 
      }
      
      int answer = Math.min(zero, one);
      
      System.out.println(answer);
      
      
    }
}
