package calculator.service;

public class CalculatorService {
    private final StringParser stringParser = new StringParser();

    public int calculate(String input) {
        int answer = 0;
        if (input.isEmpty()) {
            return answer;
        }

        String[] parsed = stringParser.parseString(input);

        return answer;
    }
}
