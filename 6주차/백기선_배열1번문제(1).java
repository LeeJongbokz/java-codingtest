// 시간 복잡도: O(N)
// 공간 복잡도: O(N)

// 왜 맞았는가?
// 1. check 배열을 통해서 한 번 발생한 것에 대해서 검사했다.
// 2. check 배열을 통해서 중복을 확인했다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      boolean ans = false; 
      
      int[] arr = {1,2,3,2};
      int max = Integer.MIN_VALUE;
     
      for(int i=0; i<arr.length; i++){
          max = Math.max(max, arr[i]);
      }
      
      boolean[] check = new boolean[max+1];
      
      for(int i=0; i<arr.length; i++){
            int num = arr[i];
            if(check[num] == false){
                check[num] = true;
            }else{
                ans = true;
                break; 
            }
      }
      
      System.out.println(ans); 
      
      
      
    }
}
