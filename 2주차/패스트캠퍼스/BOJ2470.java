// 2sol

// 1. 왜 맞았는가?
// -> 투 포인터를 사용해서 푸는 것이 가능한 문제이다.
// -> 이분 탐색을 사용하는 것보다 투 포인터를 사용하는 것이 훨씬 효과적입니다.
// -> 다만, BufferedReader를 사용해야 시간 초과를 줄일 수 있습니다.
// -> BufferedReader를 사용하는 것을 습관화해야 할 것 같습니다. 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
      
      Arrays.sort(arr, 1, N+1);
      
      
      int start = 1;
      int end = N;
      int ans = Integer.MAX_VALUE; 
      int ans1 = 0;
      int ans2 = 0; 
      
      while(start < end){
          
          int sum = arr[start]+arr[end];
          
          if(ans > Math.abs(sum)){
              ans = Math.abs(sum);
              ans1 = arr[start];
              ans2 = arr[end];
          }
          
          if(sum > 0){
              end--;
          }else{
              start++; 
          }
          
          
          
      }
      
      
      System.out.println(ans1 + " " + ans2);
      
      
      
    }
}
