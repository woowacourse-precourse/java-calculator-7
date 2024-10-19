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

    public void start() {
        outputView.printStart();
        try {
            String result = proceed();
            outputView.printResult(result);
        } catch (IllegalArgumentException error) {
            outputView.printError(error.getMessage());
        } finally {
            end();
        }
    }

    public String proceed() {
        String inputString = inputView.promptString();
        if (calculatorService.haveCustomDelimiter(inputString)) {
            delimiter = calculatorService.addCustomDelimiter(inputString, delimiter);
            inputString = calculatorService.extractInput(inputString, delimiter);
        }
        List<String> inputTokens = calculatorService.splitInputWithDelimiter(inputString, delimiter);
        return calculatorService.sumAllTokens(inputTokens);
    }

    public void end() {
        outputView.printEnd();
    }
}
