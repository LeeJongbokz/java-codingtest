// 왜 맞았는가?
// 1. ArrayList 배열을 적절히 선언했다.
// 2. 여기에 값을 저장했다.
// 3. 그 다음에 그 값들을 잘 정렬했다. 

import java.util.*; 


public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int sum = 0; 
      
      int N = sc.nextInt();
      ArrayList<Integer>[] arr = new ArrayList[N+10];
      
      for(int i=1; i<=N; i++){
          arr[i] = new ArrayList<>(); 
      }
      
      for(int i=1; i<=N; i++){
          int pos = sc.nextInt();
          int color = sc.nextInt();
          arr[color].add(pos); 
      }
      
      for(int i=1; i<=N; i++){
          Collections.sort(arr[i]);
      }
      
      
      for(int i=1; i<=N; i++){
          if(arr[i].size() != 0){
              
              int tmp = 0; 
              
              
              for(int j=0; j<arr[i].size(); j++){
                  
                  if(j == 0){
                      tmp += arr[i].get(j+1)-arr[i].get(j);
                  }else if(j == arr[i].size()-1){
                      tmp += arr[i].get(arr[i].size()-1)-arr[i].get(arr[i].size()-2);
                  }else{
                      tmp += Math.min(Math.abs(arr[i].get(j+1)-arr[i].get(j)), Math.abs(arr[i].get(j)-arr[i].get(j-1)));
                      
                  }
                  
              }
              
              
              sum += tmp;
              
              
          }
      }
      
      System.out.println(sum); 
      
      
      
      
    }
}
