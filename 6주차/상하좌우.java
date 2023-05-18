// 왜 맞았는가?
// 1. 문제의 조건에 유의해서 조건을 잘 적용해주었다. 

import java.util.*; 

public class Main {
    
    public static int N; 
    
    public static boolean isInside(int x, int y){
        if(1<=x && x<=N && 1<=y && y<=N){
            return true;
        }else{
            return false; 
        }
    }
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int x = 1;
      int y = 1; 
      N = sc.nextInt();
      
      String str = sc.next();
      
      for(int i=0; i<str.length(); i++){
          
         int nx = 0;
         int ny = 0; 
         if(str.charAt(i) == 'L'){
             nx = x;
             ny = y-1;
         }else if(str.charAt(i) == 'R'){
             nx = x;
             ny = y+1;
         }else if(str.charAt(i) == 'U'){
             nx = x-1;
             ny = y;
         }else if(str.charAt(i) == 'D'){
             nx = x+1;
             ny = y; 
         }
         
         if(isInside(nx, ny)){
             x = nx;
             y = ny;
         }else{
             continue;
         }    
      }
      
      System.out.println(x + " " + y);
      
      
    }
}
