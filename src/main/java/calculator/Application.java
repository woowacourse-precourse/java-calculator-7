package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램
        // 구현
        // 사용자 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = readLine();
        try {
            int result = StringCalculator.calculate(userInput);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
