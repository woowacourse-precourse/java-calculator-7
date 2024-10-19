package calculator;

public class Calculator {
    // 기본 구분자로 숫자 분리 및 합 계산 기능 구현

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEWLINE_REPLACEMENT = "\\n";

    public int calculateSumFromInput(String input) {
        if (input == null || input.isEmpty()) { // 공백 문자열 처리
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER; // 기본 구분자

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            input = input.replace(NEWLINE_REPLACEMENT, "\n");
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);

            if (input == null || input.isEmpty()) { // 공백 문자열 처리
                return 0;
            }
        }

        String[] numbers = input.split(delimiter);
        return sumParsedNumbers(numbers);
    }

    // 숫자의 합 계산
    private int sumParsedNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = validateAndConvertToInt(number);
            sum += num;
        }
        return sum;
    }

    // 유효성 검사 및 숫자 변환
    private int validateAndConvertToInt(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다: " + number);
        }
    }

}
