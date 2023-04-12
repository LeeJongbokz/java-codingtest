// 60분 초과
// 1sol
// 오랜만에 푸는 분할정복 문제였다.
// 이전에 분할정복 문제를 풀어봤기 때문에, 
// 봤을 때 바로 분할정복 문제라는 점을 알 수 있었고, 문제에 접근할 수 있었다.  
// 단, 구현을 하는데 있어서, 디테일한 실수들이 많았다. 
// 예를 들어, isSame 메소드에서 변수명을 설정하는 것이라든지
// 혹은, divide 메소드에서 return 조건을 설정하는 것이라든지
// 다른 IDE를 활용해서 출력하면서 디버깅함으로써 해결할 수 있었지만
// 미리 좀 더 고민하고, 그러한 점을 잘 고려해서 코드를 짰으면 좋았을 것 같다.
// 다른 풀이도 한 번 참고해보고, 다시 한 번 풀어서 숙련도를 높여야겠다. 

// 왜 맞았는가?
// 1) 분할정복으로 접근해야 한다는 점을 인식했다.
// 2) 행, 그리고 열과 관련한 변수를 설정하고, 시작점과 끝점도 같이 설정했다.
// 3) 분할정복으로 쪼개어 들어가면서 검사를 진행하고, 만약에 모든 원소가 같으면, 
//    더 이상 쪼개들어가지 않고, 단일한 값을 리턴했다.
// 4) 반환되는 값들을 더해서 재귀적으로 리턴했다. 


class Solution {
   
    public boolean isSame(int[][] arr, int rs, int re, int cs, int ce){
        
        if( re - rs == 1 && ce-cs == 1){
            return true;
        }
        
        int num = arr[rs][cs];
        
        for(int i=rs; i<re; i++){
            for(int j=cs; j<ce; j++){
                if(num != arr[i][j]){
                    return false;
                }
            }
        }
        
        
        return true; 
        
    }
    
    
    public String divide(int[][] arr, int rs, int re, int cs, int ce){
        
        boolean result = isSame(arr, rs, re, cs, ce);
        
        if(result){
            return Integer.toString(arr[rs][cs]); 
        }
        
        int half = (re-rs)/2; 
        
        return divide(arr, rs, rs+half, cs, cs+half)+ divide(arr, rs, rs+half, cs+half, ce)+divide(arr, rs+half, re, cs, cs+half)+divide(arr, rs+half, re, cs+half, ce);
        
    }
    
    
    public int[] solution(int[][] arr) {
        
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0; 
        
        int row = arr.length;
        int col = arr[0].length;
        
        String str = divide(arr, 0, row, 0, col);
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            
            if(c == '1'){
                answer[1] += 1;
            }else if(c == '0'){
                answer[0] += 1;
            }
        }
        
        
        return answer;
    }
}
