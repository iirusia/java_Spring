package spring5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration			//Configuration 애노테이션은 해당 클래스를 스프링 설정 클래스로 지정한다.
public class AppContext {
	
					//애노테이션은 추가정보를 알려주는 용도이다.
			@Bean	//스프링이 생성하는 객체를 Bean객체라고 부르는데 이 Bean객체는 애노테이션으로 정부를 만든다.
			public Greeter greeter() {	//Bean 객체는 메서드 이름으로 빈 객체를 참조할 때 사용된다.
				Greeter g = new Greeter();
				g.setFormat("%s 안녕하세요");
				return g;
			}
}
