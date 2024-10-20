package calculator;

import camp.nextstep.edu.missionutils.Console;
import service.CalculatorService;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");  // 사용자에게 입력 요청
        String input = Console.readLine();  // 입력받기

        // 구분자 처리 및 결과 계산
        try {
            // 커스텀 구분자 확인
            if (input.startsWith("//")) {
                // 커스텀 구분자가 있을 경우
                String numbers = Console.readLine();  // 숫자 입력받기
                int result = new CalculatorService().delimiterProcess(input + "\n" + numbers);  // 합산 처리
                System.out.println("결과: " + result);  // 결과 출력
            } else {
                // 기본 구분자 사용
                int result = new CalculatorService().delimiterProcess(input);  // 합산 처리
                System.out.println("결과: " + result);  // 결과 출력
            }
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());  // 오류 메시지 출력
        }
    }
}
