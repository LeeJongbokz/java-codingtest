import java.util.*; 

public class Main {
    
    
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] check = new boolean[10];
    
    public static void recursive(ArrayList<Integer> arr, int N, int M, int cnt){
        
        if(M == cnt){ 
            for(int i=0; i<arr.size(); i++){
                sb.append(arr.get(i)+ " ");
            }
            sb.append('\n');
            return; 
        }
        
        int lastNum;
        
        if(arr.size() == 0){
            lastNum = 1;
        }else{
            lastNum = arr.get(arr.size()-1)+1;
        }
        
        
        
        for(int i=lastNum; i<=N; i++){
                arr.add(i);
                recursive(arr, N, M, cnt+1);
                arr.remove(arr.size()-1);
        }
    }
    
    
    
    
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int M = sc.nextInt();
      
      Main T = new Main();
      int cnt = 0;
      ArrayList<Integer> arr = new ArrayList<>(); 
      
      T.recursive(arr, N, M, cnt);
      
      System.out.println(sb);
      
    }
}
