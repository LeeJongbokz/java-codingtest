import java.util.*; 

public class Main {
    
    public static int N;
    public static ArrayList<Integer>[] arr; 
    public static int[] parents;
    public static boolean[] visited; 
    
    public static void dfs(int parent, int curr){
        
        parents[curr] = parent;
        
        for(int i=0; i<arr[curr].size(); i++){
            
            int next = arr[curr].get(i);
            
            if(!visited[next]){
                visited[next] = true;
                dfs(curr, next);
                visited[next] = false; 
            }
            
        }
        
        
    }
    
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      arr = new ArrayList[N+1];
      parents = new int[N+1];
      visited = new boolean[N+1];
      
      for(int i=1; i<=N; i++){
          arr[i] = new ArrayList<>();
      }
      
      
     
      
      for(int i=1; i<=N-1; i++){
          int a = sc.nextInt();
          int b = sc.nextInt();
          arr[a].add(b);
          arr[b].add(a);
      }
      
      visited[1] = true; 
      dfs(-1, 1);
      
      for(int i=2; i<=N; i++){
          System.out.println(parents[i]);
      }
      
      
      
      
    }
}
