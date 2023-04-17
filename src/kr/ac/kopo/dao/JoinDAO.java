package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.JoinVO;

/**
 * 오라클 DB t_board 테이블에 CRUD하는 DAO클래스
 * @author User
 *
 */

public class JoinDAO {

public void insertJoin(JoinVO join) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_join(no, title, writer) "); /*, reg_date*/
		sql.append(" values(seq_t_join_no.nextval, ?, ?) "); /*, sysdate*/
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, join.getTitle());
			pstmt.setString(2, join.getWriter());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public List<JoinVO> selectAllJoin(){
		
		List<JoinVO> joinList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer ");
		sql.append("      ,to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_join");
		sql.append(" order by no desc ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int no = rs.getInt("no");
				String title   = rs.getString("title");
				String writer  = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				
				JoinVO join = new JoinVO();
				join.setNo(no);
				join.setTitle(title);
				join.setWriter(writer);
				join.setRegDate(regDate);
				
				joinList.add(join);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return joinList;
	}
	
	public JoinVO selectJoinByNo(int joinNo) {
		
		JoinVO join = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer ");
		sql.append("      ,to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_join ");
		sql.append(" where no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setInt(1, joinNo);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				
				join = new JoinVO(no, title, writer, regDate);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return join;
	}
	
}
