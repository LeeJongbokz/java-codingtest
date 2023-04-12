// 20분
// 1sol
// 스택과 문자열의 substring을 통해서 풀었다.
// 왜 맞았는가?
// 1) isRight라는 메소드에서 스택을 통해서 올바른 문자열인지 확인했다.
//    올바른 문자열일 때의 조건을 정확히 구현해냈다.
// 2) String의 substring 메소드를 활용해서 괄호가 회전하는 것을 구현해냈다.
//    첫 괄호를 계속해서 뒤에 붙이는 식으로 구현했고, 
//    회전 회수를 문자열의 길이로 제한했다.
//    문자열의 길이만큼 회전하면 원래 문자열로 되돌아오게 된다. 


import java.util.*; 

class Solution {
    
    public boolean isRight(String s){
        
        Stack<Character> stk = new Stack<>();
        
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '(' || c == '[' || c == '{'){
                stk.push(c);
            }else{
                
                if(stk.size() == 0){
                    return false; 
                }
                
                if(stk.peek() == '(' && c == ')'){
                    stk.pop();
                }else if(stk.peek() == '[' && c == ']'){
                    stk.pop();
                }else if(stk.peek() == '{' && c == '}'){
                    stk.pop();
                }else{
                    return false;    
                }
            }
        }
        
        if(stk.size() == 0){
            return true;
        }else{
            return false; 
        }
        
        
        
        
        
    }
    
    
    
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        
        while(true){
            
            if(cnt == s.length()){
                break;
            }
            
            boolean result = isRight(s);
            
            if(result){
                answer++;
            }
            
            s = s.substring(1) + s.charAt(0);
            
            cnt++; 
            
        }
        
        
        return answer;
    }
    
}
