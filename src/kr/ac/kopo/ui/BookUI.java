package kr.ac.kopo.ui;

import java.util.Scanner;

public class BookUI extends SelectUI{

	private int menu() {
		System.out.println("*** 관리 프로그램 ***");
		System.out.println("1. 전체 조회");
		System.out.println("2. 조회");
		System.out.println("3. 등록");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
		System.out.println("0. 종료");
		System.out.println("선택 : ");
		Scanner sc = new  Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;	
	}
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			int type = menu();
			IBookUI ui = null;
			switch(type) {
			case 1 :
				ui = new SearchBookAllUI();
				break;
			case 2 :
				System.out.println("조회");
				break;
			case 3:
				ui  = new AddUI();
				break;
			case 4 :
				System.out.println("수정");
				break;
			case 5 :
				System.out.println("삭제");
				break;
			case 0:
				ui = new ExitUI();
				break;
			}
			
			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못입력");
			}
		}
	}
	
}	

