// 2sol
// 50분
// 한 번 틀리고 나서, 문제점을 발견한 이후에, 문제점을 발견해서 
// 수정한 이후에 통과했습니다.
// 다만, 시간과 메모리가 매우 크게 들어서 비효율적인 코드라는 생각이 들었고
// (메모리	336712MB, 시간 2936ms) 
// 어떻게 더 효율적으로 작성할 수 있는지에 대해 고민해봐야할 것 같습니다.  

// 왜 맞았는가?
// 1) 우선은 문제에 주어진 조건을 이해하고, HashMap으로 데이터를 관리해야겠다고 생각했습니다.
// 2) HashMap으로 Two Pointer 알고리즘으로, 새로운 데이터를 하나 추가하고, 마지막 데이터를 제거하는 식으로
//    해야겠다고 생각했습니다.
// 3) 이 때, 처음에 했을 때는 틀렸다는 결과가 나왔습니다. 
//    이는 초밥이 원형임을 고려하지 않은 결과였습니다. 
//    초밥이 원형임을 고려할 때, N개만 배열에 넣어놓는 것이 아니라, k개를 추가적으로 넣고, 
//    투 포인터를 돌리는 것이 필요했습니다. 
// 4) 해당 로직을 적용해서 문제를 해결할 수 있었습니다. 
// + HashMap의 getOrDefault 메소드, remove 메소드 등을 잘 활용해야겠다고 생각했습니다.     

import java.util.*; 

public class Main {
    
    
    
    public static void main(String args[]) {
        
      Scanner sc = new Scanner(System.in);    
      
      int maxType = Integer.MIN_VALUE; 
      
      HashMap<Integer, Integer> info = new HashMap<>();
      
      int N = sc.nextInt();
      int d = sc.nextInt();
      int k = sc.nextInt();
      int c = sc.nextInt();
      
      int[] dishes = new int[3003010];
      info.put(c, info.getOrDefault(c, 0) + 1);
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          dishes[i] = num;
      }
      
      for(int i=N; i<N+k; i++){
          dishes[i] = dishes[i-N];
      }
      
      for(int i=0; i<k; i++){
          int num = dishes[i];
          info.put(num, info.getOrDefault(num, 0) + 1); 
      }
      
      
      maxType = Math.max(maxType, info.size());
         
      
      for(int i=k; i<N+k; i++){
          int newDish = dishes[i];
          int removedDish = dishes[i-k];
          
          info.put(newDish, info.getOrDefault(newDish, 0) + 1); 
          info.put(removedDish, info.get(removedDish) - 1);
          if(info.get(removedDish) == 0){
              info.remove(removedDish); 
          }
          
          maxType = Math.max(maxType, info.size());
      }
      
      System.out.println(maxType); 
      
    
    }
}
