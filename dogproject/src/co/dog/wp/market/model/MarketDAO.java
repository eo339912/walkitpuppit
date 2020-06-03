package co.dog.wp.market.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.board.model.BoardVO;
import co.dog.wp.common.ConnectionManager;

	public class MarketDAO {
		Connection conn;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		public int MarketInsert(MarketVO market) {
			int r = 0;
			try {
				// 1. DB 연결
				conn = ConnectionManager.getConnnect();
				// 2. sql구문 준비
				String sql = "insert into market (seq, id, title, content, filename, sselect,regdt,sell,price,cnt)"
						+ " values (seq_mol.nextval, ?, ?, ?, ?,?, sysdate,?,?,0)";
				psmt = conn.prepareStatement(sql);
				// 3. 실행
			
				psmt.setString(1, market.getId());
				psmt.setString(2, market.getTitle());
				psmt.setString(3, market.getContent());
				psmt.setString(4, market.getFilename());
				psmt.setString(5, market.getSselect());
				psmt.setString(6, market.getSell());
				psmt.setString(7, market.getPrice());
			
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
		public int FmarketInsert(MarketVO market) {
			int r = 0;
			try {
				// 1. DB 연결
				conn = ConnectionManager.getConnnect();
				// 2. sql구문 준비
				String sql = "insert into market (seq, id, ftitle, fcontent, filename, fsselect,fregdt,fsell,fprice,cnt)"
						+ " values (seq_mol.nextval, ?, ?, ?, ?,?, sysdate,?,?,0)";
				psmt = conn.prepareStatement(sql);
				// 3. 실행
			
				psmt.setString(1, market.getId());
				psmt.setString(2, market.getFtitle());
				psmt.setString(3, market.getFcontent());
				psmt.setString(4, market.getFilename());
				psmt.setString(5, market.getFsselect());
				psmt.setString(6, market.getFsell());
				psmt.setString(7, market.getFprice());
			
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
			public ArrayList<MarketVO> getFmarketList(int start, int end, String id) {
				ArrayList<MarketVO> list = new ArrayList<MarketVO>();
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					
					String strWhere = " where ftitle is not null";//무조건 true
					if(id != null && ! id.isEmpty()) {
						strWhere += " and id like '%' || ? || '%' ";				
					}
					
					// 2. 쿼리준비
					String sql = "select B.* from( select A.*, rownum RN from("
							+ "select seq,id,ftitle,fcontent,filename,fsselect,fregdt,fsell from market "+ strWhere+ " order by seq desc"
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
						MarketVO vo = new MarketVO();
						vo.setSeq(rs.getString("seq"));
						vo.setId(rs.getString("id"));
						vo.setFtitle(rs.getString("ftitle"));
						vo.setFcontent(rs.getString("fcontent"));
						vo.setFilename(rs.getString("filename"));
						vo.setFsselect(rs.getString("fsselect"));
						vo.setFregdt(rs.getString("fregdt"));
						vo.setFsell(rs.getString("fsell"));
						

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
			public MarketVO getMarket(String seq) {
				MarketVO vo = new MarketVO();
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					// 2. 쿼리 준비
					String sql = "select * from market where seq = ?";
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
						vo.setSselect(rs.getString("sselect"));
						vo.setRegdt(rs.getString("regdt"));
						vo.setSell(rs.getString("sell"));
						vo.setPrice(rs.getString("price"));
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
			
			public void marketUpdate(MarketVO market) {
				int r = 0;
				try {
					conn = ConnectionManager.getConnnect();
					// 2. sql구문 준비
					String sql = "update market set content = ?, title = ?, filename = ?, sselect = ?, sell = ?, price=?"
							+ " where seq = ? ";
					psmt = conn.prepareStatement(sql);
					// 3. 실행
					psmt.setString(1, market.getContent());
					psmt.setString(2, market.getTitle());
					psmt.setString(3, market.getFilename());
					psmt.setString(4, market.getSselect());
					psmt.setString(5, market.getSell());
					psmt.setString(6, market.getPrice());
					psmt.setString(7, market.getSeq());
				
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
			public void marketDelete(String id) {		
				try {
					conn = ConnectionManager.getConnnect();
					String sql = " DELETE FROM market "
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
			public ArrayList<MarketVO> getMarketList(int start, int end, String id) {
				ArrayList<MarketVO> list = new ArrayList<MarketVO>();
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					String strWhere = " where title is not null";//무조건 true
					if(id != null && ! id.isEmpty()) {
						strWhere += " and id like '%' || ? || '%' ";				
					}	
					// 2. 쿼리준비
					String sql = "select B.* from( select A.*, rownum RN from("
							+ "select seq,id,title,content,filename,sselect,regdt,sell,price from market "+ strWhere+ " order by seq desc"
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
						MarketVO vo = new MarketVO();
						vo.setSeq(rs.getString("seq"));
						vo.setId(rs.getString("id"));
						vo.setTitle(rs.getString("title"));
						vo.setContent(rs.getString("content"));
						vo.setFilename(rs.getString("filename"));
						vo.setSselect(rs.getString("sselect"));
						vo.setRegdt(rs.getString("regdt"));
						vo.setSell(rs.getString("sell"));
						vo.setPrice(rs.getString("price"));

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
				public MarketVO getFmarket(String seq) {
					MarketVO vo = new MarketVO();
					try {
						// 1. DB연결
						conn = ConnectionManager.getConnnect();
						// 2. 쿼리 준비
						String sql = "select * from market where seq = ?";
						psmt = conn.prepareStatement(sql);
						// 3. statement 실행
						psmt.setString(1, seq);
						ResultSet rs = psmt.executeQuery();
						if (rs.next()) {
							vo.setSeq(rs.getString("seq"));
							vo.setId(rs.getString("id"));
							vo.setFtitle(rs.getString("ftitle"));
							vo.setFcontent(rs.getString("fcontent"));
							vo.setFilename(rs.getString("filename"));
							vo.setFsselect(rs.getString("fsselect"));
							vo.setRegdt(rs.getString("regdt"));
							vo.setFsell(rs.getString("fsell"));
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
			
				public int getCount(String id) {
					int cnt = 0;
					try {
						conn = ConnectionManager.getConnnect();
						
						String strWhere = " where title is not null";//무조건 true
						if(id != null && ! id.isEmpty()) {
							strWhere += " and id like '%' || ? || '%' ";				
						}
						
						String sql ="select count(*) from market" + strWhere;
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
						String sql = "update market set cnt = cnt+1 where seq = ?";
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

				//삭제
				public void deleteMarket(String seq) {
					
					try {
						// 1. DB 연결
						conn = ConnectionManager.getConnnect();

						// 2. sql구문 준비
						String sql = "delete from market where seq= ? ";

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
				public ArrayList<MarketVO> getMarketList2() {
					ArrayList<MarketVO> list = new ArrayList<MarketVO>();

					try {
						// 1. DB연결
						conn = ConnectionManager.getConnnect();
						// 2. 쿼리준비
						String sql = "select * from market order by seq desc";
						psmt = conn.prepareStatement(sql);
						// 3. statement 실행
						ResultSet rs = psmt.executeQuery();
						while (rs.next()) {
							MarketVO vo = new MarketVO();
							vo.setTitle(rs.getString("title"));
							vo.setId(rs.getString("id"));
							vo.setContent(rs.getString("content"));
							vo.setFilename(rs.getString("filename"));
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
				
			}
	


