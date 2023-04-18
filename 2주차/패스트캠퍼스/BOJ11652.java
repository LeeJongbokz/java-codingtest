// 제목: 카드
// 2sol

// 왜 맞았는가?
// 1) HashMap은 Key의 입력 순서를 보장하지 않는다.
// -> 하지만 TreeMap은 Key를 정렬한 상태로 저장하므로, 이 문제의 경우는 TreeMap을 사용하는 것이 좋다
// 2) TreeMap에 입력한 후에, value를 기준으로 한 번 내림차순 정렬을 해주면 된다
// 3) Long 자료형을 사용해야 한다는 점에 유의해야 한다. 값의 범위 때문에 
// 4) 내림차순 정렬 식을 외워놓아야 할 수 있다. 검색이 안되는 경우를 대비해서. 

import java.util.*; 
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		
		long ans = Long.MIN_VALUE; 
		
		Map<Long, Integer> map = new TreeMap<Long, Integer>();

        for(int i=0; i<N; i++){
            long num = sc.nextLong();
             map.put(num, map.getOrDefault(num, 0)+1);
        }
		
		
		// Map.Entry 리스트 작성
		List<Entry<Long, Integer>> list_entries = new ArrayList<Entry<Long, Integer>>(map.entrySet());

		// 비교함수 Comparator를 사용하여 내림 차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<Long, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<Long, Integer> obj1, Entry<Long, Integer> obj2)
			{
				// 내림 차순으로 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

		// 결과 출력
		for(Entry<Long, Integer> entry : list_entries) {
		    ans = entry.getKey();
		    break; 
		}
		
		System.out.println(ans); 
	}

}
