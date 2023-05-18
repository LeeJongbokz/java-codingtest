// 왜 맞았는가?
// 1. int 값을 str으로 바꿔주었다.
// 2. str의 len을 통해서, 양쪽 값을 구해주었다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      
      String str = Integer.toString(N);
      int len = str.length();
      int left = 0;
      int right = 0; 
      
      for(int i=0; i<(len/2); i++){
          left += str.charAt(i)-'0';
      }
      
      for(int i=len/2; i<len; i++){
          right += str.charAt(i)-'0';
      }
      
      if(left == right){
          System.out.println("LUCKY");
      }else{
          System.out.println("READY");
      }
      
    }
}
