package co.dog.wp.park.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.common.ConnectionManager;



public class ParkDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	
	
	// 전체조회
	public ArrayList<ParkVO> getParkList(String spotnum) {
		ArrayList<ParkVO> list = new ArrayList<ParkVO>(); // 1.어레이리스트에 담기

		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();
			// 2. 쿼리 준비
			String sql = "select * from park where spotnum = ? order by seq"; // 2.전체조회는 항상 오더바디 넣자
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, spotnum); // 첫번재 물음표 값이 id다  // 3. 단건에서의 ? 빠졌으니 set도 필요없음
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				ParkVO vo = new ParkVO(); // 4. 위치 while 안으로
				vo.setSname(rs.getString("sname"));
				vo.setSenter(rs.getString("senter"));
				vo.setSeq(rs.getString("seq"));
				vo.setSpotnm(rs.getString("spotnm"));// 결과값에 담기
				list.add(vo); // 5.리스트에 담기
			}
			// 4. 결과 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return list;
	}
	
	// 단건조회
	public ParkVO getPark(String seq) {
			ParkVO parkvo = new ParkVO();

			try {
				
				conn = ConnectionManager.getConnnect();
	
				String sql = "select * from park where seq=?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, seq); 
				ResultSet rs = psmt.executeQuery();
				if (rs.next()) {
					parkvo.setSeq(rs.getString("seq"));
					parkvo.setSpotnm(rs.getString("spotnm"));
					parkvo.setSenter(rs.getString("senter"));
					parkvo.setSname(rs.getString("sname"));
					parkvo.setX(rs.getString("x"));
					parkvo.setY(rs.getString("y"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.close(conn);
			}
			return parkvo;
		}
	
	//-----------------------------댓글--------------------------------------------
	
	//댓글등록
	public void ParkcoInsert(ParkcoVO parkco) {
		
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into parkcomments (seq ,pseq ,id, comments , regdt)"
					+ " values ( seq_parkco.nextval,?, ?, ?, sysdate) ";
				

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, parkco.getPseq());
			psmt.setString(2, parkco.getId());
			psmt.setString(3, parkco.getComments());
		
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
	}
	
	// 댓글리스트
	public ArrayList<ParkcoVO> getParkco(String pseq) {
		ArrayList<ParkcoVO> list = new ArrayList<ParkcoVO>(); // 1.어레이리스트에 담기


		try {

			conn = ConnectionManager.getConnnect();
			
			String sql = "select id, comments, seq, pseq from parkcomments where pseq = ? order by seq desc ";
			psmt = conn.prepareStatement(sql);
		
			psmt.setString(1, pseq); 
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				ParkcoVO parkcovo = new ParkcoVO();
				parkcovo.setId(rs.getString("id"));
				parkcovo.setComments(rs.getString("comments"));
				parkcovo.setSeq(rs.getString("seq"));
				parkcovo.setPseq(rs.getString("pseq"));
				
		
				list.add(parkcovo); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return list;
	}
	
	  //삭제
	   public void deleteParkco(String pseq) {
	      
	      try {
	         // 1. DB 연결
	         conn = ConnectionManager.getConnnect();

	         // 2. sql구문 준비
	         String sql = "delete from parkcomments where pseq= ? ";

	  
	         psmt = conn.prepareStatement(sql);

	         // 3. 실행
	         psmt.setString(1, pseq);

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
