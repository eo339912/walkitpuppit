package co.dog.wp.market.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.common.ConnectionManager;

public class McommentDAO{
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 등록
	public int commentsInsert(McommentVO mcomment) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();


			// 2. sql구문 준비
			String sql = "insert into mcomment (id, regdt, seq, mcomment, m_seq)"
					+ " values (?, sysdate, seq_mcomment.nextval, ?, ?)";
			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, mcomment.getId());
			psmt.setString(2, mcomment.getMcomment());
			psmt.setString(3, mcomment.getM_seq());
			psmt.setString(4, mcomment.getRegdt());
			psmt.setString(5, mcomment.getSeq());
			
			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}
	
	// 전체조회
	public ArrayList<McommentVO> getMcommentList(String m_seq) {
		ArrayList<McommentVO> list = new ArrayList<McommentVO>();
		
		
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from mcomment where m_seq = ? order by seq desc";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, m_seq);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				McommentVO vo = new McommentVO();
				vo.setId(rs.getString("id"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setMcomment(rs.getString("mcomment"));
				vo.setSeq(rs.getString("seq"));
				list.add(vo);
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
	
	//삭제
	public void deleteComments(String seq) {
		
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "delete from mcomment where seq= ? ";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, seq);

			psmt.executeUpdate();

			// 4. 결과처리

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

	}

}
