package co.dog.wp.park.model;

public class WalkVO {
String seq;
String p_seq;
String id;
String inpark;
String outpark;
String incheck;
String sname;
String walktime;




public String getWalktime() {
	return walktime;
}
public void setWalktime(String walktime) {
	this.walktime = walktime;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSeq() {
	return seq;
}
public void setSeq(String seq) {
	this.seq = seq;
}
public String getP_seq() {
	return p_seq;
}
public void setP_seq(String p_seq) {
	this.p_seq = p_seq;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getInpark() {
	return inpark;
}
public void setInpark(String inpark) {
	this.inpark = inpark;
}
public String getOutpark() {
	return outpark;
}
public void setOutpark(String outpark) {
	this.outpark = outpark;
}
public String getIncheck() {
	return incheck;
}
public void setIncheck(String incheck) {
	this.incheck = incheck;
}
@Override
public String toString() {
	return "WalkVO [seq=" + seq + ", p_seq=" + p_seq + ", id=" + id + ", inpark=" + inpark + ", outpark=" + outpark
			+ ", incheck=" + incheck + "]";
}


}
