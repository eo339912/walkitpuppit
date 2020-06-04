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

}
