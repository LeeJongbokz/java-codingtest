// 시간 복잡도: O(N)
// 공간 복잡도: O(N)

// 왜 맞았는가?
// 1) HashMap을 사용해서, for문을 1번만 사용하고, 문제를 해결할 수 있다.
// 2) HashMap에 값과 값의 인덱스를 저장해 놓는다. 

import java.util.*; 

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] ans = new int[2]; 

        HashMap<Integer, Integer> map = new HashMap<>(); 

        for(int i=0; i<nums.length; i++){
            int num = nums[i];

            if(map.containsKey(target-num)){
                ans[0] = map.get(target-num);
                ans[1] = i;
                break;
            }else{
                map.put(num, i); 
            }

        }

        return ans; 
    }
}
