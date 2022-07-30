package dfs;

public class DepthFirstTreeImp {
	public int solution(int[] numbers, int target) {
		return search(numbers, target, -1, 0);
	}

	private int search(int[] numbers, int target, int i, int total) {
		
		int count = 0;
		//checked true 구현 어떻게 하지
		if (i == numbers.length-1) {
			if (total == target) { // 일치하는 경우, 카운트한다 
				return 1;
			} else { // 일치하지 않는 경우
				return 0;
			}
		} else {
			
			int child = numbers[i+1];
			// 양수
			count += search(numbers, target, i+1, total + child);
			// 음수
			count += search(numbers, target, i+1, total - child);
		}
		
		return count;
	}
}
