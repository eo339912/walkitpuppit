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
				String sql = "insert into review (seq, id, title, content, okays, filename, regdt)"
						+ " values (seq_mol.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
				psmt = conn.prepareStatement(sql);
				// 3. 실행
				psmt.setString(1, review.getSeq());
				psmt.setString(2, review.getId());
				psmt.setString(3, review.getTitle());
				psmt.setString(4, review.getContent());
				psmt.setString(5, review.getOkays());
				psmt.setString(6, review.getFilename());
				psmt.setString(8, review.getRegdt());
			
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
				String sql = "select * from wp.review order by id";
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
					vo.setOkays(rs.getString("okays"));
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
			public ReviewVO getReview(String id) {
				ReviewVO vo = new ReviewVO();
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					// 2. 쿼리 준비
					sql = "select * from review where id = ?";
					psmt = conn.prepareStatement(sql);
					// 3. statement 실행
					psmt.setString(1, id );
					ResultSet rs = psmt.executeQuery();
					if (rs.next()) {
						vo.setSeq(rs.getString("seq"));
						vo.setId(rs.getString("id"));
						vo.setTitle(rs.getString("title"));
						vo.setContent(rs.getString("content"));
						vo.setOkays(rs.getString("okays"));
						vo.setFilename(rs.getString("filename"));
						vo.setRegdt(rs.getString("regdt"));
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
					sql = "update review set seq = ?, content = ?, title = ?,  okays = ?, filename = ?,  regdt = ?"
							+ " where id = ? ";
					psmt = conn.prepareStatement(sql);
					// 3. 실행
					psmt.setString(1, review.getId());
					psmt.setString(2, review.getContent());
					psmt.setString(3, review.getTitle());
					psmt.setString(4, review.getOkays());
					psmt.setString(5, review.getFilename());
					psmt.setString(7, review.getRegdt());
					psmt.setString(8, review.getSeq());
				
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
			public void increaseCnt(String id) {
				
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					// 2. 쿼리준비
					String sql = "update market set cnt = cnt+1 where id = ?";
					psmt = conn.prepareStatement(sql);
					// 3. statement 실행
					psmt.setString(1, id);
					
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
		
			
	
	