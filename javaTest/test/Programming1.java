package test;

public class Programming1 {

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		sol.solution(id_list, report, k);

	}

}

