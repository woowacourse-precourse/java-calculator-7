package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해주세요.");
            String input = Console.readLine();  // 입력 받기
            int result = StringCalculator.add(input); // 계산 결과
            System.out.println("결과 : " + result);  // 결과 출력
        } catch (IllegalArgumentException e) {
            throw e;  // 예외를 다시 던져서 프로그램 종료
        }
    }
}
