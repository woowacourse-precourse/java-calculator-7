package calculator;

import calculator.exception.OperationOutOfBoundsException;
import java.util.List;

public class Calculator {
	public Long sum(List<Long> terms) {
		return terms.stream().reduce(Long::sum).orElseThrow(
				OperationOutOfBoundsException::new);
	}
}
