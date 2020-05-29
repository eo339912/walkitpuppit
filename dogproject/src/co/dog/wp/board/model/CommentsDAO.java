package co.dog.wp.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.common.ConnectionManager;

public class CommentsDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 등록
	public int commentsInsert(CommentsVO comments) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();


			// 2. sql구문 준비
			String sql = "insert into comments (id, regdt, seq, commentsO, b_seq)"
					+ " values (?, sysdate, seq_comments.nextval, ?, ?)";
			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, comments.getId());
			psmt.setString(2, comments.getCommentsO());
			psmt.setString(3, comments.getB_seq());

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
	public ArrayList<CommentsVO> getCommentsList(String bseq) {
		ArrayList<CommentsVO> list = new ArrayList<CommentsVO>();
		
		
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from comments where b_seq = ? order by seq desc";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, bseq);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				CommentsVO vo = new CommentsVO();
				vo.setId(rs.getString("id"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setCommentsO(rs.getString("commentsO"));
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
			String sql = "delete from comments where seq= ? ";

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
