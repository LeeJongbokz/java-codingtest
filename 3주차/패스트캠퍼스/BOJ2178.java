import java.util.*; 


class Pair{
    
    int x;
    int y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    
    
}


public class Main {
    
    
    public static int[][] map;
    public static int[][] count; 
    public static int N;
    public static int M;
    public static int ans; 
    
    public static boolean isInside(int x, int y){
        if(1<=x && x<=N && 1<=y && y<=M){
            return true;
        }else{
            return false; 
        }
    }
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1}; 
    
    
    
    public static void BFS(int sx, int sy){
        
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sx,sy));
        count[sx][sy] = 1;
        
        while(!q.isEmpty()){
            
            Pair curr = q.poll();
            
            int x = curr.x;
            int y = curr.y;
            
            if(x == N && y == M){
                ans = count[N][M];
                break; 
            }
            
            for(int i=0; i<4; i++){
                
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(isInside(nx, ny) && map[nx][ny] == 1 && count[nx][ny] == 0){
                    count[nx][ny] = count[x][y] + 1;
                    q.add(new Pair(nx,ny));
                }
                
                
            }
            
            
            
        }
        
        
        
        
        
        
    }
    
    
    
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      
      ans = 0;
      N = sc.nextInt();
      M = sc.nextInt(); 
      map = new int[N+10][M+10];
      count = new int[N+10][M+10];
      
      for(int i=1; i<=N; i++){
          String str = sc.next();
          
          for(int j=1; j<=M; j++){
              map[i][j] = str.charAt(j-1)-'0';
          }
      }
      
      
      
      BFS(1, 1); 
      
      
      
      System.out.println(ans);
      
      
      
    }
}
