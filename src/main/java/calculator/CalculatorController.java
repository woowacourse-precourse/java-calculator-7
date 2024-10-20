package calculator;

public class CalculatorController {
    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
    }

    public void runProgram() {
        String userInput = calculatorView.getUserInput();
        System.out.println(userInput);          //test
    }
}
