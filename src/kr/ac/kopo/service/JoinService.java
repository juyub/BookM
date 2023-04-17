package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.JoinDAO;
import kr.ac.kopo.vo.JoinVO;

public class JoinService {

	private JoinDAO joinDao;

	public JoinService() {
		joinDao = new JoinDAO();
	}

	public void insertJoin(JoinVO join) {

		joinDao.insertJoin(join);
	}

	public List<JoinVO> selectAll() {
		List<JoinVO> joinList = joinDao.selectAllJoin();
		return joinList;
	}

	public JoinVO selectByNo(int joinNo) {

		JoinVO join = joinDao.selectJoinByNo(joinNo);
		return join;
	}
}
