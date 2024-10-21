package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자로부터 문자열을 입력받음
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = add(input);
        System.out.println("결과: " + result);
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 쉼표 또는 콜론을 기준으로 문자열을 분리
        String[] tokens = input.split(",|:");
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);  // 문자열을 숫자로 변환 후 합산
        }
        return sum;
    }
}
