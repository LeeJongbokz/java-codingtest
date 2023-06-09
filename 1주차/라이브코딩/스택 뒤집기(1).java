// 1sol
// 10분
// 1.왜 이렇게 풀었는가?
// - 스택을 뒤집는다고 해서 우선은 ArrayList를 하나 활용해서 거기에 저장을 해두고,
//   그 다음에 다시 스택에 넣는 방식을 취해봤다. 
// 2. 재귀적으로 풀려면 어떻게 하는가?
// - 재귀적으로 풀 수 있는 방법에 대해서 고민해봐야겠다.  
// 3. 왜 !stk.emtpy()를 쓰는가?
// - !stk.empty()를 통해 스택이 빈 스택이 될때까지, 계속해서 반복할 수 있다.
//    stk.empty()가 true가 되면, !stk.empty()는 false가 되서 while문을 탈출하기 때문이다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      
      Stack<Integer> stk = new Stack<>();
      ArrayList<Integer> arr = new ArrayList<>();
      
      stk.push(1);
      stk.push(2);
      stk.push(3);
      
      while(!stk.empty()){
          int num = stk.pop();
          arr.add(num); 
      }
      
      while(arr.size() != 0){
          int num = arr.get(0);
          stk.push(num);
          arr.remove(0);
      }
      
    }
}
