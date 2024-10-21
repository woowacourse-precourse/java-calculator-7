package calculator.view;

import static calculator.view.PrintMessage.*;

public class OutputView {
	public void printReadCommand() {
		System.out.println(READ_COMMAND.getMessage());
	}

	public void printResult(int result) {
		System.out.printf((RESULT.getMessage()), result);
	}
}
