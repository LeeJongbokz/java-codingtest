// 제목: 수열 정렬

// 왜 맞았는가?
// 1) 문제의 케이스를 적절한 코드로 변환했다.
// 2) 여기서 중요한 것은 문제의 케이스를 정렬을 통해 올바른 케이스로 변환하는 것입니다.
// 3) 이 과정에서 값을 저장하기 위한 임시 배열을 활용할 수도 있었습니다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
    
      int N = sc.nextInt();
      int[] arr = new int[N];
      int[] tmp = new int[N];
      int[][] data = new int[1010][1010];
      ArrayList<Integer> ans = new ArrayList<>(); 
      
      for(int i=0; i<N; i++){
          int num = sc.nextInt();
          arr[i] = num;
          tmp[i] = num;
      }
        
      Arrays.sort(tmp);
      
      for(int i=0; i<N; i++){
          int num = tmp[i];
          data[num][i] = 1;
      }
      
      
      for(int i=0; i<N; i++){
          int num = arr[i];
          
          for(int j=0; j<1010; j++){
              if(data[num][j] == 1){
                 data[num][j] = 0; 
                 ans.add(j);   
                 break; 
              }
          }
      }
      
      for(int i=0; i<ans.size(); i++){
          System.out.print(ans.get(i)+ " ");
      }
      
      
    }
}
