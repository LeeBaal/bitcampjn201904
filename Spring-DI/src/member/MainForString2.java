package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForString2 {
	
	/* private static Assembler assembler = new Assembler(); */
	
	/*
	 * private static MemberRegisterService registerService =
	 * assembler.getRegistService();
	 */
	//스프링 컨테이너 생성 : 조립기 설정파일 appCtx1.xml
	private static ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx6.xml");
	
	public static void main(String[] args){
		
		System.out.println("스프링 컨테이너에서 받은 객체");
		System.out.println("");
		MemberRegisterService registerService1 = ctx.getBean("registService", MemberRegisterService.class);
		MemberRegisterService registerService2 = ctx.getBean("registService", MemberRegisterService.class);
		// 참조변수 비교 : 참조 주소값을 비교
		boolean chk = registerService1 == registerService2;
		
		
		System.out.println("registerService1 == registerService2 : "+chk);
		
		System.out.println("==========================================");
		
		System.out.println("");
		System.out.println("스프링 컨테이너에서 받은 객체");
		System.out.println("");
		
		ChangePasswordService passwordService1 = ctx.getBean("changePwService",ChangePasswordService.class);
		ChangePasswordService passwordService2 = ctx.getBean("changePwService",ChangePasswordService.class);
		
		chk = passwordService1 == passwordService2;
		
		System.out.println("passwordService1 == passwordService2 : "+chk);
		
		
		
		
		
	}

	private static void processNewCommand(String[] args) {
		
		if(args.length != 5) {
			printHelp();
			return;
		}
		
		/* MemberRegisterService service = assembler.getRegistService(); */
		MemberRegisterService service = ctx.getBean("registService", MemberRegisterService.class);
		
		
		RegisterRequest request = new RegisterRequest();
		request.setEmail(args[1]);
		request.setName(args[2]);
		request.setPassword(args[3]);
		request.setConfirmPassword(args[4]);
		if(!request.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호 확인이 일치하지 않습니다.");
			return;
		}
		
		try {
			service.regist(request);
			System.out.println("등록되었습니다.");
		} catch (AleadyExistingMemberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("이미 존재하는 이메일입니다.");
		}
		
	}


	private static void processChangeCommand(String[] args) {
		
		if(args.length != 4) {
			printHelp();
			return;
			
		}
		
		/* ChangePasswordService service = assembler.getPsService(); */
		ChangePasswordService service = ctx.getBean("changePwService", ChangePasswordService.class);
		
		try {
			service.changePassword(args[1],args[2],args[3]);
			System.out.println("암호가 변경되었습니다.");
		} catch (MemberNotfoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("존재하지 않는 이메일 입니다.");
		} catch (IdPasswordNotMatchingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("이메일과 암호가 일치하지 않습니다.");
		}
		
		
	}
	
	
	private static void printHelp() {
		
		System.out.println("");
		System.out.println("잘못된 명령 입니다. 아래 명령 사용법을 확인하세요.");
		System.out.println("new 이메일 사용자이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 새로운암호");
	}
	
}
