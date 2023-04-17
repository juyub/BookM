package kr.ac.kopo.ui;

import java.util.Scanner;

public class SelectUI extends BaseUI{

	private int menu() {
		System.out.println("*** 관리 프로그램 ***");
		System.out.println("1. 회원");
		System.out.println("2. 도서");
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
				ui  = new MemberUI();
				break;
			case 2 :
				ui  = new BookUI();
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
