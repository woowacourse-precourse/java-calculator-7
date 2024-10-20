package calculator;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Calculator calculator = new Calculator();

        String inputStr = inputHandler.getInput();
        calculator.parseAndAddNumbers(inputStr);
        int result = calculator.sum();

        System.out.println("결과: " + result);
    }
}