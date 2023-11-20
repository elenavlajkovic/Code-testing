package testing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.awt.Color;

import org.junit.*;
import othello.*;

public class TestoviJBoard {
	
	private JSpotBoard board;
	
	@Before
	public void before() {
		board = null;
	}
	
	// ---------------------------- konstruktor 1 ----------------------------------
	
	@Test 
	public void testiranjeKonstruktora1Exception() {
		String message = null;
		try { board = new JSpotBoard(0,10); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}

	@Test
	public void testiranjeKonstruktora1() {   
		JSpotBoard board = new JSpotBoard(10,10);
		for(int i = 0; i < board.getSpotWidth(); i++) {
			for(int j = 0; j < board.getSpotHeight(); j++) {
				assertTrue(board.getSpotAt(i, j) instanceof Spot);
			}
		}		
	}
	
	@Test
	public void testiranjeKonstruktora1Exception2() {
		String message = null;
		try { board = new JSpotBoard(10,0); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}
	
	@Test
	public void testiranjeKonstruktora1Exception3() {
		String message = null;
		try { board = new JSpotBoard(51,10); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}
	
	@Test
	public void testiranjeKonstruktora1Exception4() {
		String message = null;
		try { board = new JSpotBoard(10,51); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}
	
	
	// ---------------------------- konstruktor 2 ----------------------------------
	
	
	@Test
	public void testiranjeKonstruktora2() {
		JSpotBoard board = new JSpotBoard(10,10, Color.BLACK, Color.WHITE);
		for(int i = 0; i < board.getSpotWidth(); i++) {
			for(int j = 0; j < board.getSpotHeight(); j++) {
				assertTrue(board.getSpotAt(i, j) instanceof Spot);
			}
		}		
	}
	
	@Test
	public void testiranjeKonstruktora2Exception() {
		String message = null;
		try { board = new JSpotBoard(0,10, Color.BLACK, Color.WHITE); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}
	
	@Test
	public void testiranjeKonstruktora2Exception2() {
		String message = null;
		try { board = new JSpotBoard(10,0, Color.BLACK, Color.WHITE); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}
	
	@Test
	public void testiranjeKonstruktora2Exception3() {
		String message = null;
		try { board = new JSpotBoard(51,10, Color.BLACK, Color.WHITE); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}
	
	@Test
	public void testiranjeKonstruktora2Exception4() {
		String message = null;
		try { board = new JSpotBoard(10,51, Color.BLACK, Color.WHITE); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}

	
	
	// ---------------------------- konstruktor 3 ----------------------------------
	
	
	@Test
	public void testiranjeKonstruktora3() {
		JSpotBoard board = new JSpotBoard(10,10,Color.BLACK);
		for(int i = 0; i < board.getSpotWidth(); i++) {
			for(int j = 0; j < board.getSpotHeight(); j++) {
				assertTrue(board.getSpotAt(i, j) instanceof Spot);
			}
		}	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testiranjeKonstruktora3Exception() {
		String message = null;
		try { board = new JSpotBoard(0,10, Color.BLACK); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testiranjeKonstruktora3Exception2() {
		String message = null;
		try { board = new JSpotBoard(10,0, Color.BLACK); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testiranjeKonstruktora3Exception3() {
		String message = null;
		try { board = new JSpotBoard(51,10, Color.BLACK); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testiranjeKonstruktora3Exception4() {
		String message = null;
		try { board = new JSpotBoard(10,51, Color.BLACK); }
		catch(IllegalArgumentException ie) {	
			message = "Illegal spot board geometry";
		}
		finally {assertEquals("Illegal spot board geometry", message);	}
	}
	
	@Test
	public void testiranjeListeneraDodaj() {
		SpotListener listener = new OthelloWidget();
		JSpotBoard board = new JSpotBoard(10,10,Color.BLACK);
		board.addSpotListener(listener);
		assertTrue(true);
	}
	
	@Test
	public void testiranjeListeneraUkloni() {
		SpotListener listener = new OthelloWidget();
		JSpotBoard board = new JSpotBoard(10,10,Color.BLACK);
		board.removeSpotListener(listener);
		assertTrue(true);
	}
	
	@Test
	public void testiranjeSpotAt() {
		String message = null;
		try {board.getSpotAt(-1, 3);}
		catch(IllegalArgumentException ie) {
			message = "Illegal spot coordinates";
		} finally {
			assertEquals("Illegal spot coordinates", message);
		}
	}
	
}
