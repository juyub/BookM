package kr.ac.kopo;

import kr.ac.kopo.ui.SelectUI;

public class BookMain {

	public static void main(String[] args) {
			
		try {
			new SelectUI().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
	

