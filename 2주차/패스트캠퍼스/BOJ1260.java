// 1sol

// 왜 맞았는가?
-> 1) DFS, BFS 개념을 잘 적용했다
-> 2) ArrayList 배열을 잘 만들어줬다
-> 3) ArrayList 배열을 정렬해줬다
-> 4) ArrayList 배열에 값을 넣을 때, 양쪽으로 다 넣어줬다.
-> 5) visited 배열을 잘 활용해줬다. 


import java.util.*; 

public class Main {
    
    
    public static int N;
    public static int M;
    public static int V; 
    public static boolean[] visited; 
    public static ArrayList<Integer>[] arr; 
    
    
    public static void DFS(int curr){
        
             System.out.print(curr+" "); 
             visited[curr] = true;
        
             for(int i=0; i<arr[curr].size(); i++){
                   int next = arr[curr].get(i);
                      
                   if(!visited[next]){
                       DFS(next); 
                   } 
             }   
          
        
    }
    
    
    
    public static void BFS(int curr){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        visited[curr] = true;
        
        while(!q.isEmpty()){
            
            int num = q.poll();
            System.out.print(num + " ");
            
            for(int i=0; i<arr[num].size(); i++){
                int next = arr[num].get(i);
                
                if(!visited[next]){
                    visited[next] = true; 
                    q.add(next);
                }
            }
            
            
        }
        
        
        
        
        
    }

    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in); 
              
        N = sc.nextInt();
        M = sc.nextInt(); 
        V = sc.nextInt(); 
        
        visited = new boolean[N+10];
        
        arr = new ArrayList[N+10];
        
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>(); 
        }
        
        
        for(int i=1; i<=M; i++){
           int a = sc.nextInt();
           int b = sc.nextInt(); 
        
           arr[a].add(b);
           arr[b].add(a); 
        }
        
        for(int i=1; i<=N; i++){
            Collections.sort(arr[i]);
        }
        
        
        
        DFS(V);
        System.out.println(); 
        
        visited = new boolean[N+10];
        
        BFS(V); 




    }
}
