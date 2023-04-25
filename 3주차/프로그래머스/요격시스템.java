// 왜 맞았는가?
// 1. Greedy한 접근이라는 점을 알아야 한다
// 2. 각 단계에서 최선의 선택을 하고, 그 선택이 누적된 결과가 전체의 최적값이 된다.
// 3. 강의실 문제도 다시 풀어보도록 하자. 

import java.util.*; 

class Solution {
    public int solution(int[][] targets) {
        
        int answer = 0; 
        
        Arrays.sort(targets, (o1, o2) -> {return o1[1]-o2[1]; });
        
        double last = -1.0;             
                    
        for(int[] target: targets){
            
            if(last == -1.0){
                answer++;
                last = (double)target[1]-0.1;
            }
            
            if(target[0]<=last && last<= target[1]) continue;
            
            answer++;
            last = (double)target[1]-0.1; 
        }             
                    
                
        return answer;
    }
}
