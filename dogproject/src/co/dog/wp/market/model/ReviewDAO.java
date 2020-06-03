package co.dog.wp.market.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.common.ConnectionManager;

public class ReviewDAO {

		Connection conn;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql;
		
		public int ReviewInsert(ReviewVO review) {
			int r = 0;
			try {
				// 1. DB 연결
				conn = ConnectionManager.getConnnect();
				// 2. sql구문 준비
				String sql = "insert into review (seq, id, title, content, filename, regdt,cnt)"
						+ " values (seq_mol.nextval, ?, ?, ?, ?, sysdate,0)";
				psmt = conn.prepareStatement(sql);
				// 3. 실행
				psmt.setString(1, review.getId());
				psmt.setString(2, review.getTitle());
				psmt.setString(3, review.getContent());
				psmt.setString(4, review.getFilename());
			

			
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
		//전체조회
		public ArrayList<ReviewVO> getReviewList(int start, int end, String id) {
			ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
			try {
				// 1. DB연결
				conn = ConnectionManager.getConnnect();
				
				String strWhere = " where 1 = 1";//무조건 true
				if(id != null && ! id.isEmpty()) {
					strWhere += " and id like '%' || ? || '%' ";				
				}
				
				// 2. 쿼리준비
				String sql = "select B.* from( select A.*, rownum RN from("
						+ "select * from review "+ strWhere+ " order by seq desc"
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
					ReviewVO vo = new ReviewVO();
					vo.setSeq(rs.getString("seq"));
					vo.setId(rs.getString("id"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
					vo.setFilename(rs.getString("filename"));
					vo.setRegdt(rs.getString("regdt"));
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
		
			//단건조회
			public ReviewVO getReview(String seq) {
				ReviewVO vo = new ReviewVO();
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					// 2. 쿼리 준비
					sql = "select * from review where seq = ?";
					psmt = conn.prepareStatement(sql);
					// 3. statement 실행
					psmt.setString(1, seq);
					ResultSet rs = psmt.executeQuery();
					if (rs.next()) {
						vo.setSeq(rs.getString("seq"));
						vo.setId(rs.getString("id"));
						vo.setTitle(rs.getString("title"));
						vo.setContent(rs.getString("content"));
						vo.setFilename(rs.getString("filename"));
						vo.setRegdt(rs.getString("regdt"));
						vo.setCnt(rs.getString("cnt"));
					}
					// 4. 결과저장
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					ConnectionManager.close(conn);
				}
				return vo;
			}
			
			public void reviewUpdate(ReviewVO review) {
				int r = 0;
				try {
					conn = ConnectionManager.getConnnect();
					// 2. sql구문 준비
					sql = "update review set content = ?, title = ?, filename = ?"
							+ " where seq = ? ";
					psmt = conn.prepareStatement(sql);
					// 3. 실행
					psmt.setString(1, review.getContent());
					psmt.setString(2, review.getTitle());
					psmt.setString(3, review.getFilename());
					psmt.setString(4, review.getSeq());
				
					r = psmt.executeUpdate();
					// 4. 결과처리
					System.out.println(r + " 건이 수정됨.");

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// 5. 연결해제
					ConnectionManager.close(conn);
				}
			}
			public void reviewDelete(String id) {		
				try {
					conn = ConnectionManager.getConnnect();
					String sql = " DELETE FROM review "
						 	+    "  WHERE id = ? ";
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, id);
					psmt.executeUpdate();			
				} catch(Exception e) {
					e.printStackTrace();
				} finally {
					//5. 연결해제 
					ConnectionManager.close(conn);
				}
			}
			public int getCount(String id) {
				int cnt = 0;
				try {
					conn = ConnectionManager.getConnnect();
					
					String strWhere = " where 1 = 1";//무조건 true
					if(id != null && ! id.isEmpty()) {
						strWhere += " and id like '%' || ? || '%' ";				
					}
					
					String sql ="select count(*) from review" + strWhere;
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
			//한건조회 조회수
			public void increaseCnt(String seq) {
				
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					// 2. 쿼리준비
					String sql = "update review set cnt = cnt+1 where seq = ?";
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
					//ConnectionManager.close(conn);
				}
			}
			public void deleteReview(String seq) {
				
				try {
					// 1. DB 연결
					conn = ConnectionManager.getConnnect();

					// 2. sql구문 준비
					String sql = "delete from review where seq= ? ";

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
		
			
	
	