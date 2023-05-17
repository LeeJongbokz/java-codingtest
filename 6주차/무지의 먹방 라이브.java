// 왜 맞았는가?
// 1. 


import java.util.*; 


// Food 클래스를 선언해주고, time과 idx를 변수로 선언한다.
// 이 때, compareTo 메소드를 오버라이딩해주고, 시간이 작은 순으로 정렬되도록 한다.
// 이렇게 함으로써, PriorityQueue에 저장할 때, 시간이 적은 순으로 저장되도록 할 수 있다. 
class Food implements Comparable<Food>{
    
    int time;
    int idx;
    
    public Food(int time, int idx){
        this.time = time;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Food other){
        return this.time-other.time; 
    }
    
    
}


class Solution {
    public int solution(int[] food_times, long k) {
        
        // food_time이라는 변수를 long 자료형으로 선언한다. 
        long food_time = 0;
        
        // food_time에 전체 합을 더해준다. 
        for(int i=0; i<food_times.length; i++){
            food_time += food_times[i];
        }
        
        // food_time이 k보다 작거나 같다면, -1을 리턴한다.
        // 왜냐하면 더 이상 섭취할 음식이 없어지기 때문이다. 
        if(food_time <= k) return -1;
        
        // 우선순위 큐 pq를 선언한다. 
        PriorityQueue<Food> pq = new PriorityQueue<>();
        
        // pq에 음식들을 담는다.
        // 이 때, 시간을 앞에, 인덱스를 뒤에 선언해서 담는다. 
        for(int i=0; i<food_times.length; i++){
            pq.offer(new Food(food_times[i], i+1));
        }
        
        // 전체 시간 total, 이전 것의 시간 previous, 전체 길이 length를 
        // long 변수로 선언한다. 
        long total = 0;
        long previous = 0;
        long length = food_times.length;
        
      
        // 전체 시간이 k보다 작거나 같을 때,
        // 단, 현재 단계의 시간과 이전 단계의 시간의 차이에 length를 곱한 것을 더했을 때,
        // 이렇게 되는 이유는, 이만큼 반복될 때마다, 하나씩 0이 된다고 생각한 것이다. 
        // 그리고 그 값들을 total에 더해주고, length는 단계마다 1씩 줄여준다. 
        while(total + (pq.peek().time-previous)*length <= k){
            int now = pq.poll().time;
            total += (now-previous)*length;
            length--;
            previous = now; 
        }
        
        // result라는 ArrayList를 선언해주는데, 이것은 
        // pq에 있는 Food들을 idx 순으로 정렬하기 위한 것이다. 
        ArrayList<Food> result = new ArrayList<>(); 
        
        // pq에 있는 Food들을 result에 옮겨준다. 
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        
        // idx 순으로 Food들을 정렬한다.
        // 이 때, Comparator 인터페이스, 그리고 compare 메소드를 사용하고,
        // 2개의 매개변수를 전달함을 잘 숙지하자. 
        Collections.sort(result, new Comparator<Food>(){
            @Override
            public int compare(Food a, Food b){
                return Integer.compare(a.idx, b.idx);
            }
        });
        
        // 최종적으로, k-total, 즉, 남은만큼의 길이를 length로 순회하고,
        // 해당 위치의 idx를 결과값으로 출력한다. 
        return result.get((int)((k-total)%length)).idx; 
    }
}
