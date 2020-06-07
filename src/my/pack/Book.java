package my.pack;

public class Book {
	private String nameOfBook;
	private String author;
	private int yearOfPublish;
	private long id;
	private static long lastId = 0;
	
	public Book() {}
	
	public Book(String nameOfBook, String author,int yearOfPublish) {
		this.author=author;
		this.nameOfBook=nameOfBook;
		this.yearOfPublish=yearOfPublish;
		this.id = ++lastId;
	}

	public String getNameOfBook() {
		return nameOfBook;
	}

	public void setNameOfBook(String nameOfBook) {
		this.nameOfBook = nameOfBook;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearOfPublish() {
		return yearOfPublish;
	}

	public void setYearOfPublish(int yearOfPublish) {
		this.yearOfPublish = yearOfPublish;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Book [nameOfBook=" + nameOfBook + ", author=" + author + ", yearOfPublish=" + yearOfPublish + "]";
	}

}
