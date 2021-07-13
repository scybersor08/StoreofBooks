package in.Coder.bookstore.dao;
import java.util.List;

import in.Coder.bookstore.pojo.Book;
public interface Bookdao {
	public boolean insertBook(Book book);//book is object of class Book created in pojo
	public boolean updateBook(Book book);
	public boolean deleteBook(int bookId);//put datatype before giving variable as argument in methods
	public List<Book> getAllBoooks();
	public List<Book> getBookByName(String bookName);
	public List<Book> getBookByAuthorName(String authorName);
	public List<Book> getBookByPublisher(String publisher);
	public List<Book>getBookByBookCategory(String bookCategory);
	public Book getBookById(int bookId);
}

