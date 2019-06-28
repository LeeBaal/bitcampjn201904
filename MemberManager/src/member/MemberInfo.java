package member;

import java.util.Date;

public class MemberInfo {
	
	private String uId;
	private String uPw;
	private String uName;
	private String uPhoto;
	private Date regDate;
	
	public MemberInfo() {
		this.regDate = new Date();
	}

	public MemberInfo(String uId, String uPw, String uName, String uPhoto) {
		super();
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uPhoto = uPhoto;
		this.regDate = new Date();
	}
	
	
	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPw(String uPw) {
		this.uPw = uPw;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}

	

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberInfo [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uPhoto=" + uPhoto + ", reDate="
				+ regDate + "]";
	}
	
	
	// MemberInfo 객체 -> LoginInfo 객체 반환
	public LoginInfo toLoginInfo() {
		
		return new LoginInfo(uId, uName, uPhoto, regDate);
		
	}
	
	
	
	
}
