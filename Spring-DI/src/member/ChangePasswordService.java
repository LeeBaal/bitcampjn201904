package member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ChangePasswordService {
	
	//private MemberDao memberDao = new MemberDao();
	@Autowired
	@Qualifier("sys")
	private MemberDao memberDao;
	
	
	
	/*
	 * public ChangePasswordService(MemberDao dao) { memberDao = dao; }
	 */
	
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */



	public void changePassword(String email, String oldPassword, String newPassword) throws MemberNotfoundException, IdPasswordNotMatchingException {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotfoundException();
		}
		member.changePassword(oldPassword, newPassword);
		
		memberDao.update(member);
	}
	
}
