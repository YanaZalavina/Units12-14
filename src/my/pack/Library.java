package my.pack;// пакеты, минимум 4 уровня

import java.util.*;
import java.io.*;

public class Library extends Book {
	public List<Book> books = new ArrayList<Book>();// атрибут доступа public , а не private

	public Library() {
	}

	public Library(List<Book> books) {
		this.books = books;
	}

	public void setBooks(Book book) {
		this.books.add(book);
	}

	public List<Book> getBooks() {
		return books;
	}
// решение защитано
	public void getListOfBooksFromFile(String filePath, String delimeterSymbol) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String currentLine = "";
		String[] subStr;
		while (currentLine != null) {
			currentLine = reader.readLine();
			if (currentLine != null) {
				subStr = currentLine.split(delimeterSymbol, 3);
				Book book = new Book(subStr[0].trim(), subStr[1].trim(), Integer.parseInt(subStr[2].toString().trim()));
				this.books.add(book);
			}
		}
	}

	public List<Book> searchByName(String nameOfBook) {
		List<Book> searchedBooks = new ArrayList<Book>();
		for (Book book : this.books) {
			if (book.getNameOfBook().compareToIgnoreCase(nameOfBook) == 0) {
				searchedBooks.add(book);
			}
		}
		if (searchedBooks.isEmpty()) {
			System.out.println("There are no books with name " + nameOfBook + " in Library");
		}
		return searchedBooks;
	}

	public List<Book> searchByAuthor(String author) {
		List<Book> searchedBooks = new ArrayList<Book>();
		for (Book book : this.books) {
			if (book.getAuthor().compareToIgnoreCase(author) == 0) {
				searchedBooks.add(book);
			}
		}
		if (searchedBooks.isEmpty()) {
			System.out.println("There are no books with author " + author + " in Library");
		}
	// решение защитано (уже не пишу юнит, т.к. защание объединяет 3 юнита)	
		searchedBooks.sort(Comparator.comparingInt(Book::getYearOfPublish));
//		Collections.sort(searchedBooks, new Comparator<Book>)() {
//			@Override
//			public int compare(Book firstBook, Book secondBook) {
//				int firstNameCompared;
//				int lastNameCompared
//				if (firstBook.getYearOfPublish()>secondBook.getYearOfPublish()) {
//					return lastNameCompared;
//				} else {
//					int firstNameCompared = c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
//					if (firstNameCompared != 0) {
//						return firstNameCompared;
//					} else {
//						return c1.getPatronymicName().compareToIgnoreCase(c2.getPatronymicName());
//					}
//			}
//		}
//		
		return searchedBooks;
	}

	public void deleteBookFromLibraryByName(String nameOfBook) {
		List<Book> booksForDelete = new ArrayList<Book>();
		List<Book> listOfBooksWithoutDeleted = new ArrayList<Book>();
		for (Book book : this.books) {
			if (book.getNameOfBook().compareToIgnoreCase(nameOfBook) == 0) {
				booksForDelete.add(book);
				// books.remove(book);
			} else {
				listOfBooksWithoutDeleted.add(book);
			}
		}
		this.books = listOfBooksWithoutDeleted;
		if (booksForDelete.isEmpty()) {
			System.out.println("There are no books with name " + nameOfBook + " in Library for deleting");
		} else {
			System.out.println("This boos were deleted:");
			for (Book book : booksForDelete) {
				System.out.println(book.toString());
			}
		}
	}

	public void deleteBookFromLibraryByAuthor(String author) {
		List<Book> booksForDelete = new ArrayList<Book>();
		for (Book book : this.books) {
			if (book.getAuthor().compareToIgnoreCase(author) == 0) {
				booksForDelete.add(book);
				books.remove(book);
			}
		}
		if (booksForDelete.isEmpty()) {
			System.out.println("There are no books with author " + author + " in Library for deleting");
		} else {
			System.out.println("This boos were deleted:");
			for (Book book : booksForDelete) {
				System.out.println(book.toString());
			}
		}
	}

	public static void main(String[] args) {

		Library library = new Library();

		try {
			library.getListOfBooksFromFile("src/resources/books.txt", ",");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// а вот про исключения пересмотри, ты гасишь исключение и дальше выполняешь код, как будто ничего не произошло
		}

		System.out.println("Full list of books: ");
		for (Book book : library.books) {
			System.out.println(book.toString());
		}

		System.out.println("Searched books with Name Harry Potter and the philosopher's stone: "
				+ library.searchByName("Harry Potter and the philosopher's stone").toString());
		System.out.println("Searched books with Name Stiven King: " + library.searchByName("Stiven King").toString());

		System.out.println(
				"Searched books with Author Joanne Rowling: " + library.searchByAuthor("Joanne Rowling").toString());
		System.out
				.println("Searched books with Author Stiven King: " + library.searchByAuthor("Stiven King").toString());

//		library.deleteBookFromLibraryByName("Harry Potter and the Half-Blood Prince");
//		library.deleteBookFromLibraryByAuthor("Stiven King");
//
//		System.out.println("List of books after deleting: ");
//		for (Book book : library.books) {
//			System.out.println(book.toString());
//		}

	}

}
