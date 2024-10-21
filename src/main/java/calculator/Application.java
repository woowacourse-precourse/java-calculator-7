package calculator;

public class Application {
	private static final char DELIMITER_COMMA = ',';
	private static final char DELIMITER_COLON = ':';
	
	//커스텀 구분자를 도출하는 함수
	//커스텀 구분자가 없을 경우, 0을 반환
	//입력 포맷이 잘못되었을 경우, 예외 처리
	private static char getCustomDelimiter(String inputString) {
		//1.
		//커스텀 구분자를 가질 수 없는 경우
		if (inputString.length() < 4)
			return 0;
		
		//2.
		//커스텀 구분자를 가지는 경우
		char customDelimiter = inputString.charAt(2);
		String inputFormat = inputString.substring(0, 4);
		String correctFormat = String.format("//%c\n", customDelimiter);
		if (inputFormat.equals(correctFormat))
			return customDelimiter;

		//3.
		//입력이 잘못된 경우
		char inputCharacter;
		for (int i = 0; i < 4; i++) {
			inputCharacter = inputFormat.charAt(i);
			if (('0' <= inputCharacter && inputCharacter <= '9') ||
					inputCharacter == DELIMITER_COMMA ||
					inputCharacter == DELIMITER_COLON) {
				continue;
			} else {
				throw new IllegalArgumentException();
			}
		}
		
		//4.
		//커스텀 구분자가 없는 경우
		return 0;
	}
	
    public static void main(String[] args) {
        System.out.println(getCustomDelimiter("//a\n001230,0456:08792"));
    }
}
