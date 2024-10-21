package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            // 사용자 입력 받기
            String input = Console.readLine();

            // Calculator의 add 메서드 호출하여 결과 계산
            int result = Calculator.add(input);

            // 결과 출력
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 메시지 출력
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }
}
