package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class FindingMinPath {
	
	class BFSNode {
		private int x;
		private int y;
		private int currentPathLength;
		
		public BFSNode(int x, int y, int currentPathLength) {
			this.x = x;
			this.y = y;
			this.currentPathLength = currentPathLength;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getCurrentPathLength() {
			return currentPathLength;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void setCurrentPathLength(int currentPathLength) {
			this.currentPathLength = currentPathLength;
		}
		
	}
	
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

		int history[][] = new int[maxX][maxY];
		return bfsTracking(maps, x, y, history);
	}

    private int bfsTracking(int[][] maps, int x, int y, int[][] history) {
    	Queue<BFSNode> historyQueue = new LinkedList<>();
		
		// 거쳐갔다는 표시
    	history[x][y] = 1; // checked = true; 
    	BFSNode currentPos = new BFSNode(x, y, 1);
		historyQueue.add(currentPos); 
		
		// 자식 노드들 다 돌면서 검사
		while (!historyQueue.isEmpty()) {
			
			BFSNode node = historyQueue.poll();
			x = node.getX();
			y = node.getY();
			
			if (maps[x][y] == 0) {
				continue;
			}
			
			if (history[x][y] == 1) {
				continue;
			}
			
			int currentPathLength = node.getCurrentPathLength();
			System.out.println("(x,y): " + x + ", " + y);
            
			if (x == maxX-1 && y == maxY-1) { // 종료 
				return currentPathLength;
			}
			
			if (isValidPath(maps, history, x, y+1)) {
				history[x][y+1] = 1;
				historyQueue.add(new BFSNode(x, y+1, currentPathLength+1)); 
			}
			
			// 오른쪽 x+1, y
			if (isValidPath(maps, history, x+1, y)) {
				history[x+1][y] = 1;
				historyQueue.add(new BFSNode(x+1, y, currentPathLength+1));
			}
			
			// 위 x, y-1
			if (isValidPath(maps, history, x, y-1)) {
				history[x][y-1] = 1;
				historyQueue.add(new BFSNode(x, y-1, currentPathLength+1));
			}
			
			// 왼쪽 x-1, y
			if (isValidPath(maps, history, x-1, y)) {
				history[x-1][y] = 1;
				historyQueue.add(new BFSNode(x-1, y, currentPathLength+1));
			}
		}
		
		return -1;
    }

	private boolean isValidPath(int[][] map, int[][] history, int x, int y) {
		return x >= 0 && x < maxX && y >= 0 && y < maxY && !(map[x][y] == 0 || history[x][y] == 1);
	}
}
