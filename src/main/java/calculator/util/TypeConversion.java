package calculator.util;

import calculator.exception.CalculatorException;
import calculator.exception.message.ExceptionMessage;

public class TypeConversion {
	public static Long convertStringToLong(String value) {
		try {
			Long parsedNumber = Long.parseLong(value);
			if (parsedNumber < 0) {
				throw new CalculatorException(ExceptionMessage.NOT_POSITIVE_NUMBER);
			}
			return parsedNumber;
		} catch (NumberFormatException e) {
			throw new CalculatorException(ExceptionMessage.NOT_NUMBER);
		}
	}
}
