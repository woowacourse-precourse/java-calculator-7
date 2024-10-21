package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();

        Calculator calculator = new Calculator(new StringSpliter());
        int result = calculator.calculate(input);

        System.out.println("결과 : " + result);
    }
}
