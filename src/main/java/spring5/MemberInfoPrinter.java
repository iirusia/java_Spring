package spring5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	
		//두 필드에 @Autowired 애노테이션을 붙였다. 이렇게 Autowired 애노테이션을 의존 주입대상에 붙이면
	//	스프링 설정 클래스의 @Bean 메서드에서 의존 주입을 위한 코드를 작성하지 않아도 된다.
		private MemberDao memberDao;
		private MemberPrinter printer;
		
		public void printMemberInfo(String email) {
			Member member = memberDao.selectByEmail(email);
			if(member == null) {
				System.out.println("데이터없음\n");
				return;
			}
			printer.print(member);
			System.out.println();
		}
		
		@Autowired
		public void setMemberDao(MemberDao memberDao) {
			this.memberDao =memberDao;
		}
		@Autowired
		@Qualifier("printer2")
		public void setMemberPrinter(MemberPrinter printer) {
			this.printer = printer;
		}
}
