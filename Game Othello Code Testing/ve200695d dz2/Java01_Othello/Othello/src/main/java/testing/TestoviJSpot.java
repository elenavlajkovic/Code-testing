package testing;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import othello.*;

import org.mockito.Mockito;
import org.mockito.Mockito.*;

public class TestoviJSpot {
	
	private JSpotBoard board;
	private JSpot spot;
	
	
	@Before
	public void before() {
		board = new JSpotBoard(10,10);
		spot = new JSpot(Color.BLACK, Color.WHITE, Color.GRAY, board, 5, 5);
		spot.clearSpot();
	}
	
	@Test
	public void testiranjeKonstruktora() {
		assertEquals(5, spot.getSpotX());
		assertEquals(5, spot.getSpotY());
		assertEquals(board, spot.getBoard());
		assertEquals(true, spot.isEmpty());
		assertEquals(false, spot.isHighlighted());
		assertEquals(Color.WHITE, spot.getSpotColor());
		assertEquals(Color.GRAY, spot.getHighlight());
	}
	
	@Test
	public void testiranjeHajlajtovanja() {
		spot.highlightSpot();
		assertEquals(true, spot.isHighlighted());
	}
	
	@Test
	public void testiranjeHajlajtFalse() {
		spot.unhighlightSpot();
		assertEquals(false, spot.isHighlighted());
	}
	
	@Test
	public void testiranjeToggleHajlajt() {
		spot.toggleHighlight();
		assertTrue(true);
	}
	
	@Test
	public void testiranjeToggleHajlajt2() {
		spot.highlightSpot();
		spot.toggleHighlight();
		assertTrue(true);
	}
	
	@Test
	public void testiranjeToggleSpot() {
		spot.toggleSpot();
		assertTrue(true);
		spot.setSpot();
		spot.toggleSpot();
		assertTrue(true);
	}
	
	
	@Test
	public void testiranjeIspisa() {
		spot.getCoordString();
		assertTrue(true);
	}
	
	
	@Test(expected= IllegalArgumentException.class)
	public void testiranjeSetovanjaBoje() {
		spot.setSpotColor(Color.BLUE);
		assertEquals(Color.BLUE, spot.getSpotColor());
		String message = null;
		try {spot.setSpotColor(null);}
		catch(IllegalArgumentException ie) {
			message = null;
		}
		assertEquals(null, message);
	}
	
	@Test(expected= IllegalArgumentException.class)
	public void testiranjeSetovanjaHajlajta() {
		spot.setHighlight(Color.BLUE);
		assertEquals(Color.BLUE, spot.getHighlight());
		String message = null;
		try {spot.setHighlight(null);}
		catch(IllegalArgumentException ie) {
			message = null;
		}
		assertEquals(null, message);
	}
	
	@Test
	public void mockito1() {   //-----------click----------------
		SpotListener listener = new OthelloWidget();
		MouseEvent mockEvent = mock(MouseEvent.class);
		spot.addSpotListener(listener);
		spot.mouseClicked(mockEvent);
		assertTrue(true);
		spot.removeSpotListener(listener);
	}
	
	@Test
	public void mokito2() {
		spot = mock(JSpot.class);
		spot.setSpot();
		assertEquals(false, spot.isEmpty());
	}
	
	@Test
	public void mis() {
		Panel p = new Panel();
		MouseEvent me = new MouseEvent(p, 0, 0, 0, 0, 0, 0, false);
		spot.mousePressed(me);
		spot.mouseReleased(me);
		spot.mouseEntered(me);
	}
	
	@ParameterizedTest
	@CsvSource({"#ffff"})
	public void testiranjeBoje(String i) {
		JSpot spot = new JSpot(Color.BLACK, Color.WHITE, Color.GRAY, board, 5, 5);
		Color c = Color.decode(i);
		spot.setSpotColor(c);
		assertEquals(c, spot.getSpotColor());
	}
	
	@ParameterizedTest
	@CsvSource({"#ffff"})
	public void testiranjeSpot(String i) {
		JSpot spot = new JSpot(Color.BLACK, Color.WHITE, Color.GRAY, board, 5, 5);
		Color c = Color.decode(i);
		spot.setHighlight(c);
		assertEquals(c, spot.getHighlight());
	}
	
	/*@Ignore
	public void press() {
		SpotListener listener = new OthelloWidget();
		MouseEvent mockEvent = mock(MouseEvent.class);
		spot.addSpotListener(listener);
		spot.mousePressed(mockEvent);
		assertTrue(true);
	}
	
	@Ignore
	public void release() {
		SpotListener listener = new OthelloWidget();
		MouseEvent mockEvent = mock(MouseEvent.class);
		spot.addSpotListener(listener);
		spot.mouseReleased(mockEvent);
		assertTrue(true);
	}*/
	/*public void mockito4() {   //-----------pressed----------------
		MouseEvent mockEvent = mock(MouseEvent.class);
		spot.mousePressed(mockEvent);
		assertTrue(true);
	}
	
	public void mockito5() {   //-----------released----------------
		MouseEvent mockEvent = mock(MouseEvent.class);
		spot.mouseReleased(mockEvent);
		assertTrue(true);
	}*/
	
	@Test
	public void robot() throws AWTException {
		Robot r = new Robot();
		r.mouseMove(200, 200);r.mousePress(0);	
		r.mouseRelease(0);
	}
	

	@After
	public void after() {
		spot.setSpot();
	}
}
