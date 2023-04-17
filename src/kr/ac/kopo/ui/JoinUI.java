package kr.ac.kopo.ui;

import kr.ac.kopo.JoinServiceFactory;
import kr.ac.kopo.service.JoinService;
import kr.ac.kopo.vo.JoinVO;

public class JoinUI extends BaseUI{

	private JoinService joinService;

	public JoinUI() {
		joinService = JoinServiceFactory.getInstance();
	}

	@Override
	public void execute() throws Exception {
		
		String title = scanStr("등록할 ID을 입력하세요 : ");
		String writer = scanStr("등록할 Password를 입력하세요 : ");
		
		JoinVO join = new JoinVO();
		join.setTitle(title);
		join.setWriter(writer);
		
		joinService.insertJoin(join);
		
		System.out.println("가입을 완료하였습니다");
	}
}
