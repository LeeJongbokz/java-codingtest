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
    
    public static int R;
    public static int C;
    public static char[][] map;
    public static ArrayList<Pair> waters;
    public static ArrayList<Pair> hedgeHogs;
    public static boolean isFound = false; 
    public static int time = 0; 
    
    public static int[]dx ={-1, 1, 0, 0};
    public static int[]dy ={0, 0, -1, 1};
    
    public static boolean isInside(int x, int y){
        if(1<=x && x<=R && 1<=y && y<=C){
            return true;
        }else{
            return false;
        }
    }
    
    
    public static void bfs(){
        
        
        while(true){
            
            time++; 
            
            ArrayList<Pair> nextWaters = new ArrayList<>();
            ArrayList<Pair> nextHedgeHogs = new ArrayList<>();
            
            
            
            for(int i=0; i<waters.size(); i++){
                
                
                for(int j=0; j<4; j++){
                    
                    
                    int nx = waters.get(i).x+dx[j];
                    int ny = waters.get(i).y+dy[j];
                    if(!isInside(nx,ny)){
                        continue;
                    }                

                    if(map[nx][ny] == '.' || map[nx][ny] == 'S'){
                        map[nx][ny] = '*';
                        nextWaters.add(new Pair(nx,ny));
                    }
                    
                }
                
            }
            
            waters = nextWaters;
            
            for(int i=0; i<hedgeHogs.size(); i++){
                
                int x = hedgeHogs.get(i).x;
                int y = hedgeHogs.get(i).y;
            
                
                for(int j=0; j<4; j++){
                    
                    int nx = hedgeHogs.get(i).x+dx[j];
                    int ny = hedgeHogs.get(i).y+dy[j];
                    
                    
                    if(!isInside(nx, ny)){
                        continue;
                    }
                
                    if(map[nx][ny] == '.'){
                        map[nx][ny] = 'S';
                        nextHedgeHogs.add(new Pair(nx,ny));
                    }
                
                    if(map[nx][ny] == 'D'){
                        isFound = true;
                    }
                    
                    
                }
            }
            
            
            
            if(isFound == true){
                break; 
            }
            
            if(nextHedgeHogs.size() == 0){
                break;
            }
            
            hedgeHogs = nextHedgeHogs;
            
            
            
            
            
            
            
        }
        
        
        
        
        
        
    }
    
    
    
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      R = sc.nextInt();
      C = sc.nextInt(); 
      map = new char[R+10][C+10];
      waters = new ArrayList<>();
      hedgeHogs = new ArrayList<>(); 
      
      for(int i=1; i<=R; i++){
          String str = sc.next();
          
          for(int j=1; j<=C; j++){
              map[i][j] = str.charAt(j-1);
          }
      }
      
      
      for(int i=1; i<=R; i++){
          for(int j=1; j<=C; j++){
              if(map[i][j] == '*'){
                  waters.add(new Pair(i,j));
              }else if(map[i][j] == 'S'){
                  hedgeHogs.add(new Pair(i,j));
              }
          }
      }
      
      
      
      
      bfs(); 
      
      
      if(isFound == true){
          System.out.println(time);
      }else{
          System.out.println("KAKTUS");
      }
      
      
      
      
      
      
    }
}
