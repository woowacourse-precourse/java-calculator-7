package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 계산기 객체 클래스
 */
public class Calculator {

    private final InputProcessor inputProcessor;
    private final OperationProcessor operationProcessor;

    /**
     * Calculator 클래스의 생성자 - InputProcessor, OperationProcessor 객체 초기화
     */
    public Calculator() {
        this.inputProcessor = new InputProcessor();
        this.operationProcessor = new OperationProcessor();
    }

    /**
     * 계산기 실행 - 사용자로부터 문자열을 입력 받아 연산을 수행하고 결과를 출력한다.
     */
    public void run() {
        List<Integer> digits = inputProcessor.extractDigits(); // 사용자 입력으로부터 덧셈의 피연산자(input)가 되는 숫자 추출
        int result = operationProcessor.calculate(digits); // 덧셈 수행
        System.out.println("결과 : " + result); // 계산 결과 출력
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
