// 시간 복잡도: O(nlogn)
// 공간 복잡도: O(logn)

// 왜 맞았는가?
// 1. 퀵소트를 쓸 수 있다
// -> 퀵 소트를 쓰면, 시간 복잡도 O(nlogn), 공간 복잡도 O(logn)에 문제를 해결할 수 있다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      boolean ans = false; 
      
      int[] arr = {1,2,3,4};
      Arrays.sort(arr);
     
      for(int i=0; i<arr.length-1; i++){
          if(arr[i] == arr[i+1]){
              ans = true;
          }
      }
      
      System.out.println(ans); 
      
      
      
    }
}
