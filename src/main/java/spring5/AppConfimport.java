package spring5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.AppConf2;
//2개 이상의 설정 파일을 사용하는 또 다른 방법은 @Import 애노테이션을 상요하는 것이다.
//@Import 애노테이션은 함께 사용할 설정 클래스를 짖어한다.
//AppConfiImport 설정 클래스를 사용하면 @Import 애노테이션으로 지정한 AppConf 설정 클래스도 함꼐
//사용하기 때문에 스프링 컨테이너를 생성할 때 AppConf2 설정클래스를 지정할 필요가 없다.
@Configuration
@Import(AppConf2.class)	//@Import({AppConf1.class,AppConf2.class}) 2개도 가능
public class AppConfimport {
		@Bean
		public MemberDao memberDao() {
			return new MemberDao();
		}
		@Bean
		public MemberPrinter memberPrinter() {
			return new MemberPrinter();
		}
}
