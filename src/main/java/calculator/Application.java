package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력하세요.");
        String input = Console.readLine();

        if (input.isEmpty()) {
            System.out.println("결과: 0");
            return;
        }

        String normalizedInput = normalizeDelimiters(input);
        // 다음 단계로 넘어갑니다.
    }

    private static String normalizeDelimiters(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            if (!isValidDelimiter(customDelimiter)) {
                throw new IllegalArgumentException("유효하지 않은 구분자: " + customDelimiter);
            }

            input = input.substring(newlineIndex + 1).replace(customDelimiter, "+");
        }
        return input.replaceAll("[,|:]", "+");
    }
}
