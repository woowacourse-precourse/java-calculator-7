package calculator.controller;

import java.util.regex.Pattern;

import calculator.constant.DrawConstant;
import calculator.domain.Calculator;
import calculator.dto.DelimitersDto;
import calculator.dto.FormulaDto;
import calculator.dto.NumbersDto;
import calculator.dto.SumDto;
import calculator.view.InputView;
import calculator.view.OutputView;

public class ProgramController {
	private final DrawController drawController;
	private final DelimiterController delimiterController;

	public ProgramController() {
		this.drawController = new DrawController();
		this.delimiterController = new DelimiterController();
	}

	public void run() {
		printInformationMessage();

		FormulaDto formulaDto = generateFormulaRequest();

		if (isZeroRegex(formulaDto.formula())) {
			printZeroSumMessage();
			return;
		}

		DelimitersDto delimiterDto = extractDelimiters(formulaDto);

		NumbersDto numbersDto = drawNumber(formulaDto, delimiterDto);

		SumDto sumDto = calculateSum(numbersDto);

		printResultMessage(sumDto);

	}

	private boolean isZeroRegex(String formula) {
		return Pattern.matches(DrawConstant.ZERO_SUM_FORMULA_CONTAINS_CUSTOM_DELIMITER_REGEX, formula)
			|| formula.isEmpty();
	}

	private void printZeroSumMessage() {
		OutputView.printZeroSumMessage();
	}

	private void printInformationMessage() {
		OutputView.printInformationMessage();
	}

	private FormulaDto generateFormulaRequest() {
		String formula = InputView.readLine();
		return new FormulaDto(formula);
	}

	private DelimitersDto extractDelimiters(FormulaDto formulaDto) {
		return delimiterController.extractDelimiters(formulaDto.formula());
	}

	private NumbersDto drawNumber(FormulaDto formulaDto, DelimitersDto delimiterDto) {
		return drawController.drawNumbers(formulaDto, delimiterDto);
	}

	private SumDto calculateSum(NumbersDto numbersDto) {
		Calculator calculator = new Calculator(numbersDto.numbers());
		calculator.calculateSum();
		return new SumDto(calculator.getSum());
	}

	private void printResultMessage(SumDto sumDto) {
		OutputView.printResultMessage(sumDto);
	}
}
