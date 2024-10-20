package calculator.service;

import java.util.List;

import calculator.constant.DelimiterConstant;
import calculator.constant.DrawConstant;
import calculator.dto.DelimitersDto;
import calculator.dto.FormulaDto;
import calculator.dto.NumbersDto;
import calculator.helper.ParseHelper;
import calculator.util.RegexGenerator;

public class DrawService {
	private final ParseHelper parseHelper;

	public DrawService() {
		this.parseHelper = new ParseHelper();
	}

	public NumbersDto drawNumbers(FormulaDto formulaDto, DelimitersDto delimiters) {
		String formula = formulaDto.formula();

		String regex = DelimiterConstant.NO_CUSTOM_DELIMITER_SPLIT_REGEX;
		if (!(delimiters.delimiters().size() == DelimiterConstant.NO_CUSTOM_DELIMITER_LENGTH)) {
			formula = formulaDto.formula().substring(
				DrawConstant.CUSTOM_DELIMITER_FORMULA_NUMBER_START_INDEX);
			regex = RegexGenerator.generateCustomDelimiterContainsRegex(delimiters.delimiters());
		}

		List<Long> numbers = parseHelper.extractNumbers(formula, regex);

		return new NumbersDto(numbers);
	}
}
