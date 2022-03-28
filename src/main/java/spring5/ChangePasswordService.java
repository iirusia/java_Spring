package spring5;

public class ChangePasswordService {
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
