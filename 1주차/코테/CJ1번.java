import java.util.*; 

public class Main {
    
    
    public static HashSet<String> set = new HashSet<>();
    
    public static int minCnt = Integer.MAX_VALUE; 
    
    public void DFS(int index, String curr, String number, int cnt){
        
        set.add(curr); 
        if(cnt >= minCnt){
            return; 
        }
        
        if(curr.equals(number)){
            minCnt = Math.min(minCnt, cnt);
            return; 
        }
        
        if(index < number.length()){
            
            int num = number.charAt(index)-'0';
        
            if(num != 0){
                if(num != 9){
                    curr += Integer.toString(num);
                    curr += Integer.toString(num+1);
                }else{
                    curr += Integer.toString(9);
                    curr += Integer.toString(0);
                }
                
                DFS(index+2, curr, number, cnt+1);
                
                curr = curr.substring(0, curr.length()-2);
                
                
            }else if(num == 0){
                curr += Integer.toString(0);
                
                DFS(index+1, curr, number, cnt+1);
                
                curr = curr.substring(0, curr.length()-1);
            }
        }
        
        if(curr.length() >= 1){
            if(!set.contains(curr.substring(0, curr.length()-1))){
                DFS(index-1, curr.substring(0, curr.length()-1), number, cnt+1);
            }
        }
        
        
    }
    
    
    
    
    
    
    
    public int solution(String number){
        
        
        int index = 0; 
        String curr = "";
        int cnt = 0; 
        
        DFS(index, curr, number, cnt);
        
        return minCnt;     
        
    }
    
    
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      String str = "100";
      
      
      Main T = new Main();
      
      int answer = T.solution(str);
      
      
      System.out.println("answer는?" + answer); 
      
      
    }
}
