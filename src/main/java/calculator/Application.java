package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculator calculator = new StringCalculator();

        // 값 받아오기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 결과 출력
        try {
            int result = calculator.add(input);

            // 음수 확인
            if (result < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }

            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
