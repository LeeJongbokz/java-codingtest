// 시간 복잡도: O(N)
// 공간 복잡도: O(N)

// 왜 맞았는가?
// -> 이번에는 StringBuffer가 아닌 StringBuilder로 reverse(), toString()을 적용했다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      String str = sc.next();
      StringBuilder sb = new StringBuilder(str);
      String reversed = sb.reverse().toString();
      
      System.out.println(reversed); 
      
    }
}
