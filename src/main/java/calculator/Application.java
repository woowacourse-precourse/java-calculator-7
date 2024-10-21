package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculate(input);  // 계산 실행
        System.out.println("결과 : " + result);  // 결과 출력
    }

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열은 0으로 처리
        }
        String delimiter = ",|:";  // 기본 구분자 쉼표와 콜론
        String[] tokens = input.split(delimiter);  // 구분자로 문자열 분리

        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token.trim());  // 숫자로 변환하고 합산
        }

        return sum;
    }
}
