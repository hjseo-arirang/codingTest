import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import dfs.VacationPath;

public class VacationPathTest {

	private VacationPath sol;
	
	@Before
	public void init() {
		sol = new VacationPath();
	}

	@Test
	public void test1() {
		String[][] input = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		
		String[] result = {"ICN", "JFK", "HND", "IAD"};
		
		assertArrayEquals(result, sol.solution(input));
	}
	
	@Test
	public void test2() {
		String[][] input = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		
		String[] result = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
		
		assertArrayEquals(result, sol.solution(input));
	}

}
