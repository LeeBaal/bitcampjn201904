package member;

import java.util.Date;

public class MemberInfo {
	
	private String uId;
	private String uPw;
	private String uName;
	private String uPhoto;
	private Date reDate;
	
	public MemberInfo() {
		this.reDate = new Date();
	}

	public MemberInfo(String uId, String uPw, String uName, String uPhoto) {
		super();
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uPhoto = uPhoto;
		this.reDate = new Date();
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

	public Date getReDate() {
		return reDate;
	}

	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}

	@Override
	public String toString() {
		return "MemberInfo [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uPhoto=" + uPhoto + ", reDate="
				+ reDate + "]";
	}
	
	
	// MemberInfo 객체 -> LoginInfo 객체 반환
	public LoginInfo toLoginInfo() {
		
		return new LoginInfo(uId, uName, uPhoto);
		
	}
	
	
	
	
}
