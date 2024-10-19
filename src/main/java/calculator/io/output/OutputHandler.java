package calculator.io.output;

public class OutputHandler {

	private static final String ADD_NUMBERS_INPUT_COMMENT = "덧셈할 문자열을 입력해 주세요.";
	private static final String RESULT_COMMENT = "결과 : ";

	public void askAddNumbers() {
		System.out.println(ADD_NUMBERS_INPUT_COMMENT);
	}

	public void showResult(long result) {
		System.out.println(RESULT_COMMENT + result);
	}

}
