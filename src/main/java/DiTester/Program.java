package DiTester;

public class Program {
		private Com mac;
		
		public Program(Com com) {
			this.mac = com;
		}
		
		public void StartMacBook() {
			this.mac.boot();
		}
}

/*
 * 이 코드에서 boot 메서드를 호출하기 위해서는 IMacBook() 클래스가 필요로 한다 여기서 
 * Program클래스는 IMacBook 클래스의 의존성은 가진다고 말할 수 있다. 하지만
 * 위 코드는 의존성을 Program클래스 내에서 생성한다.
 * 위와 같이 코드를 작성하면, 코드의 재활용성이 떨어지고 MacBook클래스를 수정하면 Program클래스도 수정해야하는
 * 문제가 발생한다. 지금은 하나의 클래스지만 숨낳은 클래스에서 IMacBook을 사용하면 하나씩 수정해야 하는 이슈가 있다
 * 그리고 Test 코드가 어려워짐 그래서 DI를 적용하면
 * 
 * @Autowired
 * public Program(Com mac){
 * 			this.mac = mac;
 * }
 * */
