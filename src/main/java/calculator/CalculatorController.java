package calculator;

public class CalculatorController {

    public void run() {
        CalculatorView calculatorView = new CalculatorView();
        String userInput = calculatorView.getUserInput();
        System.out.println(userInput);
    }
}
