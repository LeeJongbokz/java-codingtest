// 시간 복잡도: O(N)
// 공간 복잡도: O(N)

// 왜 맞았는가?
// 1. 새로운 char 배열을 선언하고, 거기에 뒤집어서 넣어줄 수 있다. 

import java.util.*; 

public class Main {
     
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      String str = sc.nextLine();
      char[] arr = str.toCharArray();
      char[] reversed = new char[arr.length];
      
      for(int i=arr.length-1; i>=0; i--){
              reversed[arr.length-i-1] = arr[i];  
      }
      
      for(int i=0; i<reversed.length; i++){
            System.out.print(reversed[i]+ " "); 
      }
      
    }
}
