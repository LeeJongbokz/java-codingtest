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
