package co.dog.wp.mypage.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.dog.wp.common.ConnectionManager;
import co.dog.wp.market.model.MarketVO;
import co.dog.wp.market.model.ReviewVO;
import co.dog.wp.park.model.WalkVO;

public class MypageDAO {
	
	Connection conn;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	//내가 쓴 마켓 글 리스트
	public ArrayList<MarketVO> getMymarketList(String id) {
		ArrayList<MarketVO> list = new ArrayList<MarketVO>();
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
		
			// 2. 쿼리준비
			String sql = "select * from market where id = ? order by seq desc";
	
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				MarketVO vo = new MarketVO();
				vo.setSeq(rs.getString("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setFtitle(rs.getString("ftitle"));
				vo.setSselect(rs.getString("sselect"));
				vo.setFsselect(rs.getString("fsselect"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setFregdt(rs.getString("fregdt"));
	
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
	
	//내가 쓴 후기 글 리스트
	public ArrayList<ReviewVO> getMyreviewList(String id) {
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		try {
			// 1. DB연결
			conn = ConnectionManager.getConnnect();
		
			// 2. 쿼리준비
			String sql = "select * from review where id = ? order by seq desc";
	
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				ReviewVO review = new ReviewVO();
				review.setSeq(rs.getString("seq"));
				review.setTitle(rs.getString("title"));
				review.setRegdt(rs.getString("regdt"));
	
				list.add(review);
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
	
	//나의 총 산책 시간 리스트 
		public ArrayList<WalkVO> getWalkTime(String id) {
			ArrayList<WalkVO> list = new ArrayList<WalkVO>();
			try {
				// 1. DB연결
				conn = ConnectionManager.getConnnect();
			
				// 2. 쿼리준비
				String sql = "select id, seq, p_seq, sname," 
						+ " to_char(inpark,'HH24:MI') as inpark,"
						+ " to_char(outpark,'HH24:MI') as outpark,"
						+ " round((outpark-inpark)*24*60) as walktime,"
						+ " to_char(inpark, 'YYYY-MM-DD') as tdate"
						+ " from walk where id = ? and incheck=0 order by seq desc";
		
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				
				// 3. statement 실행
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					WalkVO walk = new WalkVO();
					walk.setP_seq(rs.getString("p_seq"));
					walk.setSeq(rs.getString("seq"));
					walk.setSname(rs.getString("sname"));
					walk.setInpark(rs.getString("inpark"));
					walk.setOutpark(rs.getString("outpark"));
					walk.setWalktime(rs.getString("walktime"));
					walk.setTdate(rs.getString("tdate"));
				
					list.add(walk);
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
