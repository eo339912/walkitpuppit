package co.dog.wp.park.model;

public class ParkVO {
	
	String seq;
	String sname;
	String x;
	String y;
	String spotnum;
	String spotnm;
	String senter;
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getSpotnum() {
		return spotnum;
	}
	public void setSpotnum(String spotnum) {
		this.spotnum = spotnum;
	}
	public String getSpotnm() {
		return spotnm;
	}
	public void setSpotnm(String spotnm) {
		this.spotnm = spotnm;
	}
	public String getSenter() {
		return senter;
	}
	public void setSenter(String senter) {
		this.senter = senter;
	}
	@Override
	public String toString() {
		return "ParkVO [seq=" + seq + ", sname=" + sname + ", x=" + x + ", y=" + y + ", spotnum=" + spotnum
				+ ", spotnm=" + spotnm + ", senter=" + senter + "]";
	}
	

	
	

}
