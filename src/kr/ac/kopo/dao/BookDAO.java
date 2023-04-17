package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BookVO;

/**
 * 오라클 DB t_board 테이블에 CRUD하는 DAO클래스
 * @author User
 *
 */

public class BookDAO {

	public void insertBook(BookVO book) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_book(no, title, writer) "); /*, reg_date*/
		sql.append(" values(seq_t_book_no.nextval, ?, ?) "); /*, sysdate*/
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public List<BookVO> selectAllBook(){
		
		List<BookVO> bookList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer ");
		sql.append("      ,to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_book");
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
				
				BookVO book = new BookVO();
				book.setNo(no);
				book.setTitle(title);
				book.setWriter(writer);
				book.setRegDate(regDate);
				
				bookList.add(book);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	
	public BookVO selectBookByNo(int bookNo) {
		
		BookVO book = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer ");
		sql.append("      ,to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_book ");
		sql.append(" where no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setInt(1, bookNo);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				
				book = new BookVO(no, title, writer, regDate);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
}













