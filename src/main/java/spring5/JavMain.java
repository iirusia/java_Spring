package spring5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavMain {

			public static void main(String[] args) {
				AnnotationConfigApplicationContext ctx =							//구현클래스 중 일부이다.
						new AnnotationConfigApplicationContext(AppContext.class);	//AnnootationConfigApplicationContext는 자바 설정에서 정보를 읽어와 빈객체를 생성하고 관리한다.
				Greeter g = ctx.getBean("greeter",Greeter.class);	//(빈객체의 이름-메소드이름,빈객체 타입.class)
				String msg = g.greet("스프링");	//객체에 선언된 메소드 사용
				System.out.println(msg);
				ctx.close();
				/*
				 * Greeter g2 = ctx.getBean("greeter",Greeter.class);
				 * System.out.println(g == g2)
				 * Singleton
				 *
				 * 
				 * 어떤 구현 클래스를 사용하든,각 구현 클래스는 설정 정보로부터 빈이라고 불리는 객체를 생성하고 그 객체를 내부에 보관한다. getBean()메서드를 실행하면 해당하는 빈 객체를 제공한다. 
				 * 별도에 설정을 하지 않을 경우 스프링은 한 개의 빈 객체만 생성하며 이때 빈 객체는 싱클톤 범위를 갖는다. 스프링은 기본적으로 한 개의 @Bean 애노테이션에 대해 한 개의 빈 객체를 생성한다.
				 * 
				 * 싱글톤에 장점
				 * 고정된 메모리 영역을 얻으면서 한 번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있다.
				 * 또한 싱글톤으로 만들어진 클래스의 인스턴스는 전역 인스턴이기 때문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉽다.
				 * 
				 * class CarCalss{
				 * 			private static CarClass car = new CarClass();
				 * 			
				 * 			private CarClass(){}
				 * 			public static CarClass getInstance(){
				 * 						return car;
				 * 					}
				 * 
				 * 
				 * 			private static CarClass car = new CarClass()
				 * 			를 통해 최초 한번만 객체를 생성하고 이후에 해당하는 getInstance메서드를 활용해 return 받아 사용
				 * 			한 곳에서만 사용이 가능하다.
				 * 			사용할 때
				 * 			CarClass car = CarClass.getInstance(); 
				 * */
			}
}
