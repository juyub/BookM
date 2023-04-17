package kr.ac.kopo;

import kr.ac.kopo.service.JoinService;

public class JoinServiceFactory {

	private static JoinService service = null;

	public static JoinService getInstance() {

		if (service == null) {
			service = new JoinService();
		}

		return service;
	}
	
}
