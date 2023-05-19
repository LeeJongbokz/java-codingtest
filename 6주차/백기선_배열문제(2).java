// 시간 복잡도: 
// 공간 복잡도: 

// 왜 맞았는가?
// -> StringBuffer에서 제공하는 reverse() 메소드와 toString() 메소드를 통해 문자열을 뒤집어주었다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      String str = sc.next();
      StringBuffer sb = new StringBuffer(str);
      String reversed = sb.reverse().toString();
      
      System.out.println(reversed); 
      
    }
}
