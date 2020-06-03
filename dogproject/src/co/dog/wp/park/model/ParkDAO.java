package co.dog.wp.park.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.common.ConnectionManager;



public class ParkDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
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
	public int ParkcoInsert(ParkcoVO parkco) {
		int r = 0;
		
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into parkcomments (seq ,pseq ,id, comments , regdt)"
					+ " values ( seq_parkco.nextval,?, ?, ?, sysdate)";
			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, parkco.getPseq());
			psmt.setString(2, parkco.getId());
			psmt.setString(3, parkco.getComments());
		
			r = psmt.executeUpdate();
			
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return r;
	}
	
	// 댓글리스트
	public ArrayList<ParkcoVO> getParkcoList(String pseq) {
		ArrayList<ParkcoVO> list = new ArrayList<ParkcoVO>(); // 1.어레이리스트에 담기


		try {

			conn = ConnectionManager.getConnnect();
			
			String sql = "select * from parkcomments where pseq = ? order by seq desc";
			psmt = conn.prepareStatement(sql);
		
			psmt.setString(1, pseq); 
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				ParkcoVO parkcovo = new ParkcoVO();
				parkcovo.setId(rs.getString("id"));
				parkcovo.setComments(rs.getString("comments"));
				parkcovo.setSeq(rs.getString("seq"));
				parkcovo.setRegdt(rs.getString("regdt"));

				list.add(parkcovo); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return list;
	}
	
	  //댓글 삭제
	   public void deleteParkco(String seq) {
	      
	      try {
	         // 1. DB 연결
	         conn = ConnectionManager.getConnnect();

	         // 2. sql구문 준비
	         String sql = "delete from parkcomments where seq= ? ";

	  
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
		public ArrayList<ParkVO> getParkList(int start, int end, String sname, String spotnum) {
			ArrayList<ParkVO> list = new ArrayList<ParkVO>(); // 1.어레이리스트에 담기

			try {
				// 1. DB 연결
				conn = ConnectionManager.getConnnect();
				
				String strWhere = " where spotnum = ?";
				if(sname != null && ! sname.isEmpty()) {
					strWhere += " and sname like '%' || ? || '%' ";	
				} 
				
				// 2. 쿼리 준비
				String sql = "select B.*, NVL(B.senter, 0) as se from( select A.*, rownum RN from("
						+ "select * from park" + strWhere+ "order by seq desc"
								+ " )A ) B where RN between ? and ?"; // 2.전체조회는 항상 오더바디 넣자
				psmt = conn.prepareStatement(sql);
				int post = 1;
				psmt.setString(post++, spotnum);
				if(sname != null && ! sname.isEmpty()) {
					psmt.setString(post++, sname);				
				}
				psmt.setInt(post++, start);
				psmt.setInt(post++, end);                    
				
				// 3. statement 실행
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					ParkVO vo = new ParkVO(); // 4. 위치 while 안으로
					vo.setSname(rs.getString("sname"));
					vo.setSenter(rs.getString("se"));
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

		//페이징 전체 건수
		public int getCount(String sname, String spotnum) {
			int cnt = 0;
			try {
				conn = ConnectionManager.getConnnect();
				
				String strWhere = " where spotnum = ?";//무조건 true
				if(sname != null && ! sname.isEmpty()) {
					strWhere += " and sname like '%' || ? || '%' ";				
				}
				
				String sql ="select count(*) from park" + strWhere;
				psmt = conn.prepareStatement(sql);
				
				int post = 1;
				psmt.setString(post++, spotnum);
				if(sname != null && ! sname.isEmpty()) {
					psmt.setString(post++, sname);				
				}
				
				rs = psmt.executeQuery();			
				if(rs.next()) {
					cnt = rs.getInt(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionManager.close(rs, psmt,conn);
			}
			return cnt;
		}
	

}
