package calculator.view;

public class Output {

	private static final String INITIAL_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
	private static final String RESULT_MESSAGE = "결과 : ";

	public void printInitialMessage() {
		System.out.println(INITIAL_MESSAGE);
	}

	public void printAnswerMessage(int answer) {
		System.out.println(RESULT_MESSAGE + answer);
	}
}
