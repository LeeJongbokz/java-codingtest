// 제목: 연산자 끼워넣기  

// 1sol

// 왜 맞았는가?
// 1) symbols라는 배열을 활용했고, 이를 통해 문제에서 요구하는 조건을 정확하게 구현하였다. 
// 2) 백트레킹 시, 원래의 값으로 복원하는 조건을 정확하게 구현하였습니다.
// 3) minVal과 maxVal이라는 변수를 통해서, 최소값과 최대값을 잘 저장하였습니다. 


import java.util.*; 

public class Main {
    
    
    public static int[] arr;
    public static int[] symbols; 
    public static int minVal = Integer.MAX_VALUE;
    public static int maxVal = Integer.MIN_VALUE; 
    public static int total; 
    
    public static void recursive(int curr, int cnt){
        
        if(cnt == total){
            minVal = Math.min(minVal, curr);
            maxVal = Math.max(maxVal, curr);
            return; 
        }
        
        
        for(int i=0; i<4; i++){
            
            if(symbols[i] != 0){
                
                if(i == 0){
                    curr += arr[cnt+1];         
                }else if(i == 1){
                    curr -= arr[cnt+1];
                }else if(i == 2){
                    curr *= arr[cnt+1];
                }else if(i == 3){
                    curr /= arr[cnt+1];
                }
                
                symbols[i] -= 1;
                recursive(curr, cnt+1);
                symbols[i] += 1;
                
                
                if(i == 0){
                    curr -= arr[cnt+1];         
                }else if(i == 1){
                    curr += arr[cnt+1];
                }else if(i == 2){
                    curr /= arr[cnt+1];
                }else if(i == 3){
                    curr *= arr[cnt+1];
                }
                
            }
            
            
            
        }
        
        
    }
    
    
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in); 
      
      int N = sc.nextInt();
      arr = new int[N];
      symbols = new int[4];
      
      for(int i=0; i<N; i++){
          arr[i] = sc.nextInt();
      }
      
      for(int i=0; i<4; i++){
          symbols[i] = sc.nextInt(); 
          total += symbols[i];  
      }
      
      
      recursive(arr[0], 0);
      
      System.out.println(maxVal);
      System.out.println(minVal);
      
      
    }
}
