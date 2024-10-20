/**
 * 계산기 프로그램을 시작하고 끝내는 클래스
 *
 * @Package name : calculator
 * @Class name   : PlayCalculator
 * @Create Date  : 2024-10-20
 * @Create User  : 오시건
 */
package calculator;

import camp.nextstep.edu.missionutils.Console;

public class PlayCalculator {

    /**
     * 하드코딩 방지용 상수
     */
    private static final String START = "덧셈할 문자열을 입력해 주세요.\n";
    private static final String RESULT = "결과 : ";

    /**
     * InputValidator 객체 생성, 사용자가 입력한 문자열을 검사하는 역할
     */
    private final InputValidator inputValidator = new InputValidator();

    /**
     * 사용자로부터 문자열을 입력받는 메소드
     *
     * @return 입력받은 문자열
     * @throws IllegalArgumentException 입력값이 유효하지 않은 경우
     */
    public String input() {
        String result = Console.readLine();
        validateInput(result);
        return result;
    }

    /**
     * 입력된 문자열이 유효하지 않다면 IllegalArgumentException 발생
     *
     * @param input 검사할 문자열
     * @throws IllegalArgumentException 입력값이 유효하지 않은 경우
     */
    private void validateInput(String input) {
        if (!inputValidator.checkDelimiter(input)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 계산기를 실행하는 메소드
     */
    public void startConsole() {
        System.out.print(START);
        Calculator calculator = new Calculator();
        endConsole(calculator.checkInput(input()));
    }

    /**
     * 계산 결과를 콘솔에 출력하는 메소드
     *
     * @param result 계산 결과
     */
    public void endConsole(int result) {
        System.out.print(RESULT + result);
    }
}
