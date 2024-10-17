package calculator.controller;

import calculator.service.CalculationService;
import calculator.service.InputService;
import calculator.service.ParsingService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorController {

    private final InputService inputService;
    private final CalculationService calculationService;
    private final ParsingService parsingService;
    private final InputView inputView;
    private final OutputView outputView;

    private StringCalculatorController(InputService inputService, CalculationService calculationService,
                                       ParsingService parsingService, InputView inputView, OutputView outputView) {
        this.inputService = inputService;
        this.calculationService = calculationService;
        this.parsingService = parsingService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    //============= 생성 메서드 ============//
    public static StringCalculatorController createController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputService inputService = new InputService();
        CalculationService calculationService = new CalculationService();
        ParsingService parsingService = new ParsingService();

        return new StringCalculatorController(inputService, calculationService, parsingService, inputView, outputView);
    }

    //============ 비즈니스 로직 ===========//
    public void run() {
        //TODO: 전체 흐름 제어 로직 구현
        inputView.printInput();
        String validInput = inputService.readInput();
        int[] numbers = parsingService.parseNumbers(validInput);
        outputView.printResult(calculationService.calculate(numbers));
    }
}
