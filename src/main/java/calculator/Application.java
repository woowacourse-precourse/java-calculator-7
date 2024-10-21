package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // Console.readLine() 사용

        // 결과 출력 (예외는 StringCalculator에서 처리)
        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);
        
    }
}
