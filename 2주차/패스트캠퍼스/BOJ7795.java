// 2sol

// 1.왜 맞았는가?
// 1) 다양한 케이스를 고려해야 한다
// -> 특히, arrB에 같은 값이 여러 개 있는 케이스를 고려해야 한다
// -> 그리고 케이스에 따라서 다르게 값을 반환해야 한다. 
// -> 어떻게 반환하는가? 

import java.util.*; 

public class Main {
    
    
    public static int binarySearch(int num, int[] arr, int M){
        
        int start = 1;
        int end = M; 
        int ans = 0; 
        
        while(start <= end){
            int mid = (start+end)/2;
            
            if(arr[mid] == num){
                ans = mid;
                end = mid-1; 
            }else if(arr[mid] < num){
                start = mid+1;
            }else if(arr[mid] > num){
                end = mid-1;
            }
        }
        
        if(ans != 0){
            return ans-1;
        }else{
            return end;
        }
        
        
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
