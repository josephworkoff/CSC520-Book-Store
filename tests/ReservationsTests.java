package tests;

import static org.junit.jupiter.api.Assertions.*;

import model.*;

import org.junit.jupiter.api.Test;

class ReservationsTests {

	
	@Test
	void makeReservationTest() {
		
		CatalogedBook[] books = new CatalogedBook[5];
		
		for (int i = 0; i < 5; i++) {
			books[i] = new CatalogedBook();
			books[i].setStatus("available");
		}
		
		books[3].setStatus("reserved");
		
		try {
			assertEquals(books[0].isAvailable(), true);
			assertEquals(books[1].isAvailable(), true);
			assertEquals(books[2].isAvailable(), true);
			assertEquals(books[3].isAvailable(), false);
			assertEquals(books[4].isAvailable(), true);
			
				
		}
		catch (Exception ex) {
			fail("Failed n Test" + ex.getMessage());			
		}
	}
	
	
	@Test
	void cancelReservationTest() {
		CatalogedBook[] books = new CatalogedBook[5];
		
		for (int i = 0; i < 5; i++) {
			books[i] = new CatalogedBook();
			books[i].setStatus("reserved");
		}
		
		books[0].free();
		
		assertEquals(books[0].isAvailable(), true);
		assertEquals(books[1].isAvailable(), false);
		
	}

}
