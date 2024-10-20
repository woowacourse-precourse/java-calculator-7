package calculator;

import calculator.domain.StringCalculator;
import calculator.parser.Parser;
import camp.nextstep.edu.missionutils.Console;

/**
 * Application 클래스는 덧셈 계산을 수행하는 프로그램의 진입점 역할을 합니다.
 * 사용자로부터 문자열을 입력받아, StringCalculator를 통해 덧셈 계산을 수행한 후 결과를 출력합니다.
 */
public class Application {
    private static final String GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE_TEMPLATE = "결과 : %s";

    /**
     * main 메서드는 프로그램의 시작점으로, 사용자로부터 입력을 받고 그 결과를 계산한 뒤 출력합니다.
     *
     * @param args 프로그램 실행 시 전달받는 인자 (사용되지 않음)
     */
    public static void main(String[] args) {
        printGuideMessage();  // 사용자에게 입력 안내 메시지 출력
        Input input = new Input(Console.readLine());  // 입력값을 읽어 Input 객체로 생성

        // StringCalculator에 Parser 객체를 전달하여 계산을 수행
        StringCalculator stringCalculator = new StringCalculator(new Parser());
        int calcResult = stringCalculator.add(input).calcResult();

        printResultMessage(calcResult);  // 계산 결과 출력
    }

    /**
     * 사용자에게 덧셈할 문자열을 입력받도록 안내하는 메시지를 출력합니다.
     */
    private static void printGuideMessage() {
        System.out.println(GUIDE_MESSAGE);
    }

    /**
     * 덧셈 결과를 출력합니다.
     *
     * @param calcResult 계산 결과 값
     */
    private static void printResultMessage(int calcResult) {
        System.out.printf((RESULT_MESSAGE_TEMPLATE) + "%n", calcResult);
    }
}
