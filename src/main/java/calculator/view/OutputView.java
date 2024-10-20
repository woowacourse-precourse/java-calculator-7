package calculator.view;

import calculator.constants.Message;

public class OutputView {
	public void printStartMessage() {
		System.out.println(Message.START_MESSAGE);
	}

	public void printErrorMessage(String errorMessage) {
		System.out.println(Message.ERROR_PREFIX + errorMessage);
	}

	public void printResult(int result) {
		System.out.println(Message.RESULT_PREFIX + result);
	}

}
