package kr.ac.kopo.ui;

import kr.ac.kopo.BookServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class AddUI extends BaseUI {

	private BookService bookService;
	
	public AddUI() {
		bookService = BookServiceFactory.getInstance();
	}
	
	@Override
	public void execute() throws Exception {
		
		String title = scanStr("등록할 제목을 입력하세요 : ");
		String writer = scanStr("글쓴이를 입력하세요 : ");
		
		BookVO book = new BookVO();
		book.setTitle(title);
		book.setWriter(writer);
		
		bookService.insertBook(book);
		
		System.out.println("새글 등록을 완료하였습니다");
	}

}
