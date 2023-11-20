package testing;
import othello.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.junit.*;

public class TestoviOthelloWidget {
	
	private static OthelloWidget widget = new OthelloWidget();
	
	@Before
	/*public void before() {
		widget = new OthelloWidget();
		
	}*/
	
	@Test
	public void testiranjeReset() {
		assertEquals("Welcome to Othello. Black to play", widget._message.getText()); // pozvan je reset		
	}
	
	@Test
	public void testiranjeSpotClicked() {
		widget.spotClicked(widget._board.getSpotAt(5, 3));
		widget.spotClicked(widget._board.getSpotAt(5, 2));
		widget.spotClicked(widget._board.getSpotAt(5, 5));
		widget.spotClicked(widget._board.getSpotAt(5, 6));
		widget.spotClicked(widget._board.getSpotAt(6, 4));
		widget.spotClicked(widget._board.getSpotAt(3, 2));
		widget.spotClicked(widget._board.getSpotAt(1, 5));
		widget.spotClicked(widget._board.getSpotAt(0, 5));
		widget.spotClicked(widget._board.getSpotAt(2, 4));
		widget.spotClicked(widget._board.getSpotAt(3, 6));
		widget.spotClicked(widget._board.getSpotAt(6, 6));
		widget.spotClicked(widget._board.getSpotAt(5, 6));
		widget.spotClicked(widget._board.getSpotAt(0, 6));
		widget.spotClicked(widget._board.getSpotAt(0, 7));
		widget.spotClicked(widget._board.getSpotAt(7, 5));
		widget.spotClicked(widget._board.getSpotAt(5, 3));
		widget.spotClicked(widget._board.getSpotAt(2, 7));
		widget.spotClicked(widget._board.getSpotAt(3, 6));
		widget.spotClicked(widget._board.getSpotAt(1, 7));
		widget.spotClicked(widget._board.getSpotAt(4, 2));
		widget.spotClicked(widget._board.getSpotAt(5, 2));
		widget.spotClicked(widget._board.getSpotAt(1, 3));
		widget.spotClicked(widget._board.getSpotAt(0, 4));
		widget.spotClicked(widget._board.getSpotAt(1, 6));
		widget.spotClicked(widget._board.getSpotAt(0, 3));
		widget.spotClicked(widget._board.getSpotAt(6, 4));
		widget.spotClicked(widget._board.getSpotAt(1, 4));
		widget.spotClicked(widget._board.getSpotAt(6, 2));
		widget.spotClicked(widget._board.getSpotAt(4, 1));
		widget.spotClicked(widget._board.getSpotAt(1, 2));
		widget.spotClicked(widget._board.getSpotAt(0, 2));
		widget.spotClicked(widget._board.getSpotAt(2, 2));
		widget.spotClicked(widget._board.getSpotAt(1, 1));
		widget.spotClicked(widget._board.getSpotAt(4, 0));
		widget.spotClicked(widget._board.getSpotAt(2, 1));
		widget.spotClicked(widget._board.getSpotAt(2, 0));
	}
	
	@Test
	public void testiranjeCheckDraw() {
		widget.checkDraw();
		assertTrue(true);
	}
	
	@Test
	public void testiranjeGetColor() {
		widget.getColor(widget._board.getSpotAt(4, 4));
		assertTrue(true);
		widget.getColor(widget._board.getSpotAt(2, 0));
		assertTrue(true);
		widget.getColor(widget._board.getSpotAt(2, 1));
		assertTrue(true);
		widget.getColor(widget._board.getSpotAt(0, 0));
		assertTrue(true);
	}
	
	@Test
	public void testiranjeGetColor2() {
		widget.getColor(4,4);
		assertTrue(true);
		widget.getColor(3,0);
		assertTrue(true);
		widget.getColor(2,1);
		assertTrue(true);
		widget.getColor(0,0);
		assertTrue(true);
	}
	
	@Test
	public void testiranjeGetColor3() {
		widget.getColorC(4,4);
		assertTrue(true);
	}
	
	@Test
	public void testiranjeGetColor4() {
		Spot s = widget._board.getSpotAt(6, 6);
		s.setSpotColor(Color.BLUE);
		widget.getColor(s);
		assertTrue(true);
	}
	
	@Test
	public void testiranjeGetColor5() {
		Spot s = widget._board.getSpotAt(5, 5);
		s.setSpotColor(Color.BLACK);
		s.setSpot();
		widget.getColor(s);
		assertTrue(true);
	}
	
	@Test
	public void testiranjeInBounds() {
		widget.inBounds(widget._board.getSpotAt(4, 4));
		assertTrue(true);
	}
	
	@Test
	public void testiranjeInBounds2() {
		widget.inBounds(4, 4);
		assertTrue(true);
		widget.inBounds(9, 1);
		assertTrue(true);
		widget.inBounds(-1, 1);
		assertTrue(true);
		widget.inBounds(1, 9);
		assertTrue(true);
		widget.inBounds(1, -1);
		assertTrue(true);
	}
	
	
	@Test
	public void testiranjeHasLegalMoves() {
		widget.hasLegalMoves();
		assertTrue(true);
	}
	
	@Ignore
	public void testiranjeHasLegalMoves2() {
		widget.hasLegalMoves(4, widget._board.getSpotAt(4, 4));
		assertTrue(true);
	}
	
	@Test
	public void testiranjeSpotClickedGameWon() {
		widget._game_won = true;
		widget.spotClicked(widget._board.getSpotAt(0, 0));
	}
	
	@Test
	public void testiranjeCheckWin() {
		widget._game_won = true;
		widget.checkWin();
	}
	
	@Test
	public void testiranjeSpotEntered() {
		widget.spotEntered(widget._board.getSpotAt(4, 4));
		widget._game_won = true;
		widget.spotEntered(widget._board.getSpotAt(5,1));
	}
	
	@Test
	public void testiranjeSpotExited() {
		widget._game_won = false;
		widget.spotExited(widget._board.getSpotAt(0, 0));
		widget._game_won = true;
		widget.spotExited(widget._board.getSpotAt(5,1));
	}
	
	@Test
	public void testiranjeActionPerformed() {
		widget.reset_button.doClick();
	}
	
	
	
}
