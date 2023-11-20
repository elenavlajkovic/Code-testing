package testing;
import othello.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.*;

public class TestoviOthelloGame {
	@Test
	public void mokito() {
		OthelloGame game = mock(OthelloGame.class);
		game.main(null);
		assertTrue(game instanceof OthelloGame);
	}
	
}
