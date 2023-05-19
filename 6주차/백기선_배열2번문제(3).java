// 시간 복잡도: O(N)
// 공간 복잡도: O(N)

// 왜 맞았는가?
// 1. toCharArray를 통해서 String을 char배열로 바꿔줬다. 
// 2. swap을 구현해서, 맨 앞과 맨 뒤를 변경해주었다.
// 3. 이 때, swap 메소드에는 배열과, 시작 위치, 끝 위치, 3개의 변수를 같이 전달해주어야 한다. 
// -> 그래야만, 값이 제대로 바뀔 수 있다. 

import java.util.*; 

public class Main {
    
    
    public static void swap(char[] arr, int start, int end){
        
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      String str = sc.nextLine();
      char[] arr = str.toCharArray();
      
      int start = 0;
      int end = arr.length-1;
      
      while(start < end){
          swap(arr, start, end);
          start++;
          end--;
      }
      
      for(int i=0; i<arr.length; i++){
          System.out.print(arr[i]+ " ");
      }
      
      
      
      
    }
}
