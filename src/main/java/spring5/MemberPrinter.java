package spring5;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberPrinter {
		private DateTimeFormatter dateTimeFormatter;
		
		public MemberPrinter() {
			dateTimeFormatter  = DateTimeFormatter.ofPattern("yyyy년 MM년 dd일");
		}
		public void print(Member member) {
				if(dateTimeFormatter == null) {
					System.out.printf(
							"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
							member.getId(), member.getEmail(),
							member.getName(), member.getRegisterDateTime());			
				}else {
				System.out.printf(
						"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", 
						member.getId(), member.getEmail(),
						member.getName(),
						dateTimeFormatter.format(member.getRegisterDateTime()));
				}
				}
		@Autowired(required=false)	//Autowired 애노테이션은 기본적으로 @Autowired 애노테이션을 붙인 타입을 해당하는 빈이 존재하지 않으면 익셉션발생
		public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {//그래서 자동 주입할 대상이 필수가 아니면 required = false로 지정
				this.dateTimeFormatter = dateTimeFormatter;
		}
}
