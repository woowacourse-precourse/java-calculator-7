package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculator calculator = new StringCalculator();
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        try {
            String input = inputHandler.getInput();
            int result = calculator.calculate(input);
            outputHandler.printResult(result);
        } catch (IllegalArgumentException e) {
            outputHandler.printError(e.getMessage());
            throw e;  // 예외를 다시 throw하여 프로그램을 종료하도록 변경
        }
    }
}
