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
    
    public static int N;
    public static int M; 
    
    public static ArrayList<Pair> lights; 
    public static ArrayList<Pair>[][] info; 
    public static boolean[][] visited; 
    public static int visitedCnt; 
    public static int[][] lightOn; 
    
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    
    public static boolean isInside(int x, int y){
        if(1<=x && x<=N && 1<=y && y<=N){
            return true;
        }else{
            return false; 
        }
    }
    
    public static void dfs(int x, int y){
        
        
        // System.out.println("x, y는?" + x + " " + y);
        // System.out.println("visited는?" + visited[x][y]);
        
        ArrayList<Pair> curr = info[x][y];
        
        if(visited[x][y] == false){
            for(int i=0; i<curr.size(); i++){
                lightOn[curr.get(i).x][curr.get(i).y] = 1;
                boolean isExist = false;
                
                for(int j=0; j<lights.size(); j++){
                    if(lights.get(j).x == curr.get(i).x && lights.get(j).y == curr.get(i).y){
                        isExist = true;
                        break;
                    }
                }
                if(isExist == false){
                    lights.add(curr.get(i));
                }
            }
            visited[x][y] = true; 
            visitedCnt++; 
        }
        
        
        // System.out.println("lights.size는?" + lights.size());
        /*
        for(int i=0; i<lights.size(); i++){
            System.out.println("x, y는?" + lights.get(i).x + " " + lights.get(i).y);
        }
        */
        
        
        // System.out.println("visitedCnt는?" + visitedCnt);
        // System.out.println("visited는?" + visited[x][y]);
        
        if(visitedCnt == lights.size()){
            return; 
        }
        
        for(int i=0; i<4; i++){
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(isInside(nx,ny) && lightOn[nx][ny] == 1 && visited[nx][ny] == false){
                dfs(nx, ny);
            }
            
            
        }
        
        if(visitedCnt != lights.size()){
         
         for(int i=0; i<4; i++){
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(isInside(nx,ny) && lightOn[nx][ny] == 1){
                dfs(nx, ny);
            }
            
            
         }   
            
            
            
        }
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      info = new ArrayList[105][105];
      visited = new boolean[105][105];
      lightOn = new int[105][105];
      
      lights = new ArrayList<>();
      visitedCnt = 0; 
      
      for(int i=1; i<=100; i++){
          for(int j=1; j<=100; j++){
              info[i][j] = new ArrayList<Pair>(); 
          }
      }
      
      
      N = sc.nextInt();
      M = sc.nextInt(); 
      
      for(int i=1; i<=M; i++){
          int x = sc.nextInt();
          int y = sc.nextInt();
          int a = sc.nextInt();
          int b = sc.nextInt(); 
          
          info[x][y].add(new Pair(a,b));
      }
      
      
      lightOn[1][1] = 1;
      lights.add(new Pair(1, 1));
      
      dfs(1, 1);
      
      System.out.println(lights.size());
      
      
      
      
      
    }
}
