package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorView calculatorView = new CalculatorView();
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorController calculatorController = new CalculatorController(calculatorView, calculatorModel);

        calculatorController.runProgram();
    }
}
