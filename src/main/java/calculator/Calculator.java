package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Calculator {
    private final DigitExtractor digitExtractor;
    private final OperationProcessor operationProcessor;
    private final InputProcessor inputProcessor;

    public Calculator() {
        this.digitExtractor = new DigitExtractor();
        this.operationProcessor = new OperationProcessor();
        this.inputProcessor = new InputProcessor();
    }

    public void run() {
        String operationInput = inputProcessor.getOperationInput(); // 연산 대상이 되는 문자열
        String delimiterRegex = inputProcessor.getDelimiterRegex(); // 사용하는 구분자의 정규표현식
        List<Integer> digits = digitExtractor.extractDigits(operationInput, delimiterRegex);
        int result = operationProcessor.calculate(digits);

        System.out.println("결과 : " + result);
        Console.close();
    }

    /**
     * 유효하지 않은 입력값 예외 처리
     */
    public static void handleInvalidInput(String input) {
        System.out.println("유효하지 않은 문자열 입니다. 프로그램을 종료합니다.");
        throw new IllegalArgumentException("Invalid input: " + input);
    }

}
