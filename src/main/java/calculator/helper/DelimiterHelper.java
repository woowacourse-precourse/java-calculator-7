package calculator.helper;

import java.util.regex.Pattern;

import calculator.constant.DrawConstant;
import calculator.exception.CalculatorException;
import calculator.exception.message.ExceptionMessage;

public class DelimiterHelper {
	public String extractCustomDelimiter(String formula) {
		validateCustomDelimiterFormat(formula);
		return String.valueOf(formula.charAt(DrawConstant.CUSTOM_DELIMITER_INDEX));
	}

	private void validateCustomDelimiterFormat(String formula) {
		validateCustomDelimiterFormula(formula);
		validatePositiveNumberWithHyphenDelimiter(formula);
	}

	private static void validateCustomDelimiterFormula(String formula) {
		if (!(Pattern.matches(DrawConstant.CUSTOM_DELIMITER_FORMULA_REGEX, formula))) {
			throw new CalculatorException(ExceptionMessage.INVALID_FORMAT_ERROR);
		}
	}

	private void validatePositiveNumberWithHyphenDelimiter(String formula) {
		if(formula.contains(DrawConstant.INEVITABLE_CONTAINS_HYPHEN_FORMAT)){
			throw new CalculatorException(ExceptionMessage.NOT_POSITIVE_NUMBER);
		}
	}
}
