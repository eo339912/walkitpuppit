package co.dog.wp.board.model;

public class CommentsVO {
	String id;
	String regdt;
	String seq;
	String commentsO;
	String b_seq;
	String cnt;
	
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCommentsO() {
		return commentsO;
	}
	public void setCommentsO(String commentsO) {
		this.commentsO = commentsO;
	}
	public String getB_seq() {
		return b_seq;
	}
	public void setB_seq(String b_seq) {
		this.b_seq = b_seq;
	}
	@Override
	public String toString() {
		return "CommentsVO [id=" + id + ", regdt=" + regdt + ", seq=" + seq + ", commentsO=" + commentsO + ", b_seq="
				+ b_seq + "]";
	}
	
	
}
