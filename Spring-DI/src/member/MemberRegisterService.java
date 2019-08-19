package member;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberRegisterService {
	@Autowired
	@Qualifier("sys")
	private MemberDao memberDao;
	
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */
	
	/*
	 * public MemberRegisterService(MemberDao memberDao) { this.memberDao =
	 * memberDao; }
	 */
	
	public void regist(RegisterRequest request) throws AleadyExistingMemberException {
		Member member = memberDao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new AleadyExistingMemberException();
		}
		
		Member newMember = new Member(
				request.getEmail(), 
				request.getPassword(), 
				request.getName(), 
				new Date());
		
		memberDao.insert(newMember);
	}
}
