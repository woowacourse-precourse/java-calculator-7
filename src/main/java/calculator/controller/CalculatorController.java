package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatorService calculatorService = new CalculatorService();
    private String delimiter = ",:";

    public void run() {
        start();
        String result = proceed();
        end(result);
    }

    private void start() {
        outputView.printStart();
    }

    private String proceed() {
        String inputString = inputView.promptString();
        if (calculatorService.haveCustomDelimiter(inputString)) {
            delimiter = calculatorService.addCustomDelimiter(inputString, delimiter);
            inputString = calculatorService.extractInput(inputString, delimiter);
        }
        List<String> inputTokens = calculatorService.splitInputWithDelimiter(inputString, delimiter);
        return calculatorService.sumAllTokens(inputTokens);
    }

    private void end(String result) {
        outputView.printResult(result);
        outputView.printEnd();
    }
}
