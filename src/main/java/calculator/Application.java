package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * Application 클래스는 StringCalculator를 사용하여 사용자로부터 문자열을 입력받고 덧셈 결과를 출력하는 프로그램입니다.
 *
 * <p>
 * 사용자가 입력한 문자열을 기반으로 계산을 수행하며, 결과를 콘솔에 출력합니다.
 * </p>
 *
 * @author JBumLee
 * @version 2024/10/21
 */
public class Application {
    private static final String IN_STRING = "덧셈할 문자열을 입력해 주세요.\n";
    private static final String OUT_STRING = "결과 : ";

    /**
     * 프로그램의 진입점입니다. 사용자로부터 입력을 받고, StringCalculator를 통해 계산을 수행한 후 결과를 출력합니다.
     *
     * @param args 명령행 인수
     */
    public static void main(String[] args) {
        StringCalculator stringCalculator = StringCalculator.getInstance();
        print(stringCalculator.sum(getInput()));
    }

    /**
     * 사용자로부터 덧셈할 문자열을 입력받습니다.
     *
     * @return 입력받은 문자열
     */
    private static String getInput() {
        System.out.println(IN_STRING);
        return Console.readLine();
    }

    /**
     * 계산 결과를 출력합니다.
     *
     * @param number 출력할 계산 결과
     */
    private static void print(Long number) {
        System.out.println(OUT_STRING + number);
    }
}