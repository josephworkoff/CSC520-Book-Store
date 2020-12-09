package main;


import java.util.ArrayList;

import catalog.Catalog;
import model.CatalogedBook;

public class main {

	public static void main(String[] args) {
		
//		catalog.Catalog.browseCatalog();
				
		startMenu();
	}
	
	
	private static void startMenu() {
		
		int opt;
		while (true) {
			System.out.println("Book Reservation System Main Menu");
			System.out.println("1) Search");
			System.out.println("2) Browse");
			System.out.println("3) Login");
			opt = display.Input.getIntOption(1, 3);
			
			switch (opt) {
			case 1:
				searchCatalogMenu();
				break;
			case 2: 
				viewCatalogMenu();
				break;
			case 3:
				accountMenu();
			default:
				break;
			}

		}
		
	}
	
	
	
	
	private static void accountMenu() {
		System.out.println("1) Account Details");
		System.out.println("2) Reservations");
		
		int opt;
		while (true) {
			opt = display.Input.getIntOption(1, 2);
			
			switch (opt) {
			case 1:
				System.out.println("Not yet implemented.");
				break;
			case 2: 
				viewReservationsMenu();
				break;		
			default:
				break;
			}
		}
	}


	private static void catalogMenu() {
		
		
		System.out.println("1) View Catalog");
		System.out.println("2) Search Catalog");
		
		int opt = display.Input.getIntOption(1, 2);
		
		switch (opt) {
		case 1:
			viewCatalogMenu();
			break;
		case 2: 
			searchCatalogMenu();
			break;
	
		default:
			break;
		}
	}


	
	private static void searchCatalogMenu() {
		
		String opt;
		ArrayList<String> queries = new ArrayList<String>();
		
		while (true) {
			System.out.println("Enter categories to search for.");
			System.out.println("'search' to search.");
			System.out.println("'back' to return to main menu");
			
			for (String s: queries) {
				System.out.print(String.format("\"%s\", ", s));
			}
			
			opt = display.Input.getStringInput("");
			if (opt.equalsIgnoreCase("search")) {
				ArrayList<CatalogedBook> results = Catalog.searchCatalog(queries);
				if ((results.size()) > 0){
					viewSearchMenu(results);
				}
				else {
					System.out.println("Found no matches.");
				}
				return;
			}
			else if (opt.equalsIgnoreCase("back")) {
				return;
			}
			else {
				queries.add(opt);
			}
		}
	}


	
	
	private static void viewCatalogMenu() {
		Catalog.displayCatalog(Catalog.CATALOG);
		
		int opt;
		while (true) {
			System.out.println("Choose a book to view, or -1 to return to main menu");
			opt = display.Input.getIntOption(-1, Catalog.CATALOG.size() - 1);
			
			if (opt == -1) {
				return;
			}
			else {
				Catalog.CATALOG.get(opt).viewDetails();
			}
		}
	}
	
	
	
	private static void viewSearchMenu(ArrayList<CatalogedBook> results) {
		int opt;
		while (true) {
			System.out.println("Choose a book to view, or -1 to return to main menu");
			opt = display.Input.getIntOption(-1, results.size() - 1);
			
			if (opt == -1) {
				return;
			}
			else {
				results.get(opt).viewDetails();
			}
		}
	}
	
	
	
	private static void viewReservationsMenu() {
		//Run menu
		
		CatalogedBook rsrv[] = new CatalogedBook[40];
		int choice;
		
        while(true) {
	        System.out.print("1.) Make Reservation \n");
	        System.out.print("2.) View Reservations \n");
	        System.out.print("3.) Cancel Reservation \n"); 
	
	        choice = display.Input.getIntOption(1, 3);

	        String usernameEntry = display.Input.getStringInput("Confirm username.");
	        
	        
	        switch(choice) {
	            
	             /*Make Reservation: 
	              Seq. Diagram steps:
	                1. User chooses make reservation
	                2. System asks for getUsername()
	                3. reserve() : no direction to choose what book, simply reserve one in catalog   
	                        
	                4. Reservation confirmed
	            */
	            case 1:
	                
	                
	                rsrv[0] = Catalog.CATALOG.get(0);
	                
	                System.out.println("Reservation made for " + usernameEntry);
	                break;
	            
	            
	            /*View Reservation: 
	              Seq. Diagram steps:
	                1. User chooses view reservation
	                2. Reservations for user displayed
	            */
	            case 2:
	                for(int i = 0; i < rsrv.length; i++)
	                    System.out.println(rsrv[i]);
	                break;
	            
	             /*Cancel Reservation: 
	              Seq. Diagram steps:
	                1. User chooses cancel 
	                2. free() : no direction to cancel specific book, zero first
	            */
	            case 3:
	            
	                rsrv[0] = null;
	                System.out.println("Cancellation completed for " + usernameEntry);
	                break;
	                
        	}
        }
	}
	
	
	
}
