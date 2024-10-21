package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String DEFAULT_DELIMITERS = ",:";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiters = DEFAULT_DELIMITERS;
        String numbersPart = input;

        if (input.startsWith("//")) {
            int delimiterIndex = findDelimiterIndex(input);
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 잘못된 형식입니다. 형식: //구분자\\n");
            }

            String customDelimiter = input.substring(2, delimiterIndex);
            validateCustomDelimiter(customDelimiter);
            delimiters += customDelimiter;
            numbersPart = input.substring(delimiterIndex + 2);
        }

        if (numbersPart.isEmpty()) {
            return 0;
        }

        validateString(numbersPart, delimiters);
        String[] numbers = splitNumbers(numbersPart, delimiters);
        return calculateSum(numbers);
    }

    private static int findDelimiterIndex(String input) {
        return input.indexOf("\\n");
    }

    private static void validateCustomDelimiter(String customDelimiter) {
        for (char c : customDelimiter.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                throw new IllegalArgumentException("구분자에 숫자나 알파벳이 포함될 수 없습니다.");
            }
        }
    }

    private static void validateString(String input, String delimiters) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("숫자 문자열이 비어 있습니다.");
        }

        boolean lastWasDelimiter = false;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            boolean isDelimiter = delimiters.indexOf(ch) != -1;
            if (isDelimiter) {
                if (i == 0) {
                    throw new IllegalArgumentException("문자열은 구분자로 시작할 수 없습니다.");
                }
                if (lastWasDelimiter) {
                    throw new IllegalArgumentException("구분자가 연속적으로 사용되었습니다.");
                }

                lastWasDelimiter = true;
            } else {
                lastWasDelimiter = false;
            }
        }

        if (lastWasDelimiter) {
            throw new IllegalArgumentException("구분자로 끝날 수 없습니다.");
        }
    }

    private static String[] splitNumbers(String input, String delimiters) {
        String delimiterPattern = createDelimiterPattern(delimiters);
        String[] numbers = input.split(delimiterPattern);
        validateNumbers(numbers); // 검증 추가
        return numbers;
    }

    private static String createDelimiterPattern(String delimiters) {
        StringBuilder pattern = new StringBuilder();
        for (char delimiter : delimiters.toCharArray()) {
            if (pattern.length() > 0) {
                pattern.append("|");
            }
            pattern.append("\\Q").append(delimiter).append("\\E"); // 정규식 특수 문자 이스케이프
        }
        return pattern.toString();
    }

    private static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException("음수는 입력될 수 없습니다: " + number);
            }
        }
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number); // 문자열을 정수로 변환하여 합산
        }
        return sum;
    }
}
