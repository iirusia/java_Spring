package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring5.ChangePasswordService;
import spring5.MemberDao;
import spring5.MemberInfoPrinter;
import spring5.MemberListPrinter;
import spring5.MemberPrinter;
import spring5.MemberRegisterService;
import spring5.MemberSummaryPrinter;
import spring5.VersionPrinter;

@Configuration		//스프링 설정 클래스
public class AppCtx {
	
		@Bean	//해당 메서드가 생성한 객체를 생성한 빈이라고 설정
		public MemberDao memberDao() {	//메서드 이름이 빈객체 이름이다
			return new MemberDao();
		//주입할 객체가 꼭 스프링 빈이어야 할 필요가 없다 MemberDao dao = new MemberDao(); 도 가능하다
			//하지만 이건 컨테이너가 객체를 관리하지 못해  getBean메서드로 호출불가능하다
		}
		//스프링 컨테이너가 생선한 Bean은 싱글톤 객체이다
		//스프링 컨테이너는 @Bean이 붙은 메서드에 대해 한 개의 객체만 생성
		//다른 설정메서드에서 memberDao()를 몇 번 호출하더라도 항상 같은 객체를 리턴
		
		
		@Bean
		public MemberRegisterService memberRegSvc() {
			return new MemberRegisterService(memberDao());
		}
		
		@Bean
		public ChangePasswordService changePwdSvc() {
			ChangePasswordService change = new ChangePasswordService();
			return change;
		}
//		@Bean
//		public MemberPrinter memberPrinter() {
//				return new MemberPrinter();
//		}
		@Bean
		@Qualifier("printer1")		//해당 빈의 한정 값으로 printer1로 지정 
		public MemberPrinter memberPrinter1() {	//이렇게 지정한 한정 값은 @Autowired 애노테이션에서 자동 주입할 빈을 한정할 때 사용한다.
			return new MemberPrinter();
		}
		@Bean
		@Qualifier("printer2")
		public MemberSummaryPrinter memberPrinter2() {
			return new MemberSummaryPrinter();
		}
		//자동 주입을 하려면 해당 타입을 가진 Bean이 어떤 Bean인지 정확하게 한정할 수 있어야 하는데
		//MemberPrinter 타입의 Bean이 두 개여서 어떤 빈을 자동 주입 대상으로 선택해야 할지 한정할 수 없다.
		//이 경우 스프링은 자동 주입에 실패하고 익셉션을 발생시킨다.
	
		
		@Bean
		public MemberListPrinter memberListPrinter() {
				return new MemberListPrinter();
		}
		
		@Bean
		public MemberInfoPrinter memberInfoPrinter() {
			MemberInfoPrinter info = new MemberInfoPrinter();
			return info;
		}
		
		@Bean
		public VersionPrinter versionPrinter() {
				VersionPrinter version = new VersionPrinter();
				version.setMajorVersion(5);
				version.setMinorVersion(0);
				return version;
		}

}
/*
 * 설정 클래스를 만들었다고 해서 끝난 것이 아님 객체를 생성하고 의존 객체를 주입하는 것은 스프링 컨테이너(IOC)이므로
 * 설정 클래스를 이용해서 컨테이너를 생성해야한다.
 * AnnotationConfigApplicationContext 클래스를 이용해 스프링 컨테이너 생성

 *컨테이너를 생성하면 getBean() 메서드를 이용해서 사용할 객체를 구할 수 있다. 
 *ApplicationContext ctx = new AnnotationConfiogApplicationContext(AppCtx.class);
 * MemberRegisterService regSvc = ctx.getBean("memberRegSvc",MemberRegisterService.class);
 * */
