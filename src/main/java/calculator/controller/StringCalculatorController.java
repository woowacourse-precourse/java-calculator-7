package calculator.controller;

import calculator.service.CalculationService;
import calculator.service.InputService;
import calculator.service.ParsingService;
import calculator.view.OutputView;

public class StringCalculatorController {

    private final InputService inputService;
    private final CalculationService calculationService;
    private final ParsingService parsingService;
    private final OutputView outputView;

    public StringCalculatorController(InputService inputService, CalculationService calculationService, ParsingService parsingService, OutputView outputView) {
        this.inputService = inputService;
        this.calculationService = calculationService;
        this.parsingService = parsingService;
        this.outputView = outputView;
    }

    public void run() {
        //TODO: 전체 흐름 제어 로직 구현
        String validInput = inputService.getValidInput();
        int[] numbers = parsingService.parseNumbers(validInput);
        outputView.printResult(calculationService.calculate(numbers));
    }
}
