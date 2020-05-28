package co.dog.wp.market.model;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;

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
				String sql = "insert into market (seq, id, title, content, okays, pimage, sselect,regdt)"
						+ " values (seq_mol.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
				psmt = conn.prepareStatement(sql);
				// 3. 실행
				psmt.setString(1, market.getSeq());
				psmt.setString(2, market.getId());
				psmt.setString(3, market.getTitle());
				psmt.setString(4, market.getContent());
				psmt.setString(5, market.getOkays());
				psmt.setString(6, market.getPimage());
				psmt.setString(7, market.getSselect());
				psmt.setString(8, market.getRegdt());
			
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
			public ArrayList<MarketVO> getFMarketList() {
				ArrayList<MarketVO> list = new ArrayList<>();
				try {
					// 1. DB연결
					conn = ConnectionManager.getConnnect();
					// 2. 쿼리 준비
					sql = "select seq,id,ftitle,fcontent,fpimage,fsselect,fregdt from market where ftitle is not null";
					psmt = conn.prepareStatement(sql);
					// 3. statement 실행
					ResultSet rs = psmt.executeQuery();
					while (rs.next()) {
						MarketVO vo = new MarketVO();
						vo.setSeq(rs.getString("seq"));
						vo.setId(rs.getString("id"));
						vo.setFtitle(rs.getString("ftitle"));
						vo.setFcontent(rs.getString("fcontent"));
						vo.setFpimage(rs.getString("fpimage"));
						vo.setFsselect(rs.getString("fsselect"));
						vo.setFregdt(rs.getString("fregdt"));
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
						vo.setSeq(rs.getString("id"));
						vo.setId(rs.getString("id"));
						vo.setTitle(rs.getString("title"));
						vo.setContent(rs.getString("content"));
						vo.setPimage(rs.getString("pimage"));
						vo.setSselect(rs.getString("sselect"));
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
			
			public void marketUpdate(MarketVO market) {
				int r = 0;
				try {
					conn = ConnectionManager.getConnnect();
					// 2. sql구문 준비
					sql = "update market set seq = ?, content = ?, title = ?,  okays = ?, pimage = ?, sselect = ?,  regdt = ?"
							+ " where id = ? ";
					psmt = conn.prepareStatement(sql);
					// 3. 실행
					psmt.setString(1, market.getId());
					psmt.setString(2, market.getContent());
					psmt.setString(3, market.getTitle());
					psmt.setString(4, market.getOkays());
					psmt.setString(5, market.getPimage());
					psmt.setString(6, market.getSselect());
					psmt.setString(7, market.getRegdt());
					psmt.setString(8, market.getSeq());
				
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
					sql = "select seq,id,title,content,pimage,sselect,regdt from market where title is not null";
					psmt = conn.prepareStatement(sql);
					// 3. statement 실행
					ResultSet rs = psmt.executeQuery();
					while (rs.next()) {
						MarketVO vo = new MarketVO();
						vo.setSeq(rs.getString("seq"));
						vo.setId(rs.getString("id"));
						vo.setFtitle(rs.getString("title"));
						vo.setFcontent(rs.getString("content"));
						vo.setFpimage(rs.getString("pimage"));
						vo.setFsselect(rs.getString("sselect"));
						vo.setFregdt(rs.getString("regdt"));
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
							vo.setFpimage(rs.getString("fpimage"));
							vo.setFsselect(rs.getString("fsselect"));
							vo.setFregdt(rs.getString("fregdt"));
						}
						// 4. 결과저장
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						ConnectionManager.close(conn);
					}
					return vo;
				}
			
			
			
			}
	


