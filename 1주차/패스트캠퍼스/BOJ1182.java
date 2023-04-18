// 제목: 부분수열의 합 

// 왜 맞았는가?
// 1. 이 문제는 부분수열을 구하는 문제이다.
// -> 이 때, 연속된 부분수열이 아님을 주의해야 한다. 
// -> 숫자들이 연속적으로 선택될 필요는 없다 
// 2. 이 문제의 중요 포인트 중 하나는 S가 0일 때이다.
// -> S가 0일 때는, 전체 모두가 선택되지 않아서 0인 경우가 있는데, 이 경우는 부분 수열이 아니므로
// -> 1을 빼주는 것이 필요하다. 

import java.util.*; 

public class Main {
    
    public static int N;
    public static int S;
    public static int[] arr;
    public static int ans; 
    
    public static void recursive(int sum, int pos){
        
        if(pos == N){
            
            if(sum == S){
                ans++;
            }
            
            return; 
            
        }
        
        
        recursive(sum+arr[pos], pos+1);
        recursive(sum, pos+1);
        
        
        
        
    }
    
    public static void main(String args[]) {
      
      Main T = new Main();
      arr = new int[30];
      
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      S = sc.nextInt();
      ans = 0; 
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          arr[i] = num;
      }
      
      int sum = 0; 
      int pos = 0;
      
      recursive(0, 0);
     
      if(S == 0){
          ans--;
      }
      
     
      System.out.println(ans);
      
       
      
    }
}
