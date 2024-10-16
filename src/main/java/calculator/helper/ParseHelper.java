package calculator.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import calculator.constant.DrawConstant;
import calculator.exception.CalculatorException;
import calculator.exception.message.ExceptionMessage;

public class ParseHelper {
	public String extractCustomDelimiter(String formula) {
		validateCustomDelimiter(formula);
		return String.valueOf(formula.charAt(DrawConstant.CUSTOM_DELIMITER_INDEX));
	}

	public List<Long> extractNumbers(Set<String> delimiters, String formula) {
		List<Long> numbers = new ArrayList<>();

	}

	private void validateCustomDelimiter(String formula) {
		if (!formula.contains(DrawConstant.CUSTOM_DELIMITER_END_SIGN)) {
			throw new CalculatorException(ExceptionMessage.NOT_FOUND_CUSTOM_DELIMITER_END_SIGN);
		}
		if (!(formula.charAt(DrawConstant.BACK_SLASH_INDEX) == '\\' && formula.charAt(DrawConstant.N_INDEX) == 'n')) {
			throw new CalculatorException(ExceptionMessage.INVALID_CUSTOM_PREFIX);
		}
		if (Pattern.matches(DrawConstant.CUSTOM_DELIMITER_REGEX,
			String.valueOf(formula.charAt(DrawConstant.CUSTOM_DELIMITER_INDEX)))) {
			throw new CalculatorException(ExceptionMessage.INVALID_CUSTOM_PREFIX);
		}
	}
}
