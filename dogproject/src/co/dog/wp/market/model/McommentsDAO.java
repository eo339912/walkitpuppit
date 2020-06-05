package co.dog.wp.market.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.board.model.CommentsVO;
import co.dog.wp.common.ConnectionManager;

public class McommentsDAO{
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 등록
	public int commentsInsert(McommentsVO mcomments) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();


			// 2. sql구문 준비
			String sql = "insert into mcomments (id, regdt, seq, mcomments, c_seq)"
					+ " values (?, sysdate, seq_mcomment.nextval, ?, ?)";
			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, mcomments.getId());
			psmt.setString(2, mcomments.getMcomments());
			psmt.setString(3, mcomments.getC_seq());

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
	public ArrayList<McommentsVO> getMcommentsList(String c_seq) {
		ArrayList<McommentsVO> list = new ArrayList<McommentsVO>();
		
		
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from mcomments where c_seq = ? order by seq desc";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, c_seq);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				McommentsVO vo = new McommentsVO();
				vo.setId(rs.getString("id"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setMcomments(rs.getString("mcomments"));
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
			String sql = "delete from mcomments where seq= ? ";

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

	//댓글수	
	public McommentsVO commentCount(String c_seq) {
		McommentsVO vo = new McommentsVO();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select count(*) as cnt from mcomments where c_seq = ?";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, c_seq);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setCnt(rs.getString("cnt"));
			}
			// 4. 결과저장

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. DB연결 해제
			ConnectionManager.close(conn);
		}

		return vo;
	}
}
