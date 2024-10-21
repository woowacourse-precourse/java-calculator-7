package calculator;

public class CalculatorController {

    private final OutputView outputView;
    private final InputView inputView;

    public CalculatorController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
//        this.calculatorService = new CalculatorService();
    }

    public void run() {
        String input = inputView.getInput();

        int result = 0;
        outputView.printResult(result);


    }
}
