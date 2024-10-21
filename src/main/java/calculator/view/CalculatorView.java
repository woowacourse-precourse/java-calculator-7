package calculator.view;

import calculator.service.InputService;

public class CalculatorView {

	private final InputService inputService;

	private static final String ADD_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
	private static final String RESULT_MESSAGE = "결과 : ";

	public CalculatorView(InputService inputService) {
		this.inputService = inputService;
	}

	public String getInput() {
		System.out.println(ADD_INPUT_MESSAGE);
		return inputService.readLine();
	}

	public void showResult(long result) {
		System.out.println(RESULT_MESSAGE + result);
	}
}
