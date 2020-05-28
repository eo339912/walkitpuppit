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
		String sql;
		
		public int MarketInsert(MarketVO market) {
			int r = 0;
			try {
				// 1. DB 연결
				conn = ConnectionManager.getConnnect();
				// 2. sql구문 준비
				String sql = "insert into market (seq, id, title, content, okays, filename, sselect,regdt,sell,price)"
						+ " values (seq_mol.nextval, ?, ?, ?, ?, ?, ?, sysdate,?,?)";
				psmt = conn.prepareStatement(sql);
				// 3. 실행
				psmt.setString(1, market.getSeq());
				psmt.setString(2, market.getId());
				psmt.setString(3, market.getTitle());
				psmt.setString(4, market.getContent());
				psmt.setString(5, market.getOkays());
				psmt.setString(6, market.getFilename());
				psmt.setString(7, market.getSselect());
				psmt.setString(8, market.getRegdt());
				psmt.setString(9, market.getSell());
			
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
			public ArrayList<MarketVO> getFmarketList(int start, int end, String ftitle) {
				ArrayList<MarketVO> list = new ArrayList<MarketVO>();
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					
					String strWhere = " where 1 = 1";//무조건 true
					if(ftitle != null && ! ftitle.isEmpty()) {
						strWhere += " and ftitle like '%' || ? || '%' ";				
					}
					
					// 2. 쿼리준비
					String sql = "select seq,id,ftitle,fcontent,filename,fsselect,fregdt,fsell,fprice from market where ftitle is not null";
					psmt = conn.prepareStatement(sql);
					int post = 1;
					if(ftitle != null && ! ftitle.isEmpty()) {
						psmt.setString(post++, ftitle);				
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
						vo.setFsell(rs.getString("fprice"));

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
			public MarketVO getMarket(String id) {
				MarketVO vo = new MarketVO();
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					// 2. 쿼리 준비
					sql = "select * from market where id = ?";
					psmt = conn.prepareStatement(sql);
					// 3. statement 실행
					psmt.setString(1, id );
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
						vo.setSell(rs.getString("price"));

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
					sql = "update market set seq = ?, content = ?, title = ?,  okays = ?, filename = ?, sselect = ?,  regdt = ?, sell = ?, price=?"
							+ " where id = ? ";
					psmt = conn.prepareStatement(sql);
					// 3. 실행
					psmt.setString(1, market.getId());
					psmt.setString(2, market.getContent());
					psmt.setString(3, market.getTitle());
					psmt.setString(4, market.getOkays());
					psmt.setString(5, market.getFilename());
					psmt.setString(6, market.getSselect());
					psmt.setString(7, market.getRegdt());
					psmt.setString(8, market.getSeq());
					psmt.setString(9, market.getSell());
					psmt.setString(9, market.getPrice());
				
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
			public ArrayList<MarketVO> getMarketList(String id) {
				ArrayList<MarketVO> list = new ArrayList<>();
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					// 2. 쿼리 준비
					sql = "select seq,id,title,content,filename,sselect,regdt,sell,price from market where title is not null";
					psmt = conn.prepareStatement(sql);
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
					ConnectionManager.close(conn);
				}
				return list;
			}
				public MarketVO getFmarket(String id) {
					MarketVO vo = new MarketVO();
					try {
						// 1. DB연결
						conn = ConnectionManager.getConnnect();
						// 2. 쿼리 준비
						sql = "select * from market where id = ?";
						psmt = conn.prepareStatement(sql);
						// 3. statement 실행
						psmt.setString(1, id);
						ResultSet rs = psmt.executeQuery();
						if (rs.next()) {
							vo.setSeq(rs.getString("seq"));
							vo.setId(rs.getString("id"));
							vo.setFtitle(rs.getString("ftitle"));
							vo.setFcontent(rs.getString("fcontent"));
							vo.setFilename(rs.getString("filename"));
							vo.setFsselect(rs.getString("fsselect"));
							vo.setFregdt(rs.getString("fregdt"));
							vo.setFsell(rs.getString("fsell"));
							vo.setFsell(rs.getString("fprice"));
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
						
						String strWhere = " where 1 = 1";//무조건 true
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
						//ConnectionManager.close(conn);
					}
				}

			
			}
	


