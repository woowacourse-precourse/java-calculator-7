package calculator;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInputOutput userInputOutput = new UserInputOutput();
        String input = userInputOutput.input();

        InputValidator validator = new InputValidator();
        StringParser parser = new StringParser();

        StringSumCalculator calculator = new StringSumCalculator(validator, parser);

        int result = calculator.add(input);

        userInputOutput.displayResult(result);
    }
}
