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
		validateCustomDelimiterFormat(formula);
		return String.valueOf(formula.charAt(DrawConstant.CUSTOM_DELIMITER_INDEX));
	}
	public List<Long> extractNumbers(Set<String> delimiters, String formula) {
		if (delimiters.size() == DelimiterConstant.NO_CUSTOM_DELIMITER_LENGTH) {
			return Arrays.stream(formula.split(DelimiterConstant.NO_CUSTOM_DELIMITER_SPLIT_REGEX))
				.map(TypeConversion::convertStringToLong)
				.toList();
		}
		String excludedCustomDelimiterFormula = formula.substring(
			DrawConstant.CUSTOM_DELIMITER_FORMULA_NUMBER_START_INDEX);
		return Arrays.stream(
				excludedCustomDelimiterFormula.split(RegexGenerator.generateExtractNumberRegex(delimiters)))
			.map(TypeConversion::convertStringToLong)
			.toList();
	}

	private void validateCustomDelimiterFormat(String formula) {
		validateCustomDelimiterFormula(formula);
		validatePositiveNumberWithHyphenDelimiter(formula);
	}

	private static void validateCustomDelimiterFormula(String formula) {
		if (!(Pattern.matches(DrawConstant.CUSTOM_DELIMITER_FORMULA_REGEX, formula))) {
			throw new CalculatorException(ExceptionMessage.INVALID_CUSTOM_PREFIX);
		}
	}

	private void validatePositiveNumberWithHyphenDelimiter(String formula) {
		if(formula.contains(DrawConstant.INEVITABLE_CONTAINS_HYPHEN_FORMAT)){
			throw new CalculatorException(ExceptionMessage.NOT_POSITIVE_NUMBER);
		}
	}
}
