// 왜 맞았는가?
// 1. Character인 경우에 arr에 넣어주고, 아닌 경우는 sum에 더해줬다. 
// 2. arr을 Collections.sort를 활용해서 정렬했다. 
// 3. 정렬된 arr을 ans에 더해주고, ans에 sum을 문자열로 바꿔서 더해준다. 

import java.util.*; 

public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      String str = sc.next();
      int sum = 0;
      String ans = "";
      ArrayList<Character> arr = new ArrayList<>(); 
      
      for(int i=0; i<str.length(); i++){
          
          char c = str.charAt(i);
          
          if('0' <= c && c <= '9'){
              sum += c-'0';
          }else{
              arr.add(c);
              // tmp += Character.toString(c);
          }
      }
      
      Collections.sort(arr);
      
      for(int i=0; i<arr.size(); i++){
          ans += Character.toString(arr.get(i));
      }
      ans += Integer.toString(sum);
      System.out.println(ans); 
      
    }
}
