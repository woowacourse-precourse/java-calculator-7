package calculator;

public class CalculatorController {

    private final OutputView outputView;
    private final InputView inputView;
    private final CalculatorFunction calculatorFunction;

    public CalculatorController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.calculatorFunction = new CalculatorFunction();
    }

    public void run() {
        String input = inputView.getInput();
        int result = 0;
        result = calculatorFunction.add(input);
        outputView.printResult(result);


    }
}
