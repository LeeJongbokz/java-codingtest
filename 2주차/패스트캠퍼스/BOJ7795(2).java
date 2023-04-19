// 1sol

// 왜 맞았는가?
// 1) ans의 기본값을 start-1로 세팅한다
// 2) arr[mid]<num일때마다, 값을 업데이트하고, start의 위치를 옮겨준다
// 3) arr[mid]>=num일때는, end의 위치를 옮겨준다. 
// 4) ans의 값을 리턴한다. 

import java.util.*; 

public class Main {
    
    
    public static int binarySearch(int num, int[] arr, int M){
        
        int start = 1;
        int end = M; 
        int ans = start-1; 
        
        while(start <= end){
            int mid = (start+end)/2;
            
            if(arr[mid] < num){
                ans = mid;
                start = mid+1;  
            }else if(arr[mid] >= num){
                end = mid-1;
            }
        }
        
        return ans; 
        
        
    }
    
    
    public static void main(String args[]) {
      
      Main K = new Main();
      Scanner sc = new Scanner(System.in);
      
      int T = sc.nextInt();
      
      
      for(int i=1; i<=T; i++){
          
          int res = 0; 
          
          int N = sc.nextInt();
          int M = sc.nextInt();
          
          int[] arrA = new int[N+10];
          int[] arrB = new int[M+10];
          
          for(int j=1; j<=N; j++){
              arrA[j] = sc.nextInt();
          }
          
          for(int j=1; j<=M; j++){
              arrB[j] = sc.nextInt(); 
          }
          
          
          Arrays.sort(arrA, 1, N+1);
          Arrays.sort(arrB, 1, M+1);
          
          for(int j=1; j<=N; j++){
              int num = arrA[j];
              int cnt = binarySearch(num, arrB, M);
              res += cnt;
          }
            
            
          System.out.println(res);      
                  
      }
          
      
    }
}
