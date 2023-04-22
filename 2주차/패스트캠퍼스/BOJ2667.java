import java.util.*; 

public class Main {
    
    public static int N;
    public static int[][] map;
    public static int cnt;
    public static boolean[][] check; 
    
    public static boolean isInside(int x, int y){
        if(1<=x && x<=N && 1<=y && y<=N){
            return true;
        }else{
            return false;
        }
    }
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    
    public static void dfs(int x, int y){
        
          check[x][y] = true;
          cnt++; 
          
          for(int i=0; i<4; i++){
              int nx = x + dx[i];
              int ny = y + dy[i];
              
              if(check[nx][ny] == false && isInside(nx,ny) && map[nx][ny] == 1){
                  dfs(nx, ny);
              }
          }
        
        
        
    }
    
    
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      map = new int[N+10][N+10];
      check = new boolean[N+10][N+10];
      ArrayList<Integer> ans = new ArrayList<>(); 
      int area = 0; 
      
      
      for(int i=1; i<=N; i++){
          
          String str = sc.next();
          
          for(int j=1; j<=N; j++){
              map[i][j] = str.charAt(j-1)-'0';
          }
      }
      
      
      for(int i=1; i<=N; i++){
          for(int j=1; j<=N; j++){
              if(check[i][j] == false && map[i][j] == 1){
                  cnt = 0; 
                  dfs(i, j);
                  ans.add(cnt);
                  area++; 
              }
          }
      }
      
      Collections.sort(ans);
      System.out.println(area);
      for(int i=0; i<ans.size(); i++){
          System.out.println(ans.get(i));
      }
      
      
      
      
      
    }
}
