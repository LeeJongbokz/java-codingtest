// 제목: N과 M(1) 

// 1sol

// 왜 맞았는가?
// 1) 백트레킹을 적용했다.
// 2) 중복된 것을 제거하기 위해서, boolean check 배열을 적용했다.
// 3) boolean check 배열을 true, false로 바꾸면서, 중복 검사를 진행했다. 

import java.util.*; 

public class Main {
    
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] check = new boolean[10];
    
    public static void recursive(ArrayList<Integer> arr, int N, int M, int cnt){
        
        if(M == cnt){ 
            for(int i=0; i<arr.size(); i++){
                sb.append(arr.get(i)+ " ");
            }
            sb.append('\n');
            return; 
        }
        
        
        
        for(int i=1; i<=N; i++){
            if(check[i] == false){
                check[i] = true;
                arr.add(i);
                recursive(arr, N, M, cnt+1);
                check[i] = false; 
                arr.remove(arr.size()-1);
            }
        }    
    }
    
    
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int M = sc.nextInt();
      
      Main T = new Main();
      int cnt = 0;
      ArrayList<Integer> arr = new ArrayList<>(); 
      
      T.recursive(arr, N, M, cnt);
      
      System.out.println(sb);
      
    }
}
