package dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindingMinPath {
	
	private int maxX;
    private int maxY;

	/**
     * @param maps 0은 벽이 있는 자리, 1은 벽이 없는 자리
     * @return
     */
    public int solution(int[][] maps) {
        int x = 0; // 초기값
        int y = 0;
        
        maxX = maps.length;
        maxY = maps[0].length;
        
        Set<Integer> resultSet = new HashSet<>();
        int history[][] = new int[maxX][maxY];
        trackingPath(maps, resultSet, x, y, 1, history);
        
        if (resultSet.isEmpty()) {
        	return -1;
        } else {
        	return Collections.max(resultSet);
        }
    }

	private void trackingPath(int[][] maps, Set<Integer> resultSet, int x, int y, int totalPath, int[][] history) {
		
		if (resultSet.contains(totalPath)) {
			return;
		}
		
		if (x == maxX-1 && y == maxY-1) { // 종료 
			resultSet.add(totalPath);
		}
		
		int newHistory[][] = Arrays.copyOf(history, history.length);
		newHistory[x][y] = 1; // checked = true; 복..제? 해야 하나 
		
		// 다음 노드(자식)를 찾아서 자기 자신을 재귀 호출 
		// 아래 x, y+1
		if (isValidPath(maps, history, x, y+1)) {
			trackingPath(maps, resultSet, x, y+1, totalPath+1, newHistory);
		}
		
		// 오른쪽 x+1, y
		if (isValidPath(maps, history, x+1, y)) {
			trackingPath(maps, resultSet, x+1, y, totalPath+1, newHistory);
		}
		
		// 위 x, y-1
		if (isValidPath(maps, history, x, y-1)) {
			trackingPath(maps, resultSet, x, y-1, totalPath+1, newHistory);
		}
		
		// 왼쪽 x-1, y
		if (isValidPath(maps, history, x-1, y)) {
			trackingPath(maps, resultSet, x-1, y, totalPath+1, newHistory);
		}
		
	}

	private boolean isValidPath(int[][] map, int[][] history, int x, int y) {
		return x >= 0 && x < maxX && y >= 0 && y < maxY && map[x][y] != 0 && history[x][y] != 1;
	}
}
