import java.util.*; 


// x,y값을 저장하기 위한 Pair 클래스를 만듭니다.ㄴ 
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
            
            // 다음 물의 위치, 고슴도치의 위치를 저장하기 위한 ArrayList를 선언합니다. 
            ArrayList<Pair> nextWaters = new ArrayList<>();
            ArrayList<Pair> nextHedgeHogs = new ArrayList<>();
            
            
            // waters ArrayList를 순회하면서, 다음 water가 될 수 있는 위치를 탐색하고,
            // 해당 위치의 map을 업데이트해줍니다. 
            for(int i=0; i<waters.size(); i++){
                
                
                for(int j=0; j<4; j++){
                    
                    
                    int nx = waters.get(i).x+dx[j];
                    int ny = waters.get(i).y+dy[j];
                    if(!isInside(nx,ny)){
                        continue;
                    }                
                       
                    // 다음 위치가 '.'이거나, 'S'이면 물이 확장될 수 있습니다. 
                    if(map[nx][ny] == '.' || map[nx][ny] == 'S'){
                        map[nx][ny] = '*';
                        nextWaters.add(new Pair(nx,ny));
                    }
                    
                }
                
            }
            
            // nextWaters ArrayList를 waters에 업데이트해줍니다. 
            waters = nextWaters;
            
            // hedgeHogs ArrayList를 순회하면서, 다음 hedgeHogs가 될 수 있는 위치를 탐색하고,
            // 해당 위치의 map을 업데이트해줍니다. 
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
                
                    // 만약 다음 위치가 동굴이면
                    // 동굴에 도달할 수 있으므로, isFound를 해줍니다. 
                    if(map[nx][ny] == 'D'){
                        isFound = true;
                    }
                    
                    
                }
            }
            
            
            
            if(isFound == true){
                break; 
            }
            
            // 만약 더 이상 고슴도치가 갈 수 있는 곳이 없다면
            // while문을 break해줍니다. 
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
        
      // waters, hedgeHogs Pair를 저장하기 위한 ArrayList를 각각 만들어줍니다. 
      waters = new ArrayList<>();
      hedgeHogs = new ArrayList<>(); 
      
      for(int i=1; i<=R; i++){
          String str = sc.next();
          
          // map의 좌표에 입력된 값을 저장해줍니다. 
          for(int j=1; j<=C; j++){
              map[i][j] = str.charAt(j-1);
          }
      }
      
      
      // 처음 waters의 Pair와 hedgeHogs의 Pair를 저장해줍니다. 
      for(int i=1; i<=R; i++){
          for(int j=1; j<=C; j++){
              if(map[i][j] == '*'){
                  waters.add(new Pair(i,j));
              }else if(map[i][j] == 'S'){
                  hedgeHogs.add(new Pair(i,j));
              }
          }
      }
      
      
      
      // bfs함수 실행 
      bfs(); 
      
      
      if(isFound == true){
          System.out.println(time);
      }else{
          System.out.println("KAKTUS");
      }
      
      
      
      
      
      
    }
}
