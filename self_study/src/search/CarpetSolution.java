package search;

public class CarpetSolution {
	
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int xPlusY = (brown-4)/2;
        
        for (int index = 1; index <= xPlusY/2 ; index++) {
        	int y = index;
        	int x = xPlusY - y;
        	
        	if (x * y == yellow) {
        		answer[0] = x + 2;
        		answer[1] = y + 2;
        		break;
        	}
        }

        return answer;
        
        //가상의 x가 있고, 가로길이 y는 세로길이 x>=y
        //x*y = yellow
        //2x + 2y + 4 = brown
        // x + y = brown/2 -2
        // y = brown/2 - 2 - x
        // x(brown/2 - 2 - x) = yellow
        // 
    }
}
