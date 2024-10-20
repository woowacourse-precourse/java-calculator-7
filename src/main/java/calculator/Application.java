package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();  // 사용자 입력 받기

        System.out.println("입력값: " + input);  // 입력된 값을 출력해서 확인

        try {
            int result = StringCalculator.add(input);  // StringCalculator의 add 메서드 호출
            System.out.println("결과: " + result);  // 결과 출력
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());  // 잘못된 입력일 경우 예외 메시지 출력
        }
    }
}
