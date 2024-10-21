package calculator;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInputOutput userIO = new UserInputOutput();
        String input = userIO.input();

        InputValidator validator = new InputValidator();
        StringSumCalculator calculator = new StringSumCalculator(validator);

        int result = calculator.add(input);

        userIO.displayResult(result);
    }
}
