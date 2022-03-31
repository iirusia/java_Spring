package assembler;

import spring5.ChangePasswordService;
import spring5.MemberDao;
import spring5.MemberRegisterService;


/*
 * Assembler 클래스를 사용하는 코드는 다음처럼 Assembler 객체를 생성하고 그 다음 get메소드를 이용해서 필요한 객체르 구하고 그 객체를 사용할 수 있따
 * Assembler assembler = new Assembler();
 * ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
	여기서 보면 ChangePasswordService는 memberDao도 주입 받아야한다. setter로 주입받는 형식으로 선언했는데 이미 Assembler 생성자에서 주입을 하였기 때문에
	굳이 setter 메소드를 설정할 필요도 없다. -생성자에서 주입받음
 * 
 * MemberDao dao = assembler.getMemberDao();
 * MemberDao 클래스가 아니라 MemberDao 클래스를 상속받은 CachedMemberDao 클래스를 사용해야 한다면 Assembler에서 객체를 초기화하는 코드만 변경하면 된다.
 * 생성자 부분에 memberDao = new MemberDao()를
 * 			memberDao = new CachedmemberDao()로 변경하면 된다. 그러면 이걸 사용한 다른 클래스에서 자동으로 적용된다.
 * 
 * 주입을 받지 않고 바로 선언과 동시에 데이터를 주입하면 그 클래스를 사용하는 곳에서는 값을 변경하기 까다로움 그래서 의존주입 형태로 하면 좋다
 * 형태는 생성자를 하는 방식과 setter를 하는 방식이다
 * MemberRegisterService 는 생성자형식이고
 * ChangePasswordService는 setter를 사용 
 * 
 * */
public class Assembler {
		private MemberDao memberDao;
		private MemberRegisterService regSvc;
		private ChangePasswordService pwdSvc;
		
		public Assembler() {
			memberDao = new MemberDao();
			regSvc = new MemberRegisterService(memberDao);
			pwdSvc = new ChangePasswordService();
			pwdSvc.setMemberDao(memberDao);
		}

		public MemberDao getMemberDao() {
			return memberDao;
		}


		public MemberRegisterService getMemberRegisterService() {
			return regSvc;
		}


		public ChangePasswordService getChangePasswordService() {
			return pwdSvc;
		}

		
}
