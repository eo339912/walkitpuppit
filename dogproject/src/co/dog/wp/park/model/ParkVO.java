package co.dog.wp.park.model;

public class ParkVO {
	
	String SEQ;
	String SNAME;
	String X;
	String Y;
	String SPOTNUM;
	String SPOTNM;
	String SENTER;
	

	public String getSEQ() {
		return SEQ;
	}

	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}

	public String getSNAME() {
		return SNAME;
	}

	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}

	public String getX() {
		return X;
	}

	public void setX(String x) {
		X = x;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}

	public String getSPOTNUM() {
		return SPOTNUM;
	}

	public void setSPOTNUM(String sPOTNUM) {
		SPOTNUM = sPOTNUM;
	}

	public String getSPOTNM() {
		return SPOTNM;
	}

	public void setSPOTNM(String sPOTNM) {
		SPOTNM = sPOTNM;
	}

	public String getSENTER() {
		return SENTER;
	}

	public void setSENTER(String sENTER) {
		SENTER = sENTER;
	}

	@Override
	public String toString() {
		return "parkVO [SEQ=" + SEQ + ", SNAME=" + SNAME + ", X=" + X + ", Y=" + Y + ", SPOTNUM=" + SPOTNUM
				+ ", SPOTNM=" + SPOTNM + ", SENTER=" + SENTER + "]";
	}
	
	
	

}
