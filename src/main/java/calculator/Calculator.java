package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Calculator {
    private final DigitExtractor digitExtractor;
    private final OperationProcessor operationProcessor;

    public Calculator() {
        this.digitExtractor = new DigitExtractor();
        this.operationProcessor = new OperationProcessor();
    }

    public void run() {
        String input = getUserInput();
        List<Integer> digits = digitExtractor.extractDigits(input);
        int result = operationProcessor.calculate(digits);
        System.out.println("결과 : " + result);
    }

    /**
     * 사용자 입력 받기
     */
    private String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine().trim();
        Console.close();
        return input;
    }
}
