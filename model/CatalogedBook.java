package model;

public class CatalogedBook {
//isbn13,Title ,Author,Description,Category,Location,Status
	String isbn13;
	String title;
	String author;
	String description;
	String category;
	String location;
	String status;
	
	
	public CatalogedBook() {
		this.isbn13         = "";
		this.title          = "";
		this.author         = "";
		this.description    = "";
		this.category       = "";
		this.location       = "";
		this.status         = "";
	}
	
	
	public CatalogedBook(String isbn13, String title, String author, String description, String category, String location,
			String status) {
		
		this.isbn13 = isbn13;
		this.title = title;
		this.author = author;
		this.description = description;
		this.category = category;
		this.location = location;
		this.status = status;
	}


	public String getIsbn13() {
		return isbn13;
	}


	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getDesc() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Boolean isAvailable() {
		return this.status.equals("available");
	}
	
	
	
	public void free() {
		if (this.status.equalsIgnoreCase("reserved")) {
			this.status = "available";
		}
	}
	
	
	
	public boolean getDescription() {
		this.returnDetails();
		return this.isAvailable();
	}
	
	
	public void viewDetails() {
		this.returnDetails();
	}
	
	
	public void returnDetails() {
		System.out.println("Details about: " + this.getTitle());
		System.out.println(this.getDesc());
		System.out.println("Category: " + this.getCategory());
		System.out.println("Location: " + this.getLocation());
	}
	
}
