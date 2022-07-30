package cyclicrotation;

public class Programming2 {

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		
		int[] arr = {3, 8, 9, 7, 6};
		int k = 3;
		
		int[] result = sol.solution(arr, k);

		System.out.println("result= " + result.toString());
	}

}
