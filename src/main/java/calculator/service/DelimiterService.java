package calculator.service;

import java.util.Set;

import calculator.constant.DrawConstant;
import calculator.dto.DelimitersDto;
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
		}
		return new DelimitersDto(delimiters);
	}

	private boolean isCustomDelimiterFormula(String formula) {
		return formula.startsWith(DrawConstant.CUSTOM_DELIMITER_START_SIGN);
	}
}
