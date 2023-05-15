class Solution {
    public void moveZeroes(int[] nums) {
        
           ArrayList<Integer> arr = new ArrayList<>();
           int total = nums.length; 
           int zeroCnt = 0; 

           for(int i=0; i<nums.length; i++){
               if(nums[i] == 0){
                   zeroCnt++;
                   continue;
               }else{
                   arr.add(nums[i]);
               }
           }

           int N = arr.size();

           for(int i=0; i<N; i++){
               nums[i] = arr.get(i);
           }
           
           for(int i=N; i<total; i++){
               nums[i] = 0; 
           }



    }
}
