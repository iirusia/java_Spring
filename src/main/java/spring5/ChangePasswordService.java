package spring5;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
		//@Autowired를 붙이면 설정 클래스에서 의존을 주입하지 않아도 된다. 필드에 @Autowired 애노테이션이 붙어 있으면
		//스프링이 해당 타입의 빈 객체를  찾아서 필드에 할당한다 @Autowired는 메서드도 가능하고 변수에도 붙일 수 있다.
		@Autowired
		private MemberDao memberDao;
		
		public void changePassword(String email,String oldPwd,String newPwd) {
			Member member = memberDao.selectByEmail(email);
			if(member == null)
				throw new MemberNotFoundException();
			
			member.changePassword(oldPwd, newPwd);
			
			memberDao.update(member);
		
		}
		
		public void setMemberDao(MemberDao memberDao) {	//이 메서드로 의존하는 memberDao를 전달받는다 즉 setter를 통해서 의존 객체를 전달받는다.
			this.memberDao = memberDao;
		}
}

/*
 * 
 * 
 * */
