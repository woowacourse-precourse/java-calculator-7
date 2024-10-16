package calculator.controller;

import calculator.service.Adder;
import calculator.service.Extractor;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Extractor extractor;
    private final Adder adder;

    public CalculatorController(InputView inputView, OutputView outputView, Extractor extractor, Adder adder) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.extractor = extractor;
        this.adder = adder;
    }

    public void start() {
        while (true) {
            String input = inputView.getUserInput();               // 사용자 입력 받기
            List<Integer> extractedIntegers = extractor.extractNumbers(input);
            int result = adder.addAllNumbers(extractedIntegers);
            outputView.printAllAddedResult(result);
            break;
        }
    }
}
