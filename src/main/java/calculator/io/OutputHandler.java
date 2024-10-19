package calculator.io;

public class OutputHandler {
	private static final String PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
	private static final String RESULT_PREFIX_MESSAGE = "결과 : ";

	private OutputHandler() {
	}

	public static OutputHandler create() {
		return new OutputHandler();
	}

	public void showPromptMessage() {
		System.out.println(PROMPT_MESSAGE);
	}

	public void showCalculateResult(int sum) {
		System.out.println(RESULT_PREFIX_MESSAGE + sum);
	}
}
