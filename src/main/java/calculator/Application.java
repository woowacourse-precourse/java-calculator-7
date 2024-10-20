package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine(); // 사용자 입력 받기
        int result = calculate(input); // 입력 처리 함수 호출
        System.out.println("결과 : " + result); // 결과 출력
    }

    public static int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] tokens = splitTokens(input);
        validateNumbers(tokens); // 유효성 검사

        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String[] splitTokens(String input) {
        if (input.startsWith("//")) {
            String customDelimiter = input.substring(2, input.indexOf("\n"));
            String numbers = input.substring(input.indexOf("\n") + 1);
            return numbers.split(customDelimiter);
        }

        // 기본 구분자(쉼표, 콜론)
        return input.split("[,:]");
    }

    private static void validateNumbers(String[] tokens) {
        for (String token : tokens) {
            String trimmedToken = token.trim();
            if (!trimmedToken.matches("\\d+")) { // 숫자 검사
                throw new IllegalArgumentException("잘못된 입력입니다."); // 문자 입력에 대한 예외
            }

            int number = Integer.parseInt(trimmedToken);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다."); // 예외 처리
            }
        }
    }
}
