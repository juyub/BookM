package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BookDAO;
import kr.ac.kopo.vo.BookVO;

public class BookService {

	private BookDAO bookDao;
	
	public BookService() {
		bookDao = new BookDAO();
	}
	
	public void insertBook(BookVO book) {
	
		bookDao.insertBook(book);
	}
	
	public List<BookVO> selectAll(){
		List<BookVO> bookList = bookDao.selectAllBook();	
		return bookList;
	}
	
	public BookVO selectByNo(int bookNo) {
	
		BookVO book = bookDao.selectBookByNo(bookNo);
		return book;
	}
}
