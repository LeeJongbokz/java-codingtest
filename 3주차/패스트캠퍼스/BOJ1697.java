import java.util.*; 

public class Main {
    
    public static int N;
    public static int K; 
    public static int[] count; 
    
    
    public static boolean isInside(int x){
        
        if(0<=x && x<=100000){
            return true;
        }else{
            return false; 
        }
        
        
    }
    
    public static void bfs(int start){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        count[start] = 1;
        
        
        while(!q.isEmpty()){
            
            int curr = q.poll();
            // System.out.println("curr은?" + curr+ "count는?" + count[curr]); 
            if(curr == K){
                break;
            }
            
            for(int i=0; i<3; i++){
                
                int nx = 0;
                if(i == 0) nx = curr-1;
                if(i == 1) nx = curr+1;
                if(i == 2) nx = curr*2;
                
                if(isInside(nx) && count[nx] == 0){
                    count[nx] = count[curr]+1; 
                    q.add(nx); 
                }
            }
            
        }
        
        
        
        
        
    }
    
    
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      
      count = new int[100010];
      N = sc.nextInt();
      K = sc.nextInt(); 
      
      bfs(N);
      System.out.println(count[K]-1);
      
      
      
      
      
    }
}
