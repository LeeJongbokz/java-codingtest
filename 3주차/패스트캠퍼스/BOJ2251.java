// 왜 맞았는가?
// -> 이 문제는 BFS를 쓰는 것이 좋다
// -> BFS를 통해 가능한 연관 케이스를 다 탐색해서 큐에 넣는다
// -> 그 다음에 맞는 경우만 boolean 배열에 기록한다. 
// -> 그리고 방문한 점들은 visited 배열에 기록한다.
// -> 다시 한 번 풀어보자. 


import java.util.*; 


class Info{
    
    int a;
    int b;
    int c;
    
    public Info(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c; 
    }
    
    
    
}


public class Main {
    
    public static int A;
    public static int B;
    public static int C;
    public static int[] size; 
    public static boolean[][][] visited; 
    public static boolean[] possible; 
    
    public static Info move(int[] arr, int from, int to){
        
        int curr = arr[from];
        int left = size[to]-arr[to];
        
        if(curr >= left){
            arr[from] -= left;
            arr[to] += left; 
        }else{
            arr[from] = 0;
            arr[to] += curr;
        }
        
        return new Info(arr[0], arr[1], arr[2]);
        
        
    }
    
    
    /*
    public static void dfs(int a, int b, int c, int cnt){
        
        visited.add(new Info(a, b, c));
        
        if(cnt!= 0 && a == 0){
            ans.add(c);
            return; 
        }
        
        ArrayList<Info> next = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i != j){
                    
                    int[] tmpWater = new int[3];
                    
                    tmpWater[0] = a;
                    tmpWater[1] = b;
                    tmpWater[2] = c; 
                    
                    move(tmpWater, i, j);
                    boolean isExist = false; 
                    
                    for(int k=0; k<visited.size(); k++){
                        Info tmp = visited.get(k);
                        
                        if(tmp.a == tmpWater[0] && tmp.b == tmpWater[1] && tmp.c == tmpWater[2]){
                            isExist = true;
                        }
                    }
                    
                    if(isExist == false && !( (tmpWater[0] == a) && (tmpWater[1] == b) && (tmpWater[2] == c)  )){
                        next.add(new Info(tmpWater[0], tmpWater[1], tmpWater[2]));
                    }
                    
                    
                }
            }   
        }
        
        
        for(int i=0; i<next.size(); i++){
            dfs(next.get(i).a, next.get(i).b, next.get(i).c, cnt+1);
        }
        
        

        
        
    }
    */
    
    
    
    public static void bfs(){
        
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, C));
        visited = new boolean[210][210][210];
        visited[0][0][C] = true; 
        
        
        while(!q.isEmpty()){
            
            Info curr = q.poll();
            // System.out.println(curr.a + " " + curr.b + " " + curr.c);
            
            if(curr.a == 0){
                possible[curr.c] = true; 
            }
            
            
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i != j){
                    
                    int[] tmpWater = new int[3];
                    
                    tmpWater[0] = curr.a;
                    tmpWater[1] = curr.b;
                    tmpWater[2] = curr.c; 
                    
                    Info next = move(tmpWater, i, j);
                    
                    if(!visited[next.a][next.b][next.c]){
                        visited[next.a][next.b][next.c] = true; 
                        q.add(next);
                    }
                    
                }
            }   
        }
            
            
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      A = sc.nextInt();
      B = sc.nextInt();
      C = sc.nextInt();
      
      size = new int[3];
     
      size[0] = A;
      size[1] = B;
      size[2] = C;
      
      // dfs(0, 0, C, 0);
      possible = new boolean[210];
      
      bfs();
      
      
      ArrayList<Integer> ans = new ArrayList<>();
      
      for(int i=0; i<=200; i++){
          if(possible[i] == true){
              ans.add(i);
          }
      }
      
      
      for(int i=0; i<ans.size(); i++){
          System.out.print(ans.get(i)+ " ");
      }
      
      
      
      
      
      
      
      
    }
}
