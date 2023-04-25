// 왜 맞았는가?
// 1. DFS 조건을 잘 설정해줘야 한다
// 2. visited 배열은 매번 새로 업데이트 해줘야 한다
// -> 매번 새로 업데이트해준다는 것은 초기화를 해준다는 것을 의미한다. 

import java.util.*; 

public class Main {
    
    public static int N;
    public static int M; 
    public static int[][] map;
    public static int[][] tmpMap; 
    public static int maxSafeArea; 
    public static boolean[][] visited; 
    
    public static int[] dx ={ -1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1}; 
    
    
    public static boolean isInside(int x, int y){
        if(1<=x && x<=N && 1<=y && y<=M){
            return true;
        }else{
            return false; 
        }
    }
    
    public static void spreadVirus(int x, int y){
        
        
        visited[x][y] = true;
        
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(isInside(nx, ny) && tmpMap[nx][ny] == 0 && visited[nx][ny] == false){
                tmpMap[nx][ny] = 2;
                spreadVirus(nx, ny);
                
            }
        }
        
        
        
    }
    
    
    public static void printMap(int[][] tmpMap){
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                System.out.print(tmpMap[i][j]+ " ");
            }
            System.out.println(); 
        }
        
        
        System.out.println("=============");
        
    }
    
    
    
    
    public static int spread(){
        
        int safeArea = 0; 
        
        tmpMap = new int[N+10][M+10];
        visited = new boolean[N+10][M+10];
        
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                tmpMap[i][j] = map[i][j];
            }
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(tmpMap[i][j] == 2){
                    spreadVirus(i, j);
                }
            }
        }
        
        
        // printMap(tmpMap);
        
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(tmpMap[i][j] == 0){
                    safeArea++;
                }
            }
        }
        
        
        return safeArea;    
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    public static void dfs(int cnt){
        
        
        if(cnt == 3){
            int res = spread();
            maxSafeArea = Math.max(maxSafeArea, res);
            return; 
        }
        
        
        
        
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 3;
                    dfs(cnt+1);
                    map[i][j] = 0; 
                }
            }
        }
        
        
        
        
        
        
    }
    
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      M = sc.nextInt(); 
      map = new int[N+10][M+10];
      visited = new boolean[N+10][M+10]; 
      maxSafeArea = 0; 
      
      
      for(int i=1; i<=N; i++){
          for(int j=1; j<=M; j++){
              map[i][j] = sc.nextInt(); 
          }
      }
      
      dfs(0);
      
      
      System.out.println(maxSafeArea); 
      
      
      
      
      
      
      
      
      
      
      
    }
}
