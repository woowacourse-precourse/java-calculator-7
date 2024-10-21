package calculator.service;

import calculator.global.instance.Messages;

public class CalculatorService {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열 또는 null이면 0 반환
        }

        // 입력에서 \\n을 실제 개행 문자로 변환
        input = input.replace("\\n", "\n");

        String delimiter = ",|:"; // 기본 구분자 쉼표와 콜론
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");  // 실제 개행 문자를 찾음
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException(Messages.MISSING_NEWLINE_AFTER_CUSTOM_DELIMITER_ERROR);
            }
            String customDelimiter = input.substring(2, delimiterIndex); // 커스텀 구분자 추출
            if (!customDelimiter.isEmpty()) {
                delimiter = extractCustomDelimiters(customDelimiter); // 커스텀 구분자가 있는 경우 추출
            }
            input = input.substring(delimiterIndex + 1); // 개행 뒤의 숫자 부분만 남김
        }

        if (input.isEmpty()) {
            return 0; // 숫자가 없으면 0 반환
        }

        // 입력 값을 구분자로 분리한 후 계산
        String[] numbers = input.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            if (!number.trim().isEmpty()) { // 빈 값이 아닌 경우만 처리
                int num = parsePositiveInt(number.trim()); // 양수만 허용
                sum += num;
            }
        }

        return sum;
    }

    private static String extractCustomDelimiters(String delimiterPart) {
        if (delimiterPart.contains("|")) {
            String[] customDelimiters = delimiterPart.split("\\|");
            for (int i = 0; i < customDelimiters.length; i++) {
                customDelimiters[i] = escapeSpecialChars(customDelimiters[i]); // 특수 문자를 이스케이프
            }
            return String.join("|", customDelimiters);
        } else {
            return escapeSpecialChars(delimiterPart); // 단일 구분자인 경우도 이스케이프 처리
        }
    }

    // 정규식 메타 문자를 이스케이프 처리하는 메소드
    private static String escapeSpecialChars(String delimiter) {
        return delimiter.replaceAll("([\\[\\]{}()*+?^$\\\\.|])", "\\\\$1");
    }

    // 양수만 허용하고 숫자가 아니면 예외 처리
    private static int parsePositiveInt(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException(Messages.NEGATIVE_NUMBER_ERROR);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.INVALID_CHARACTER_ERROR);
        }
    }
}
