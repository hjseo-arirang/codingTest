package oddoccurrencesinarray;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
	public int solution(int[] A) {
		// write your code in Java SE 8
		List<Integer> list = new ArrayList<>();
		
		for (int num : A) {
			list.add(num);
		}
		
		list.sort((n1, n2) -> n1.compareTo(n2));
		
		int preValue = list.get(0);
		for (int index = 1 ; index < list.size() ; index++) {
			int currentValue = list.get(index);
			if (currentValue == preValue) {
			} else {
				if (index%2 == 1) {
					return preValue;
				}
			}
			preValue = currentValue;
		}

		return preValue;
	}
}
