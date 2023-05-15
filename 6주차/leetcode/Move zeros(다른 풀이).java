// 공간복잡도 O(1)으로 해결할 수 있다
// insertPos라는 변수를 활용한다면

class Solution {
    public void moveZeroes(int[] nums) {


        int insertPos = 0;

        for(int num: nums){
            if(num != 0){
                nums[insertPos++] = num;
            } 
        }

        while(insertPos < nums.length){
            nums[insertPos++] = 0; 
        }

        
    }
}
