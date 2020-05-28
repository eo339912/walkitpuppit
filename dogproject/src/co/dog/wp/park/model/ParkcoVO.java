package co.dog.wp.park.model;

public class ParkcoVO {
	String pseq;
	String seq;
	String id;
	String comments;
	String regdt;

	public String getPseq() {
		return pseq;
	}

	public void setPseq(String pseq) {
		this.pseq = pseq;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRegdt() {
		return regdt;
	}

	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	@Override
	public String toString() {
		return "ParkcoVO [pseq=" + pseq + ", seq=" + seq + ", id=" + id + ", comments=" + comments + ", regdt=" + regdt
				+ "]";
	}
	
	
	
}
