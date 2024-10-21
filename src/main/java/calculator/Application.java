package calculator;
import camp.nextstep.edu.missionutils.Console;

/**
 * Application 클래스는 StringCalculator 프로그램을 실행하는 메인 클래스로,
 * 사용자 입력을 받아 처리하고 결과를 출력합니다.
 */
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = StringCalculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }
}
