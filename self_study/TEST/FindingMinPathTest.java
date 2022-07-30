import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dfs.FindingMinPath;

public class FindingMinPathTest {

	private FindingMinPath obj;

	@Before
	public void init() {
		obj = new FindingMinPath();
	}

	@Test
	public void findingMinPath_TEST1() {
		int[][] arr = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } };

		assertEquals(11, obj.solution(arr));
	}

	@Test
	public void findingMinPath_TEST2() {
		int[][] arr = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 } };

		assertEquals(-1, obj.solution(arr));
	}

}
