package calculator;

public class Application {
    public static void main(String[] args) {
        try {
            String input = new InputView().readInput();

            int result = new Calculator().calculate(input);

            new OutputView().printResult(result);

        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력 : " + e.getMessage());
        }
    }
}

