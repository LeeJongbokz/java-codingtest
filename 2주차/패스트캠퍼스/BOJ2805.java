// 3sol

// 왜 맞았는가?
// 1) 이분 탐색의 의미를 잘 활용했다
// 2) 이분 탐색의 식을 잘 세웠다. 

// 질문이 무엇인가?
// -> 처음에 start와 end를 설정하는 것에 대해서 질문을 해볼 필요가 있다. 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*; 

public class Main {
    
    
    public static int N;
    public static long M; 
    public static long ans; 
    
    public static void binarySearch(long[] arr, long start, long end){
        
        while(start <= end){
            
            long mid = (start + end) / 2;
            
            long sum = 0; 
            
            for(int i=1; i<=N; i++){
                
                if(arr[i] >= mid){
                    sum += (arr[i]-mid); 
                }
            }
            
            if(sum >= M){
                    ans = mid;
                    start = mid+1;  
            }else{
                    end = mid-1; 
            }
            
            
            
        }
        
        
        
        
        
        
        
    }
    
    
    public static void main(String args[]) throws NumberFormatException, IOException{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      long[] arr = new long[N+10];
      
      st = new StringTokenizer(br.readLine());
      
      for(int i=1; i<=N; i++){
          arr[i] = Long.parseLong(st.nextToken());
      }
      
      Arrays.sort(arr, 1, N+1);
      
      ans = 0; 
      
      long start = 0;
      long end = arr[N];
      
      
      binarySearch(arr, start, end);
            
          
      System.out.println(ans);
      
      
      
      

    }
}
