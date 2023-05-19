class Solution {
    public int lastRemaining(int n) {
        
       int count = n;
       int passes = 0;
       int first = 1;
       int gap = 1;


       while(count > 1){

           passes++;

           if(passes % 2 == 1 || count % 2 == 1){
               first += gap;
           }

           gap *= 2;
           count /=2;
       }

        return first; 

    }
}
