package calculator;

import calculator.console.InputView;
import calculator.console.OutputView;
import calculator.system.ExpressionOperator;
import calculator.system.exception.InvalidInputException;
import java.util.function.Supplier;

public class CalculatorSystem {

	private final InputView inputView;
	private final OutputView outputView;
	private final ExpressionOperator expressionOperator;

	public CalculatorSystem() {
		inputView = new InputView();
		outputView = new OutputView();
		expressionOperator = new ExpressionOperator();
	}

	public void run() {
		String expression = getExpression();
		Long result = expressionOperator.sum(expression);
		outputView.printOperationResult(result);
	}

	public String getExpression() {
		return getUserInput(() -> {
			outputView.printExpressionRequestMessage();
			return inputView.readConsole();
		});
	}

	public <T> T getUserInput(Supplier<T> inputReader) throws InvalidInputException {
		try {
			return inputReader.get();
		} catch (IllegalArgumentException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
}
