package member;

public class LoginInfo {

	private String uId;
	private String uName;
	private String uPhoto;
	
	public LoginInfo(String uId, String uName, String uPhoto) {
		this.uId = uId;
		this.uName = uName;
		this.uPhoto = uPhoto;
	}
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
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

	@Override
	public String toString() {
		return "LoginInfo [uId=" + uId + ", uName=" + uName + ", uPhoto=" + uPhoto + "]";
	}
	
	
}
