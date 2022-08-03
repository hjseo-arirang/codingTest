package dfs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class NetworkConnection {

	public int solution(int n, int[][] computers) {
		LinkedHashMap<Integer, List<Integer>> networkMap = new LinkedHashMap<>();
		
		//init map
		int comIndex = 0;
		for (int[] targetComs : computers) {
			List<Integer> cs = new ArrayList<>();
			for (int index = 0; index < targetComs.length ; index++) {
				if (targetComs[index] == 1) {
					cs.add(index); // 연결된 컴퓨터 번호 넣어주기
				}
			}
			networkMap.put(comIndex, cs);
			comIndex++;
		}
		
		//bfs
		int[] history = new int[n];
		int count = 0;
		for (Entry<Integer, List<Integer>> entry : networkMap.entrySet()) {
			int c = entry.getKey();
			if (history[c] != 1) {
				count += search(history, networkMap, c);
			}
		}
		
		return count;
	}

	private int search(int[] history, LinkedHashMap<Integer, List<Integer>> networkMap, int c) {
		history[c] = 1;
		System.out.println("Searching... => " + c);
		List<Integer> targetComs = networkMap.get(c);
		
		int re = 1;
		for (int tc : targetComs) {
			if (history[tc] == 1) {
				// 이미 간 거임
				continue;
			} else {
				re *= search(history, networkMap, tc);
			}
		}
		
		return re;
	}

}
