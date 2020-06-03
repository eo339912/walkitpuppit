package co.dog.wp.message.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			String sql = "INSERT INTO MESSAGE(SEQ, USERID, M_ID, TITLE, CONTENTS, REGDT)"
					+ " VALUES (SEQ_MESSAGE.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
				
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, message.getUserid());
			psmt.setString(2, message.getM_id());
			psmt.setString(3, message.getTitle());
			psmt.setString(4, message.getContents());
			

			psmt.executeUpdate();

			// 4. 결과처리
			System.out.println("쪽지 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

	}

}
