// 왜 맞았는가?
// 1. 문제의 규칙을 잘 이해해서 이를 ArrayList로 풀어냈다.
// 2. (k-1)씩 잘 더해줬고, arr.size()로 잘 modulo 연산을 해줬다. 

import java.util.*; 

class Solution {
    public int findTheWinner(int n, int k) {


            ArrayList<Integer> arr = new ArrayList<>();

            for(int i=1; i<=n; i++){
                arr.add(i); 
            }

            int pos = 0; 

            while(true){

                if(arr.size() == 1){
                    break; 
                }

                pos += (k-1);
                pos %= arr.size(); 
                arr.remove(pos);
            }

            return arr.get(0); 

    }

}
