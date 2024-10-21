package calculator.system;

import calculator.console.exception.OperationOutOfBoundsException;
import java.util.List;

public class ExpressionOperator {

	private final DelimiterParser delimiterParser;

	public ExpressionOperator() {
		delimiterParser = new DelimiterParser();
	}

	public Long sum(String expression) {
		List<Long> terms = delimiterParser.extractTerms(expression);
		return terms.stream().reduce(Long::sum).orElseThrow(
				OperationOutOfBoundsException::new);
	}
}
