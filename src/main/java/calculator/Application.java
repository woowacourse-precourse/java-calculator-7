package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    public static int add(String input) {

        String seperator = ",|:"; // 기본 구분자: 쉼표와 콜론

        // 구분자를 기준으로 숫자를 분리
        String[] numbers = input.split(seperator);

        // 각 숫자에 대해 검증 및 덧셈 처리
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {  // 빈 문자열은 무시
                sum += Integer.parseInt(number.trim());  // 숫자 변환 후 덧셈
            }
        }

        return sum;
    }
}
