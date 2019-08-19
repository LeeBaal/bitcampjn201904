package member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx1 {
	
	@Bean(name = "memberDao")
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
	
}