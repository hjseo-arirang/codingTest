package iteration;

public class Solution1 {
    public int solution(int n) {
        // write your code in Java SE 8
    	
    	String binaryString = Integer.toBinaryString(n);
    	int result = 0;
    	int gapLength = 0;
    	boolean isFlag = false;
    	for (char ch : binaryString.toCharArray()) {
    		if (ch == '1') {
    			if (isFlag) {
    				// binary gap end
    				isFlag = false;
    				result = result > gapLength ? result : gapLength;
    			} else {
    				// binary gap start
    				isFlag = true;
    				gapLength = 0;
    			}
    		} else { // ch == '0'
    			if (!isFlag) {
    				// 1000101...
    				isFlag = true;
    				gapLength = 0;
    			}
    			gapLength++;
    		}
    	}
    	
    	return result;
    }
}
