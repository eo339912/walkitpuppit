package co.dog.wp.member.model;

public class MemberVO {
	String seq;
	String id;
	String pwd;
	String name;
	String thumd;
	String regdt;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getThumd() {
		return thumd;
	}
	public void setThumd(String thumd) {
		this.thumd = thumd;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	@Override
	public String toString() {
		return "MemberVO [seq=" + seq + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", thumd=" + thumd
				+ ", regdt=" + regdt + "]";
	}
	
	
	
}
