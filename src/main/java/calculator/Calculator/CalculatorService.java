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
        // 덧셈할 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 입력이 없을 경우 "결과 : 0" 출력
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        try {
            String[] tokens = delimiterParser.parse(input);
            int result = calculator.sumOfStrings(tokens);
            System.out.println("결과 : " + result);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
