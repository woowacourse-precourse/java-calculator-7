package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            // StringCalculator를 사용하여 입력된 문자열의 합을 계산
            int result = calculator.add(input);

            // 결과 출력
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 메시지 출력
            System.out.println("예외 발생: " + e.getMessage());
            throw e;
        }
    }
}
