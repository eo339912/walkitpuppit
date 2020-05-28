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
			String sql = "select * from park where spotnum = ? order by seq "; // 2.전체조회는 항상 오더바디 넣자
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			psmt.setString(1, spotnum); // 첫번재 물음표 값이 id다  // 3. 단건에서의 ? 빠졌으니 set도 필요없음
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				ParkVO vo = new ParkVO(); // 4. 위치 while 안으로
				vo.setSNAME(rs.getString("sname"));
				vo.setSENTER(rs.getString("senter"));
				vo.setSEQ(rs.getString("seq"));
				vo.setSPOTNM(rs.getString("spotnm"));// 결과값에 담기
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

}
