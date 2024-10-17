package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("더하기 진행할 문자열을 입력해주세요.");
        String input = Console.readLine();

        try {
            int result = StringAddCalculator.add(input);
            System.out.println("계산 결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }

    public class StringAddCalculator {
        public static int add(String input) {
            if (input == null || input.isBlank()) {
                return 0;
            }

            return 0;
        }
    }
}
