package fifthtest;


public class Programming5 {
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		int[] info = {0,1,0,1,1,0,1,0,0,1,0};
		int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
		sol.solution(info, edges);
	}
}
