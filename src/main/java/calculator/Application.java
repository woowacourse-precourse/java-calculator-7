package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자 입력

        int result = add(input);
        System.out.println("결과 : " + result);

    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자
        if (input.startsWith("//")) {
            // 커스텀 구분자 파싱
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            delimiter = input.substring(2, newlineIndex);  // 커스텀 구분자 추출
            input = input.substring(newlineIndex + 2);  // 숫자 부분 추출
        }

        String[] numbers = input.split(delimiter);

        // 잘못된 형식을 확인 (숫자가 아닌 경우 예외 처리)
        for (String number : numbers) {
            if (!number.matches("-?\\d+")) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        }
        return calculateSum(numbers);
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += num;
        }
        return sum;
    }
}
