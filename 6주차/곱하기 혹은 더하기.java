// 왜 맞았는가?
// 1. Greedy한 케이스를 잘 이해하고, 접근했다.
// -> 두 개의 변수를 이용해서 값을 구하고, 그 중에 큰 값을 넣는 식으로 계산했다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      String str = sc.next(); 
      int ans = 0; 
      
      for(int i=0; i<str.length(); i++){
          
          int num = str.charAt(i)-'0';
          
          if(i == 0){
              ans = num;
          }else{
              
              int mulAns = ans*num;
              int plusAns = ans+num;
              ans = Math.max(mulAns, plusAns);
          }
      }
      
      System.out.println(ans); 
      
      
        
      
    }
}
