package calculator.console;

import static calculator.console.ConsolePrefix.INPUT_REQUEST_PREFIX;
import static calculator.console.ConsolePrefix.RESULT_RESPONSE_PREFIX;

public class OutputView {

	public void printOperationResult(Long operationResult) {
		printMessage(RESULT_RESPONSE_PREFIX.getMessage() + operationResult);
	}

	public void printExpressionRequestMessage() {
		printMessage(INPUT_REQUEST_PREFIX.getMessage());
	}

	private void printMessage(String message) {
		System.out.println(message);
	}
}
