package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.JoinServiceFactory;
import kr.ac.kopo.service.JoinService;
import kr.ac.kopo.vo.JoinVO;

public class SearchJoinAllUI extends BaseUI{

	private JoinService JoinService;
	
	public SearchJoinAllUI() {
//		JoinService = new JoinService();
		JoinService = JoinServiceFactory.getInstance();
	}
	
	@Override
	public void execute() throws Exception {
		List<JoinVO> JoinList = JoinService.selectAll();
		
		System.out.println("----------------------------------");
		System.out.println("NO\t아이디\t비밀번호\t가입일");
		System.out.println("----------------------------------");
		
		if(JoinList == null || JoinList.size() == 0) {
			System.out.println("\t게시글이 존재하지 않습니다");
		} else {
			for(JoinVO Join : JoinList) {
				System.out.println(Join.getNo()+"\t"
			                      +Join.getWriter()+"\t"
			                      +Join.getTitle()+"\t"
			                      +Join.getRegDate());
			}
		}
	}
	
}
