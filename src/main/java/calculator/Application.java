package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorView);

        calculatorController.runProgram();
    }
}
