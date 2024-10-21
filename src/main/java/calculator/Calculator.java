package calculator;

public class Calculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public int add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0; // 입력이 비어있을 경우 0 반환
        }
        String[] numbers = parseNumbers(input);
        return calculateSum(numbers);
    }

    private String[] parseNumbers(String input) {
        if (hasCustomDelimiter(input)) {
            return parseWithCustomDelimiter(input);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private String[] parseWithCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException(ERROR_PREFIX + "잘못된 형식입니다. 구분자 뒤에 줄 바꿈이 필요합니다.");
        }

        String delimiterSection = input.substring(2, delimiterEndIndex).trim();
        if (delimiterSection.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구분자가 필요합니다.");
        }

        String numbers = input.substring(delimiterEndIndex + 1);
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "숫자가 필요합니다.");
        }

        return numbers.split(delimiterSection); // 구분자로 숫자 분리
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int value = parseAndValidateNumber(number);
            sum += value;
        }
        return sum;
    }

    private int parseAndValidateNumber(String number) {
        try {
            int value = Integer.parseInt(number.trim());
            if (value < 0) {
                throw new IllegalArgumentException(ERROR_PREFIX + "양수값을 입력해주세요.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + "입력값을 확인해주세요.");
        }
    }
}