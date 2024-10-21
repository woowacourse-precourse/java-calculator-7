package calculator.system;

import calculator.system.exception.NegativeValueException;

public class TermValidator {

	public Long validateNegative(Long term) throws NegativeValueException {
		if (term < 0) {throw new NegativeValueException();}
		return term;
	}
}
