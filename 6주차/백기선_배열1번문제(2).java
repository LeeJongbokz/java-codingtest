// 시간 복잡도: O(N)
// 공간 복잡도: O(N) 

// 왜 맞았는가?
-> HashSet을 사용해주면 중복을 검사할 수 있다


import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      boolean ans = false; 
      
      int[] arr = {1,2,3,2};
      HashSet<Integer> set = new HashSet<>(); 
      
      for(int i=0; i<arr.length; i++){
            int num = arr[i];
            if(set.contains(num)){
                ans = true;
                break;
            }else{
                set.add(num); 
            }
      }
      
      System.out.println(ans); 
      
      
      
    }
}
