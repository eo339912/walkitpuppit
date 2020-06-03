package co.dog.wp.park.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.board.model.BoardVO;
import co.dog.wp.common.ConnectionManager;

public class WalkDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 등록
	public void WalkIN(WalkVO walk) {
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "INSERT INTO WALK(SEQ, ID, INCHECK, INPARK, P_SEQ)"
					+ " VALUES (SEQ_WALK.NEXTVAL, ?, 1, SYSDATE, ?)";
			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, walk.getId());
			psmt.setString(2, walk.getP_seq());

			psmt.executeUpdate();

			// 4. 결과처리
			System.out.println("등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

	}
	
	// 한건조회
	public WalkVO getWalk(String p_seq, String id) {
		WalkVO vo = new WalkVO();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from walk where p_seq= ? and id = ? order by seq desc";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, p_seq);
			psmt.setString(2, id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setSeq(rs.getString("seq"));
				vo.setIncheck(rs.getString("incheck"));
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
	
	// 수정
	public int WalkOUT(WalkVO walk) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update walk set outpark = SYSDATE, incheck = 0"
					+ " where seq=? and incheck = 1";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, walk.getSeq());
			
			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 수정됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}
	
	// park에 업데이드
	public int ParkUpdate() {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "UPDATE park A SET senter = ("
					+ " SELECT sum(incheck) FROM walk B WHERE B.p_seq = A.seq)";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			
			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 수정됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}
	
	// 전체조회
	public ArrayList<WalkVO> getWalkList(String p_seq) {
		ArrayList<WalkVO> list = new ArrayList<WalkVO>();
		WalkVO vo = new WalkVO();
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from walk where p_seq = ? and incheck = 1";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			psmt.setString(1, vo.getP_seq());
			while (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setInpark(rs.getString("inpark"));
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
	
	
	
}
