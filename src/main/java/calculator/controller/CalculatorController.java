package calculator.controller;


import calculator.model.Calculator;
import calculator.service.SplitService;
import calculator.util.Converter;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String expression = inputView.readExpression();
        SplitService splitService = new SplitService();
        List<String> numbers = splitService.split(expression);
        Converter converter = new Converter();
        Calculator calculator = new Calculator();
        int result = calculator.addAll(converter.convertToInteger(numbers));
        outputView.printCalculateResult(result);
    }
}
