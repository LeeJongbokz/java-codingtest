// 54분
// 1sol
// 구현 문제이다보니, 문제의 구현 조건을 하나씩 확인하면서 구현했습니다.  
// 크게 어려운 문제는 아니지만, 중간 중간 다른 것을 하면서 하다보니 시간이 더 걸렸던 것 같습니다.
// 1. 나의 풀이에 확신을 갖고 2.한 번에 맞추면서 3.30분 이내에 풀 수 있으면 좋을 것 같습니다.  
// 스택을 오랜만에 적용해봐서, 이 부분을 올바르게 적용했는지 한 번 복기해야겠습니다. 
// check 메소드에서 짝이 없으면 return p하는 부분이 있는데, 이 부분에 대해 좀 더 명확히 이해해야겠습니다.

import java.util.*; 

class Solution {
    
    public boolean isRight(String u){
        
        Stack<Character> stk = new Stack<>();
        
        int len = u.length();
        
        for(int i=0; i<len; i++){
            
            char t = u.charAt(i);
            
            if(t == '('){
                stk.push(t);
            }else{
                if(stk.size() == 0){
                    return false;
                }
                
                stk.pop(); 
                
            }
        }
        
        
        if(stk.size() == 0){
            return true;
        }else{
            return false; 
        }
        
        
        
        
    }
    
    
    public String check(String p){
        
        
        int len = p.length();
        int open = 0;
        int close = 0; 
        
        for(int i=0; i<len; i++){
            
            if(p.charAt(i) == '('){
                open++;
            }else{
                close++;
            }
            
            if(open == close){
                
                
                String u = p.substring(0, i+1);
                String v = p.substring(i+1); 
                
                String newStr ="";
                
                if(isRight(u)){
                    
                    
                    String result = check(v);
                    newStr += u;
                    newStr += result;
                    
                }else{
                    
                    String result = check(v);
                    
                    String newU = "";
                    
                    for(int j=1; j<u.length()-1; j++){
                        if(u.charAt(j) == '('){
                            newU += ')';
                        }else{
                            newU += '(';
                        }
                    }
                    
                    
                    newStr += '(';
                    newStr += result;
                    newStr += ')';
                    newStr += newU;
                }
                
                
                return newStr; 
                
            }
        }
        
        return p; 
        
    }
    
    
    
    public String solution(String p) {
        String answer = check(p);
        return answer;
    }
}
