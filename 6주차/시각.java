// 왜 맞았는가?
// 1. 문제의 조건에 유의해서 3중 for문을 작성했다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int ans = 0; 
      
      for(int i=0; i<=N; i++){
          for(int j=0; j<=59; j++){
              for(int k=0; k<=59; k++){
                String tmp = Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
                for(int l=0; l<tmp.length(); l++){
                    if(tmp.charAt(l) == '3'){
                        ans++;
                        break;
                    }
                }
                
              }
          }
      }
          
      System.out.println(ans);       
    }
      
     
}
