// 왜 맞았는가?
// 1. 문제의 조건에 유의해서, 해당 케이스들을 모두 검사할 수 있게 해줬다. 

import java.util.*; 

public class Main {
    
    
    
    public static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    
    
    
    public static boolean isInside(int x, int y){
        if(1<=x && x<=8 && 1<=y && y<=8){
            return true;
        }else{
            return false; 
        }
    }
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      String str = sc.next();
      int x = 0;
      int y = 0;
      int ans = 0; 
      
      x = str.charAt(1)-'0';
      y = str.charAt(0)-96;
      
      
      for(int i=0; i<8; i++){
          int nx = x + dx[i];
          int ny = y + dy[i];
          
          
          if(isInside(nx, ny)){
              ans++; 
          }
      }
      
      System.out.println(ans); 
      
    }
      
     
}
