package fifthtest;

import java.util.HashMap;
import java.util.Map;

public class Solution5 {
	
	class  Node {
		public int current;
		public int left;
		public int right;
		
		public Node(int current, int left, int right) {
			this.current = current;
			this.left = left;
			this.right = right;
		}
	}
	
	class Result {
		public int maxSheep;
		public int maxWolf;
		
		public Result() {
			this.maxSheep = 1;
			this.maxWolf = 0;
		}
	}
	
    public int solution(int[] info, int[][] edges) {
        Map<Integer, Node> tree = new HashMap<>(); // current ��� ��ȣ��... current �ڱ� �ڽ��� ����, left ��� ��ȣ right ��� ��ȣ 
        
        int index = 0;
        for (int kind : info) {
        	int left = -1; // ���ٴ� �� 
        	int right = -1;
        	for (int[] arr : edges) {
        		if (arr[0] == index) {
        			if (left == -1) {
        				left = arr[1]; 
        			} else {
        				right = arr[1];
        			}
        		}
        	}
        	Node node = new Node(kind, left, right);
        	tree.put(index, node);
        	index++;
        }
        
        
        Result maxSheep = getMaxSheep(new Result(), 0, info, tree);
		return maxSheep.maxSheep+1;
    }
    
    private Result getMaxSheep(Result result, int currentNode, int[] info, Map<Integer, Node> tree) {
    	int currentSheep = result.maxSheep;
    	int currentWolf = result.maxWolf;
    	
    	Result currentResult = new Result();
    	currentResult.maxSheep = currentSheep;
    	currentResult.maxWolf = currentWolf;
    			
    	if (currentSheep == currentWolf) {
    		return currentResult;
    	}
    	
    	Node node = tree.get(currentNode);
    	int kind = node.current;
    	int leftNodeNum = node.left;
    	int rightNodeNum = node.right;
    	
    	Result postResult = currentResult;
    	Result tempResult = new Result();
    	tempResult.maxSheep = currentResult.maxSheep;
    	tempResult.maxWolf = currentResult.maxWolf;
    	
    	if (leftNodeNum == -1 && rightNodeNum == -1) {
    		if (kind == 0) {
    			tempResult.maxSheep += 1;
    			return tempResult;
    		} else {
    			return tempResult;
    		}
    	} else {
    		// ����->������ ã��
			if (leftNodeNum != -1) {
				if (info[leftNodeNum] == 0) {
					// ������ ���� ���
					tempResult.maxSheep += 1;
					tempResult = getMaxSheep(tempResult, leftNodeNum, info, tree);
				} else {
					// ������ ������ ���
					tempResult.maxWolf += 1;
					tempResult = getMaxSheep(tempResult, leftNodeNum, info, tree);

					if (tempResult.maxSheep == currentResult.maxSheep) {
						tempResult = currentResult;
					}
				}
			}
			
			if (rightNodeNum != -1) {
				if (info[rightNodeNum] == 0) {
					// �������� ���� ���
					tempResult.maxSheep += 1;
					postResult = getMaxSheep(tempResult, rightNodeNum, info, tree);
				} else {
					// �������� ������ ��� 
					tempResult.maxWolf += 1;
					postResult = getMaxSheep(tempResult, rightNodeNum, info, tree);
				}
			}
    		
    		// ������->���� ã�� 
    	}
    	
    	
    	return postResult;
    }
}
