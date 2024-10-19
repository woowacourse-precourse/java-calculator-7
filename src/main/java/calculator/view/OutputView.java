package calculator.view;

import calculator.constant.SystemMessage;

public class OutputView {
	public void printResult(Long result) {
		System.out.printf(SystemMessage.RESULT_FORMAT + SystemMessage.ENTER, result);
	}
}
