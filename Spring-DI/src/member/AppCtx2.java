package member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx2 {
	
	@Bean(name = "memberDao")
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
	
	@Bean
	public BoardDao getBoardDao() {
		return new BoardDao();
	}
	
	
	@Bean(name = "registService2")
	public MemberRegisterService2 getMemberRegisterService2() {
		
		MemberRegisterService2 service = new MemberRegisterService2();
		//주입
		//service.setMemberDao(getMemberDao());
		return service;
		
		/* return new MemberRegisterService2(getMemberDao()); */
	}
	
	@Bean(name = "changePwService2")
	public ChangePasswordService2 getChangePasswordService2() {
		
		ChangePasswordService2 service = new ChangePasswordService2();
		// 주입
		//service.setMemberDao(getMemberDao());
		
		return service;
		/* return new ChangePasswordService2(getMemberDao()); */
	}
	
}