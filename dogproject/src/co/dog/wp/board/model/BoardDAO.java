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
	public int boardInsert(BoardVO board) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into board (seq, title, contents, regdt, filename)"
					+ " values (seq_board.nextval, ?, ?, sysdate, ?)";
			psmt = conn.prepareStatement(sql);

			
			// 3. 실행
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getFilename());

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

	// id에 해당하는 board 조회
	public ArrayList<BoardVO> getBoardOneList(String id) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();

		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리준비
			String sql = "select * from board where id=? order by seq desc";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setRegdt(rs.getString("regdt"));
				vo.setSeq(rs.getString("seq"));
				vo.setTitle(rs.getString("title"));

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

	
	// 수정
	public int boardUpdate(BoardVO board) {
		int r = 0;

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update board set title=?, contents=?"
					+ " where seq=?";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getSeq());
			
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
	public ArrayList<BoardVO> getBoardList(int start, int end, String id) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
			
			String strWhere = " where 1 = 1";//무조건 true
			if(id != null && ! id.isEmpty()) {
				strWhere += " and id like '%' || ? || '%' ";				
			}
			
			// 2. 쿼리준비
			String sql = "select B.* from( select A.*, rownum RN from("
					+ "select * from board "+ strWhere+ " order by star desc, seq"
					+ " ) A ) B where RN between ? and ?";
			psmt = conn.prepareStatement(sql);
			int post = 1;
			if(id != null && ! id.isEmpty()) {
				psmt.setString(post++, id);				
			}
			psmt.setInt(post++, start);
			psmt.setInt(post++, end);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setRegdt(rs.getString("regdt"));
				vo.setTitle(rs.getString("title"));
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
	//페이징 전체 건수
	public int getCount(String id) {
		int cnt = 0;
		try {
			conn = ConnectionManager.getConnnect();
			
			String strWhere = " where 1 = 1";//무조건 true
			if(id != null && ! id.isEmpty()) {
				strWhere += " and id like '%' || ? || '%' ";				
			}
			
			String sql ="select count(*) from board" + strWhere;
			psmt = conn.prepareStatement(sql);
			
			int post = 1;
			if(id != null && ! id.isEmpty()) {
				psmt.setString(post++, id);				
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