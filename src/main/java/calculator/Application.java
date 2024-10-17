package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }

    public static int add(String input) {
        // 입력된 값이 없을 경우
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] num;
        String delimiter = ",|:";  // 기본 구분자 쉼표, 콜론
        if (input.startsWith("//")) {
            // 커스텀 구분자 추출
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        num = input.split(delimiter);
        int sum = 0;
        for (String number : num) {
            int num1 = parseNumber(number);
            sum += num1;
        }

        return sum;
    }

    private static int parseNumber(String number) {
        try {
            int result = Integer.parseInt(number);
            if (result < 0) {  // 음수 값 처리
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}