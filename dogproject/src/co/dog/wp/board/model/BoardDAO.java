package co.dog.wp.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.common.ConnectionManager;



public class BoardDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 등록
	public void boardInsert(BoardVO board) {
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "INSERT INTO BOARD(SEQ, TITLE, ID ,CONTENT, REGDT, FILENAME, CNT)"
					+ " VALUES (SEQ_BOARD.NEXTVAL, ?, ?, ?, SYSDATE, ?, 0)";
			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getId());
			psmt.setString(3, board.getContent());
			psmt.setString(4, board.getFilename());

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

	// 전체조회
	public ArrayList<BoardVO> getBoardList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from board order by seq desc";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setRegdt(rs.getString("regdt"));
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setId(rs.getString("id"));
				vo.setSeq(rs.getString("seq"));
				vo.setFilename(rs.getString("filename"));

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
	
	// 한건조회 board_seq
	public BoardVO getBoard(String seq) {
		BoardVO vo = new BoardVO();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from board where seq=?";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, seq);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setRegdt(rs.getString("regdt"));
				vo.setContent(rs.getString("content"));
				vo.setSeq(rs.getString("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setId(rs.getString("id"));
				vo.setFilename(rs.getString("filename"));
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
	//한건조회 조회수
	public void increaseCnt(String seq) {
		
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "update board set cnt = cnt+1 where seq = ?";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, seq);
			
			psmt.executeUpdate();
			psmt.close();
			// 4. 결과저장

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. DB연결 해제
			ConnectionManager.close(conn);
		}
	}

	// 수정
	public int boardUpdate(BoardVO board) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update board set title=?, content=?, filename=?"
					+ " where seq=?";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getFilename());
			psmt.setString(4, board.getSeq());
			
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
	
	//삭제
	public void deleteBoard(String seq) {
		
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "delete from board where seq= ? ";

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
	
	
	// 전체조회
	public ArrayList<BoardVO> getBoardList(int start, int end, String title) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			
			String strWhere = " where 1 = 1";//무조건 true
			if(title != null && ! title.isEmpty()) {
				strWhere += " and title like '%' || ? || '%' ";				
			}
			
			// 2. 쿼리준비
			String sql = "select B.* from( select A.*, rownum RN from("
					+ "select * from board "+ strWhere+ " order by seq desc"
					+ " ) A ) B where RN between ? and ?";
			psmt = conn.prepareStatement(sql);
			int post = 1;
			if(title != null && ! title.isEmpty()) {
				psmt.setString(post++, title);				
			}
			psmt.setInt(post++, start);
			psmt.setInt(post++, end);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setRegdt(rs.getString("regdt"));
				vo.setContent(rs.getString("content"));
				vo.setSeq(rs.getString("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setId(rs.getString("id"));
				vo.setFilename(rs.getString("filename"));
				vo.setCnt(rs.getString("cnt"));

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
	//페이징 전체 건수
	public int getCount(String title) {
		int cnt = 0;
		try {
			conn = ConnectionManager.getConnnect();
			
			String strWhere = " where 1 = 1";//무조건 true
			if(title != null && ! title.isEmpty()) {
				strWhere += " and title like '%' || ? || '%' ";				
			}
			
			String sql ="select count(*) from board" + strWhere;
			psmt = conn.prepareStatement(sql);
			
			int post = 1;
			if(title != null && ! title.isEmpty()) {
				psmt.setString(post++, title);				
			}
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(rs, psmt, conn);
		}
		return cnt;
	}



}