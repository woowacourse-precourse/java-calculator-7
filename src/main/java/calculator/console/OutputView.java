package calculator.console;

import calculator.system.SystemMessages;

public class OutputView {

	public void printOperationResult(Long operationResult) {
		printMessage(SystemMessages.RESULT_RESPONSE_PREFIX.getMessage() + operationResult);
	}

	public void printMessage(String message) {
		System.out.println(message);
	}
}
