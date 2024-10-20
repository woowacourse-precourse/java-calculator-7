package calculator;

import calculator.exception.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            // 입력값이 빈 문자열인 경우 예외 발생
            if (input == null || input.isEmpty()) {
                throw new InvalidInputException("입력값이 없습니다.");
            }

            StringCalculator calculator = new StringCalculator();
            int result = calculator.calculate(input);

            System.out.println("결과 : " + result);

        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());  // 예외 메시지 출력
        }
    }
}
