// 강의를 참고해서 구현했습니다.
// insertAtBottom이라는 메소드를 통해서, 값을 맨 아래에 넣어주는 것이 핵심입니다.
// 또한, 시간복잡도는 O(N^2), 공간복잡도는 O(N)이라는 점도 중요합니다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      
        Main T = new Main();
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        T.solution(stk);
        
        while(!stk.isEmpty()){
            int num = stk.pop();
            System.out.println("num은?" + num); 
        }
      
    }
    
    
    public void solution(Stack<Integer> stk){
        
        if(stk.empty()){
            return;
        }else{
            int temp = stk.pop();
            solution(stk);
            insertAtBottom(stk, temp);
        }
    }
    
    
    public void insertAtBottom(Stack<Integer> stk, int num){
        
        if(stk.empty()){
            stk.push(num);
        }else{
            int temp = stk.pop();
            insertAtBottom(stk, num);
            stk.push(temp);
        }
    }
    
    
    
}
