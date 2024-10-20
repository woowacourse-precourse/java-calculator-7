package calculator;

import java.util.Arrays;

public class Calculator {

    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = detectDelimiter(input);
        String[] numbers = splitNumbers(input, delimiter);

        return Arrays.stream(numbers)
                .mapToInt(Calculator::parseNumber)
                .sum();
    }

    private static String detectDelimiter(String input) {
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("입력 형식이 올바르지 않아요. 다시 확인해 주세요!"); // 오류 메시지 수정
            }
            // 커스텀 구분자 감지
            String customDelimiter = input.substring(2, newlineIndex);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("입력 형식이 올바르지 않아요: 커스텀 구분자가 비어 있어요!"); // 오류 메시지 수정
            }
            return escapeDelimiter(customDelimiter);
        }
        return ",|:"; // 기본 구분자
    }

    private static String escapeDelimiter(String customDelimiter) {
        // 정규 표현식에 맞게 구분자를 이스케이프 처리
        return customDelimiter.replaceAll("([{}()\\[\\].+*?^$|])", "\\\\$1");
    }

    private static String[] splitNumbers(String input, String delimiter) {
        // 커스텀 구분자가 포함된 경우 문자열에서 커스텀 구분자 부분을 제거
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\n");
            input = input.substring(newlineIndex + 1);
        }

        String[] numbers = input.split(delimiter);
        validateNumbers(numbers);
        return numbers;
    }

    private static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (!number.trim().matches("-?\\d+")) { // 숫자 형식 체크
                throw new IllegalArgumentException("웅, 잘못된 숫자예요: " + number + "는 안돼요!"); // 오류 메시지 수정
            }
        }
    }

    private static int parseNumber(String numberStr) {
        int number = Integer.parseInt(numberStr.trim());
        if (number < 0) {
            throw new IllegalArgumentException("아이고! 음수는 허용되지 않아요: " + number + "는 안돼요!"); // 오류 메시지 수정
        }
        return number;
    }
}
