package spring5;

public class Greeter {
		private String format;

		public String greet(String guest) {
			return String.format(format, guest);
			//문자열에 있는 하나 이상의 형식 항목을 지정된 개체의 문자열 표현으로 바꿉니다.
		}
		
		public void setFormat(String format) {
			this.format = format;
		}
		
		
		
		
		
}
