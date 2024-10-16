package calculator.util;

import calculator.exception.CalculatorException;
import calculator.exception.message.ExceptionMessage;

public class TypeConversion {
	public static Long convertStirngToLong(String value) {
		try {
			return Long.parseLong(value);
		} catch(NumberFormatException e) {
			throw new CalculatorException(ExceptionMessage.NOT_NUMBER);
		}
	}
}
