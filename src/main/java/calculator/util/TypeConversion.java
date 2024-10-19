package calculator.util;

import calculator.exception.CalculatorException;
import calculator.exception.message.ExceptionMessage;

public class TypeConversion {
	public static Long convertStringToLong(String value) {
		try {
			long parsedNumber = Long.parseLong(value);
			validateNumber(parsedNumber);
			return parsedNumber;
		} catch (NumberFormatException e) {
			throw new CalculatorException(ExceptionMessage.NOT_NUMBER);
		} catch (ArithmeticException e) {
			throw new CalculatorException(ExceptionMessage.OUT_OF_BOUNDS);
		}
	}

	protected static void validateNumber(long number) {
		validatePositiveNumber(number);
	}

	protected static void validatePositiveNumber(long number) {
		if (number < 0) {
			throw new CalculatorException(ExceptionMessage.NOT_POSITIVE_NUMBER);
		}
	}

}
