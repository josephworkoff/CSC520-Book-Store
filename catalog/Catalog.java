package catalog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.CatalogedBook;

public class Catalog {
	
	public static final String BOOKS_PATH = "src/Book Catalog.csv";
	public static final ArrayList<CatalogedBook> CATALOG = browseCatalog();
	
	
	
	public static ArrayList<CatalogedBook> browseCatalog(){
		
		ArrayList<CatalogedBook> catalog = new ArrayList<CatalogedBook>();
		BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader(BOOKS_PATH));
			String line;
			csvReader.readLine();
			while ((line = csvReader.readLine()) != null) {
				catalog.add(parseBook(line));
			}
			csvReader.close();
						
		} catch (IOException e1) {
			System.out.println("Error while reading CSV file.");
			e1.printStackTrace();
			System.exit(0);
		}
		
		return catalog;
	}

	
	
	public static void displayCatalog(ArrayList<CatalogedBook> catalog) {
		int num = 0;
		System.out.println("Catalog:\n");
		for (CatalogedBook b: catalog) {
			if (b.isAvailable())
				System.out.println(String.format("%d) %s: %s by %s", num, b.getIsbn13(), b.getTitle(), b.getAuthor()));
			num++;
		}
	}
	
	
	
	private static CatalogedBook parseBook(String line) {
		String[] res = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		
		String isbn13 		= res[0];
		String title        = res[1];
		String author       = res[2];
		String description  = res[3];
		String category     = res[4];
		String location     = res[5];
		String status       = res[6];
		
		return new CatalogedBook(isbn13, title, author, description, category, location, status);
	}
	
	
	
	public static ArrayList<CatalogedBook> searchCatalog(ArrayList<String> categories){
		ArrayList<CatalogedBook> results = new ArrayList<CatalogedBook>();
		
		for (CatalogedBook b: CATALOG) {
			for (String s: categories) {
				if (b.getCategory().toLowerCase().contains(s)) {
					results.add(b);
				}
			}
		}
		
			
		displayCatalog(results);
		
		return results;
	}
	
	

	
}
