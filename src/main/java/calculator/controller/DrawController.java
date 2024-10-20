package calculator.controller;

import calculator.dto.DelimitersDto;
import calculator.dto.FormulaDto;
import calculator.dto.NumbersDto;
import calculator.service.DrawService;

public class DrawController {
	private final DrawService drawService;

	public DrawController() {
		this.drawService = new DrawService();
	}

	public NumbersDto drawNumbers(FormulaDto formulaDto, DelimitersDto delimiterDto) {
		return drawService.drawNumbers(formulaDto, delimiterDto);
	}
}
