package co.dog.wp.message.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.board.model.BoardVO;
import co.dog.wp.board.model.CommentsVO;
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
	
	// 전체조회
	public ArrayList<MessageVO> getMessageList(String m_id) {
		ArrayList<MessageVO> list = new ArrayList<MessageVO>();
		
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from message where m_id = ? order by seq desc";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, m_id);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				MessageVO message = new MessageVO();
				message.setUserid(rs.getString("userid"));
				message.setTitle(rs.getString("title"));
				message.setRegdt(rs.getString("regdt"));
				message.setSeq(rs.getString("seq"));
				list.add(message);
			}
			// 4. 결과저장

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. DB연결 해제
			ConnectionManager.close(conn);
		}

		return list;
	}

	
	// 한건조회 board_seq
	public MessageVO getMessage(String seq) {
		MessageVO message = new MessageVO();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from message where seq=?";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, seq);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				message.setUserid(rs.getString("userid"));
				message.setM_id(rs.getString("m_id"));
				message.setSeq(rs.getString("seq"));
				message.setTitle(rs.getString("title"));
				message.setContents(rs.getString("contents"));
		
			}
			// 4. 결과저장

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. DB연결 해제
			ConnectionManager.close(conn);
		}

		return message;
	}
}
