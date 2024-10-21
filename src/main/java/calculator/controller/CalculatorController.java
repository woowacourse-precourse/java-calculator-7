package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.parser.InputParser;
import calculator.domain.parser.InputParser.ParsedInput;
import calculator.dto.CalculatorRequestDto;
import calculator.dto.CalculatorResponseDto;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputParser inputParser;
    private final Calculator calculator;

    public CalculatorController() {
        this.inputParser = new InputParser();
        this.calculator = new Calculator();
    }

    private CalculatorResponseDto calculate(CalculatorRequestDto calculatorRequestDto) {
        ParsedInput parsedInput = inputParser.parse(calculatorRequestDto.input());

        return new CalculatorResponseDto(calculator.calculate(parsedInput));
    }

    public void run() {
        try {
            CalculatorRequestDto calculatorRequestDto = InputView.beginInput();
            OutputView.printResult(calculate(calculatorRequestDto).result());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
