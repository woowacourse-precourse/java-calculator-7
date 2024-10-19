package calculator.Calculator;

import calculator.Delimiter.DelimiterParser;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorService {
    private final DelimiterParser delimiterParser;
    private final Calculator calculator;

    public CalculatorService(DelimiterParser delimiterParser, Calculator calculator) {
        this.delimiterParser = delimiterParser;
        this.calculator = calculator;
    }

    public void calculate() {

        String input = getInput();

        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        try {
            String[] tokens = delimiterParser.parse(input);
            int result = calculator.sumOfStrings(tokens);
            displayResult(result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private void displayResult(int result) {
        System.out.println("결과 : " + result);
    }
}
