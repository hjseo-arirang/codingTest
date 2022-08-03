import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import search.CarpetSolution;

public class CarpetSolutionTest {
	
	private CarpetSolution sol;
	
	@Before
	public void init() {
		sol = new CarpetSolution();
	}

	@Test
	public void test() {
		int[] result1 = {4, 3};
		int[] result2 = {3, 3};
		int[] result3 = {8, 6};
		
		int[] sol1 = sol.solution(10, 2);
		int[] sol2 = sol.solution(8, 1);
		int[] sol3 = sol.solution(24, 24);
		System.err.println("testcase1:" + sol1[0] + "," + sol1[1]);
		System.err.println("testcase2:" + sol2[0] + "," + sol2[1]);
		System.err.println("testcase3:" + sol3[0] + "," + sol3[1]);
		
		assertArrayEquals(result1, sol1);
		assertArrayEquals(result2, sol2); 
		assertArrayEquals(result3, sol3); 
	}

}
