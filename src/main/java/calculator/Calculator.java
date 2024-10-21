package calculator;

import calculator.exception.OperationOutOfBoundsException;
import calculator.system.DelimiterParser;
import java.util.List;

public class Calculator {
	private DelimiterParser delimiterParser;

	public Long sum(String expression) {
		List<Long> terms = delimiterParser.extractTerms(expression);
		return terms.stream().reduce(Long::sum).orElseThrow(
				OperationOutOfBoundsException::new);
	}
}
