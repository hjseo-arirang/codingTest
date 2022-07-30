import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dfs.DepthFirstTreeImp;

public class SolutionTEST {
	
	private DepthFirstTreeImp imp;

	@Before
	public void setUp() {
		imp = new DepthFirstTreeImp();
	}
	
	@Test
	public void test_dfs1() {
		int[] input = {1, 1, 1, 1, 1};
		int target = 3;
		
		int result = imp.solution(input, target);
		assertEquals("DFS example TEST1", 5, result);
	}
	
	@Test
	public void test_dfs2() {
		int[] input = {4, 1, 2, 1};
		int target = 4;
		
		int result = imp.solution(input, target);
		assertEquals("DFS example TEST2", 2, result);
	}


}
