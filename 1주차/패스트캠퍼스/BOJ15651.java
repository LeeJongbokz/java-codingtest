// 제목: N과 M(3) 

// 3sol
// 어떤 점을 개선했는가?
// 1) 그냥 System.out.println을 하면 시간 초과가 뜬다. 
// 2) 따라서 StringBuilder를 사용해서 값들을 저장하고, 한 번에 출력했다.
// 3) 출력 또한, 매번 나눠서 하는 것이 아니라, 한 번에 출력해야 한다.

// 왜 맞았는가?
// 1) 백트레킹을 적용했다.
// 2) 백트레킹을 적용해서, 완전탐색을 했고, 문제에서 제시한 모든 케이스에 대해서 적용했다.

// 이게 최선의 코드인가?
// -> static 변수를 쓰지 않으면 어떠한가?
// -> static 변수를 쓰지 않을 수도 있지 않은가? 

import java.util.*; 

public class Main {
    
    
    public static StringBuilder sb = new StringBuilder();
    
    public static void recursive(ArrayList<Integer> arr, int N, int M, int cnt){
        
        if(M == cnt){ 
            for(int i=0; i<arr.size(); i++){
                sb.append(arr.get(i)+ " ");
            }
            sb.append('\n');
            return; 
        }
        
        
        
        for(int i=1; i<=N; i++){
            arr.add(i);
            recursive(arr, N, M, cnt+1);
            arr.remove(arr.size()-1);
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
