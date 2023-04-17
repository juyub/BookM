package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.BookServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class SearchBookAllUI extends BaseUI{

	private BookService BookService;
	
	public SearchBookAllUI() {
//		BookService = new BookService();
		BookService = BookServiceFactory.getInstance();
	}
	
	@Override
	public void execute() throws Exception {
		List<BookVO> BookList = BookService.selectAll();
		
		System.out.println("----------------------------------");
		System.out.println("NO\t글쓴이\t등록일\t제목");
		System.out.println("----------------------------------");
		
		if(BookList == null || BookList.size() == 0) {
			System.out.println("\t게시글이 존재하지 않습니다");
		} else {
			for(BookVO Book : BookList) {
				System.out.println(Book.getNo()+"\t"
			                      +Book.getWriter()+"\t"
						          +Book.getRegDate()+"\t"
			                      +Book.getTitle());
			}
		}
	}
	
}
