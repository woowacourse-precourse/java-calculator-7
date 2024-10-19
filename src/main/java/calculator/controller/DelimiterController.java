package calculator.controller;

import calculator.dto.DelimitersDto;
import calculator.service.DelimiterService;

public class DelimiterController {
	private final DelimiterService delimiterService;

	public DelimiterController() {
		this.delimiterService = new DelimiterService();
	}

	public DelimitersDto extractDelimiters(String formula) {
		return delimiterService.generateDelimiters(formula);
	}
}
