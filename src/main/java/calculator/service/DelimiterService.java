package calculator.service;

import java.util.Set;
import java.util.regex.Pattern;

import calculator.constant.DrawConstant;
import calculator.dto.DelimitersDto;
import calculator.exception.CalculatorException;
import calculator.exception.message.ExceptionMessage;
import calculator.factory.DelimitersFactory;
import calculator.helper.DelimiterHelper;

public class DelimiterService {
	private final DelimiterHelper delimiterHelper;

	public DelimiterService() {
		this.delimiterHelper = new DelimiterHelper();
	}

	public DelimitersDto generateDelimiters(String formula) {
		Set<String> delimiters = DelimitersFactory.getDelimiters();
		if (isCustomDelimiterFormula(formula)) {
			String customDelimiter = delimiterHelper.extractCustomDelimiter(formula);
			delimiters.add(customDelimiter);
			return new DelimitersDto(delimiters);
		}
		validateFormula(formula);
		return new DelimitersDto(delimiters);
	}

	private void validateFormula(String formula) {
		if (!(Pattern.matches(DrawConstant.FORMULA_REGEX, formula))) {
			throw new CalculatorException(ExceptionMessage.INVALID_FORMAT_ERROR);
		}
	}

	private boolean isCustomDelimiterFormula(String formula) {
		return formula.startsWith(DrawConstant.CUSTOM_DELIMITER_START_SIGN);
	}
}
