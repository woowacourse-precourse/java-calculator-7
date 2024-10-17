package calculator.helper;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import calculator.constant.DelimiterConstant;
import calculator.constant.DrawConstant;
import calculator.exception.CalculatorException;
import calculator.exception.message.ExceptionMessage;
import calculator.util.RegexGenerator;
import calculator.util.TypeConversion;

public class ParseHelper {
	public String extractCustomDelimiter(String formula) {
		validateCustomDelimiter(formula);
		return String.valueOf(formula.charAt(DrawConstant.CUSTOM_DELIMITER_INDEX));
	}

	public List<Long> extractNumbers(Set<String> delimiters, String formula) {
		if (delimiters.size() == DelimiterConstant.NO_CUSTOM_DELIMITER_LENGTH) {
			return Arrays.stream(formula.split(DelimiterConstant.NO_CUSTOM_DELIMITER_SPLIT_REGEX))
				.map(TypeConversion::convertStringToLong)
				.toList();
		}
		String excludedCustomDelimiterFormula = formula.substring(
			formula.indexOf(DrawConstant.CUSTOM_DELIMITER_END_SIGN) + DrawConstant.NEXT_INDEX);
		return Arrays.stream(
				excludedCustomDelimiterFormula.split(RegexGenerator.generateExtractNumberRegex(delimiters)))
			.map(TypeConversion::convertStringToLong)
			.toList();
	}

	private void validateCustomDelimiter(String formula) {
		if (!formula.contains(DrawConstant.CUSTOM_DELIMITER_END_SIGN)) {
			throw new CalculatorException(ExceptionMessage.NOT_FOUND_CUSTOM_DELIMITER_END_SIGN);
		}
		if (!(formula.charAt(DrawConstant.BACK_SLASH_INDEX) == DrawConstant.BACK_SLASH
			&& formula.charAt(DrawConstant.N_INDEX) == DrawConstant.N)) {
			throw new CalculatorException(ExceptionMessage.INVALID_CUSTOM_PREFIX);
		}
		if (!(Pattern.matches(DrawConstant.CUSTOM_DELIMITER_REGEX,
			String.valueOf(formula.charAt(DrawConstant.CUSTOM_DELIMITER_INDEX))))) {
			throw new CalculatorException(ExceptionMessage.INVALID_CUSTOM_PREFIX);
		}
	}
}
