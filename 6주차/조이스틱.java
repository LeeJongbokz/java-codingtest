// 왜 맞았는가?
// 1. 위아래로 움직이는 것에 대해서 Math.min으로 잘 케이스를 나타냈다.
// 2. 옆으로 움직이는 것에 대해서 move라는 변수를 썼고, index라는 변수를 잘 활용해서,
//    최소로 움직이는 경우를 구하고자 했다. 
// -> 이를 for문 하나로 나타낼 수 있음에 유의하고, length와 index를 어떻게 나타냈는지를 유의한다.
// -> 또한, A가 연속으로 나타나는 경우를 어떻게 다루었는지에 유의한다. 

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int length = name.length();
        int move = length-1; 
        int index = 0; 
        
        for(int i=0; i<name.length(); i++){
            answer += Math.min(name.charAt(i)-'A', 'Z'+1-name.charAt(i));
            
            index = i+1;
            
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }
            
            move = Math.min(move, 2*i+(length-index));
            move = Math.min(move, 2*(length-index)+i);
        }
        
        return answer+move;
    }
}
