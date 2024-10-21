package calculator;

import camp.nextstep.edu.missionutils.Console;
import separator.StringCalculator;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        try {
            int sumResult = StringCalculator.add(inputString);
            // 빈 문자열을 처리하여 결과를 출력
            System.out.println("결과 : " + sumResult);
        } catch (IllegalArgumentException exception) {
            // 예외 메시지를 명확하게 출력
            System.out.println("잘못된 입력입니다 \n" + exception.getMessage());
        }
    }
}
