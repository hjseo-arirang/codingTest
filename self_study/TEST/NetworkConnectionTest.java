import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dfs.NetworkConnection;

public class NetworkConnectionTest {

	private NetworkConnection con;
	
	@Before 
	public void init() {
		con = new NetworkConnection();
	}
	
	@Test
	public void test1() {
		int n = 3;
		int[][] input = {{1,1,0}, {1,1,0}, {0,0,1}};
		
		assertEquals(2, con.solution(n, input));
	}
	
	@Test
	public void test2() {
		int n = 3;
		int[][] input = {{1,1,0}, {1,1,1}, {0,1,1}};
		
		assertEquals(1, con.solution(n, input));
	}

}
