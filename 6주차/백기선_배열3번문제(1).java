// 시간 복잡도: O(N2)
// 공간 복잡도: O(N)

// 왜 맞았는가?
// -> 2차원 for문을 통해서 문제를 해결할 수 있다. 

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] ans = new int[2]; 

        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j; 
                }
            }
        }

        return ans; 
    }
}
