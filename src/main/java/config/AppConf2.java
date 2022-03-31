package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring5.ChangePasswordService;
import spring5.MemberDao;
import spring5.MemberInfoPrinter;
import spring5.MemberListPrinter;
import spring5.MemberPrinter;
import spring5.MemberRegisterService;
import spring5.VersionPrinter;
/*
 * @Autowired는 스프링의 자동 주입 기능을 위한 것이다
 * 의존주입 스프링 설정 클래스의 필드에 @Autowired 애노테이션을 붙이면 해당 타입의 빈을
 * 찾아서 필드에 할당한다. 
 * 스프링 컨테이너는 MemberDao 타입의 Bean을 memberDao필드에 할당
 * AppConf1 클래스에 MemberDao 타입의 빈을 설정했으므로 AppConf2 클래스의 
 * memberDao필드에 AppConf1 클래스에서 설장한 빈이 할당
 * 
 * @Autowired 애노테이션을 이용해서 다른 설정 파일에 정의한 빈을 필드에 할당
 * 설정 메서드에서 이 플드를 사용해서 필요한 빈을 주입하면도니다.
 * 
 * 설정 클래스가 두 개이면 스프링 컨테이너를 생성할 때
 * ctx = new AnnotationConfigApplicationContext(AppConf1.class,AppConf2.class);
 * 인자 두 개
 * AnnotationConfigApplicationContext의 생성자는 가변인자이기 때문에
 * 클래스 목록을 콤마로 구분해서 전달하면 된다.
 * @Autowired 애노테이션은 스프링 빈에 의존하는 다른 빈을 자동으로 주입하고
 * 싶을 때 사용한다.
 * */

@Configuration
public class AppConf2 {
		
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		return pwdSvc;
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
			return new MemberListPrinter();
		}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setMemberPrinter(memberPrinter);
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}

}
