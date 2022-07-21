package cyclicrotation;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
    	
    	int arrLength = A.length;
    	
    	if (arrLength == 0) {
    		return A;
    	}
    	
    	int mod = K % arrLength;
    	List<Integer> newList = new ArrayList<>();
    	
    	for (int i = 0 ; i < arrLength ; i++) {
			if (i >= mod) {
				newList.add(A[i - mod]);
			} else {
				newList.add(A[arrLength - mod + i]);
    		}
    	}
    	return newList.stream().mapToInt(Integer::intValue).toArray();
    }
}
