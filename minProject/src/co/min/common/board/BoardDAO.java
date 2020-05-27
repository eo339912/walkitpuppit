package co.min.common.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.min.common.DAO;

public class BoardDAO extends DAO{
	private PreparedStatement psmt;
	private ResultSet rs = null;
	private final String BOARD_SELECT_LIST = "select * from board";
	private final String BOARD_SELECT = "SELECT * FROM BOARD WHERE SEQ = ?";
	private final String border_insert = "insert into board values(board_seq.nextval, ? ,? ,? ,? ,?)";
	private final String BORD_UPDATE = "UPDATE BOARD SET TITLE = ?, CONTENTS = ?, REGDT = ?, ID = ?, FILENAME = ? WHERE SEQ = ?";
	private final String BOARD_DELDTE = "DELETE FROM BOARD WHRE SEQ = ?";
	
	public BoardDAO(){
		super();
	}
	
	public List<BoardVO> getSelectList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			psmt = conn.prepareStatement(BOARD_SELECT_LIST);
			rs = psmt.executeQuery();
			while(rs.next()){
				BoardVO vo =new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setId(rs.getString("id"));
				vo.setRegDt(rs.getDate("regDt"));
				vo.setFileName(rs.getString("fileName"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public BoardVO getSelect(BoardVO vo) {
		try {
			psmt = conn.prepareStatement(BOARD_SELECT);
			psmt.setInt(1, vo.getSeq());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setId(rs.getString("id"));
				vo.setRegDt(rs.getDate("regDt"));
				vo.setFileName(rs.getString("fileName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public void setBoardInsert(BoardVO vo) {
		
	}

	public void setBoardUpdate(BoardVO vo) {
		
	}
	
	public void setBoardDelete(BoardVO vo) {
		
	}
}
