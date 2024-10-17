package calculator.service;

import java.util.List;
import java.util.Set;

import calculator.constant.DrawConstant;
import calculator.dto.request.FormulaReq;
import calculator.dto.response.DelimitersDto;
import calculator.factory.DelimitersFactory;
import calculator.helper.ParseHelper;

public class DrawService {
	private final ParseHelper parseHelper;

	public DrawService() {
		this.parseHelper = new ParseHelper();
	}

	public DelimitersDto generateDelimiters(FormulaReq formulaReq) {
		Set<String> delimiters = DelimitersFactory.getDelimiters();
		if (formulaReq.formula().startsWith(DrawConstant.CUSTOM_DELIMITER_START_SIGN)) {
			String customDelimiter = parseHelper.extractCustomDelimiter(
				formulaReq.formula().substring(DrawConstant.EXTRACT_START_INDEX));
			delimiters.add(customDelimiter);
		}
		return DelimitersDto.from(delimiters);
	}

	public List<Long> drawNumbers(Set<String> delimiters, FormulaReq formulaReq) {
		return parseHelper.extractNumbers(delimiters, formulaReq.formula());
	}
}
