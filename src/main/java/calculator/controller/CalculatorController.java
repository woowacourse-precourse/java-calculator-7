package calculator.controller;

import calculator.model.CalculateService;
import calculator.model.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.math.BigDecimal;
import java.util.List;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringParser stringParser;
    private final CalculateService calculateService;

    public CalculatorController(InputView inputView, OutputView outputView, StringParser stringParser,
                                CalculateService calculateService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringParser = stringParser;
        this.calculateService = calculateService;
    }

    public void run() {
        outputView.showInputPrompt();
        String input = inputView.getInput();

        List<BigDecimal> numbers = stringParser.parse(input);

        BigDecimal result = calculateService.sum(numbers);

        outputView.showResult(result);
    }
}
