package calculator;

import calculator.console.InputView;
import calculator.console.OutputView;
import calculator.exception.InvalidInputException;
import calculator.exception.SystemException;
import calculator.system.DelimiterParser;
import java.util.List;
import java.util.function.Supplier;

public class UserConsoleView {
	private final InputView inputView;
	private final OutputView outputView;
	private final DelimiterParser delimiterParser;
	private final Calculator calculator;

	public UserConsoleView() {
		inputView = new InputView();
		outputView = new OutputView();
		delimiterParser = new DelimiterParser();
		calculator = new Calculator();
	}

	public void run() {
		String expression = getExpression();
		List<Long> terms = delimiterParser.extractTerms(expression);
		Long result = calculator.sum(terms);
		outputView.printOperationResult(result);
	}

	public String getExpression() {
		return getUserInput(() -> {
			outputView.printExpressionRequestMessage();
			return inputView.readConsole();
		});
	}

	public <T> T getUserInput(Supplier<T> inputReader) {
		try {
			return inputReader.get();
		} catch (SystemException | IllegalArgumentException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
}
