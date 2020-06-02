package co.dog.wp.message.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.dog.wp.board.model.BoardVO;
import co.dog.wp.common.ConnectionManager;

public class MessageDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public void messageInsert(MessageVO message) {
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "INSERT INTO MYPAGE(USERID, TITLE, CONTENTS, REGDT)"
					+ "SELECT USERID, TITLE, CONTENTS, REGDT FROM MESSAGE"
					+ "WHERE ID=?;"; 
					
				
			psmt = conn.prepareStatement(sql);

//			// 3. 실행
//			psmt.setString(1, board.getTitle());
//			psmt.setString(2, board.getId());
//			psmt.setString(3, board.getContent());
//			psmt.setString(4, board.getFilename());

			psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(" 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

	}

}
