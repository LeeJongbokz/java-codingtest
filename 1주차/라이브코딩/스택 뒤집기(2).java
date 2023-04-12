// 다음과 같이 바로 스택을 이용해서 바로 뒤집는 것도 가능하다 
// 스택에서 pop하는 값들을 새로운 스택에 차곡차곡 쌓고, 
// 새로운 스택을 결과로 반환한다. 


public Stack<Integer> reverseStack(Stack<Integer> stk){
        
     Stack<Integer> reversedStack = new Stack<>(); 
        
        
     while(!stk.empty()){
         reversedStack.push(stk.pop());
     }
        
     return reversedStack; 
}
