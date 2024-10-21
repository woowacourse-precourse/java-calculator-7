package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 계산기 객체 클래스
 */
public class Calculator {

    private final DigitExtractor digitExtractor;
    private final OperationProcessor operationProcessor;
    private final InputProcessor inputProcessor;

    /**
     * Calculator 클래스의 생성자 - DigitExtractor, OperationProcessor, InputProcessor 객체 초기화
     */
    public Calculator() {
        this.digitExtractor = new DigitExtractor();
        this.operationProcessor = new OperationProcessor();
        this.inputProcessor = new InputProcessor();
    }

    /**
     * 계산기 실행 - 사용자로부터 문자열을 입력 받아 연산을 수행하고 결과를 출력한다.
     */
    public void run() {
        String operationInput = inputProcessor.getOperationInput(); // 연산 대상이 되는 문자열
        String delimiterRegex = inputProcessor.getDelimiterRegex(); // 사용하는 구분자의 정규표현식
        List<Integer> digits = digitExtractor.extractDigits(operationInput, delimiterRegex);
        int result = operationProcessor.calculate(digits);
        System.out.println("결과 : " + result);
        Console.close();
    }

    /**
     * 유효하지 않은 입력값 예외 처리 메서드
     */
    public static void handleInvalidInput(String input) {
        System.out.println("유효하지 않은 문자열입니다. 프로그램을 종료합니다.");
        throw new IllegalArgumentException("Invalid input: " + input);
    }

}
