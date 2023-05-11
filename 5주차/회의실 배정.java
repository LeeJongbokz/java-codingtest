// 왜 맞았는가?
// -> 종료시간이 같은 경우, 시작 시간이 빠른 순서대로 정렬하지 않으면,
// 반례가 생길 수 있음을 잘 알아야 한다
// 어떤 반례가 생기는가?
// 0 4
// 8 8
// 4 8 
// 만약 정렬을 하지 않는다면?
// 0 4 하고 8 8을 고르게 되지만, 이것은 최적의 케이스가 아니라고 할 수 있다. 


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
