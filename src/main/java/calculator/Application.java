package calculator;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        CalculatorController calculatorcontroller = new CalculatorController();
        OutputHandler outputHandler = new OutputHandler();

        String input = inputHandler.getInput();

        int result= calculatorcontroller.processInput(input);

        outputHandler.printResult(result);
    }
}
