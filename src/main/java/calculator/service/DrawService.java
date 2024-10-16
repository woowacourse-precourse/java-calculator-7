package calculator.service;

import java.util.List;

import calculator.dto.FormulaReq;
import calculator.helper.ParseHelper;

public class DrawService {
	private final ParseHelper parseHelper;

	public DrawService() {
		this.parseHelper = new ParseHelper();
	}
	public List<Long> drawNumbers(FormulaReq formulaReq) {
		return parseHelper.extractNumber(formulaReq.formula());
	}
}
