package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 덧셈할 문자열 입력
        String input = Console.readLine();

        // 아무것도 입력하지 않으면 결과는 0으로 출력
        if (input.isEmpty()) {
            System.out.println("결과: 0");
            return;
        }

        try {
            validateInput(input);
            System.out.println("유효한 입력입니다: " + input);
        } catch (IllegalArgumentException e) {
            // 에러 메시지 출력
            System.err.println(e.getMessage());
        }

    }

    // 사용자 입력 검증 함수
    public static void validateInput(String input) {
        // 0보다 큰지 확인 그리고 숫자 형식인지 확인
        if (!input.matches("^[1-9]\\d+$")) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}
