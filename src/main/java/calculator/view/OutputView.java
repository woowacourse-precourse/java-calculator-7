package calculator.view;

import calculator.enums.Message;

public class OutputView {
	public void printStartMessage() {
		System.out.println(Message.START_MESSAGE);
	}

	public void printErrorMessage(String errorMessage) {
		System.out.println("ERROR: " + errorMessage);
	}

	public void printResult(int result) {
		System.out.println(Message.RESULT_PREFIX + result);
	}

}
