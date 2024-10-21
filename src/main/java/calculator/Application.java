package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = readLine();
        try {
            int result = StringCalculator.calculate(userInput);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e; // 예외를 다시 던져 테스트 코드에서 감지할 수 있도록 함
        }
    }
}
