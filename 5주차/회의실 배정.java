import java.util.*; 


public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int cnt = 0; 
      
      int N = sc.nextInt();
      int[][] arr = new int[N][2];
      
      for(int i=0; i<N; i++){
          int start = sc.nextInt();
          int end = sc.nextInt();
          arr[i][0] = start;
          arr[i][1] = end;
      }
      
      Arrays.sort(arr, (o1, o2) -> {
          
          if(o1[1] == o2[1]){
              return o1[0]-o2[0];
          }
          
          return o1[1]-o2[1]; 
          
      });
      
      
      
      int last = arr[0][1];
      cnt = 1; 
      
      for(int i=1; i<N; i++){
          
          int start = arr[i][0];
          
          if(start>=last){
              last = arr[i][1];
              cnt++; 
          }
          
      }
  
      System.out.println(cnt);
      
      
      
    }
}
