package calculator;

public class Application {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        CalculatorController controller = new CalculatorController();
        OutputHandler outputHandler = new OutputHandler();

        String input = inputHandler.getInput();

        // TODO : CalculatorController 함수 호출
        int result=0;

        outputHandler.printResult(result);
    }
}
