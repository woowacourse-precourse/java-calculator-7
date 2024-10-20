package calculator;

public class Application {
    public static void main(String[] args) {

        CalculatorController calculatorcontroller = new CalculatorController();

        int result= calculatorcontroller.processInput(InputHandler.getInput());

        OutputHandler.printResult(result);
    }
}
