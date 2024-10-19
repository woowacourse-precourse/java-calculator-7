package calculator.controller;

import calculator.domain.Calculator;
import calculator.dto.FormulaDto;
import calculator.dto.DelimitersDto;
import calculator.dto.NumbersDto;
import calculator.view.InputView;

public class ProgramController {
	private final DrawController drawController;
	private final DelimiterController delimiterController;

	public ProgramController() {
		this.drawController = new DrawController();
		this.delimiterController = new DelimiterController();
	}

	public void run() {
		System.out.print("입력하세요: ");
		FormulaDto formulaDto = generateFormulaRequest();

		DelimitersDto delimiterDto = delimiterController.extractDelimiters(formulaDto.formula());
		NumbersDto numbersDto = drawNumber(formulaDto, delimiterDto);
		Calculator calculator = new Calculator(numbersDto.numbers());
		calculator.calculateSum();

		System.out.print("결과 : ");
		System.out.println(calculator.getSum());

	}

	private FormulaDto generateFormulaRequest() {
		String formula = InputView.readLine();
		return new FormulaDto(formula);
	}

	private NumbersDto drawNumber(FormulaDto formulaDto, DelimitersDto delimiterDto) {
		return drawController.drawNumbers(formulaDto, delimiterDto);
	}

}
