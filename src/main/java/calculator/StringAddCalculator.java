package calculator;

public class StringAddCalculator {

    public static int add(String input) {
        // null 입력 검증
        InputValidator.validateNullInput(input);

        // 빈 문자열 검증
        if (InputValidator.isEmptyString(input)) {
            return 0;
        }

        // 구분자 포맷 확인 후 추출
        String delimiter = DelimiterProcessor.extractDelimiter(input);

        // 입력 문자열에서 계산할 부분 추출
        String numbers = extractNumbers(input);

        // 길이 검증
        if (input.startsWith("//")) {
            InputValidator.validateCustomDelimiterInputLength(numbers);
        }
        InputValidator.validateInputLength(numbers);

        // 구분자에 대한 예외 검증
        InputValidator.validateConsecutiveDelimiters(numbers, delimiter);

        // 음수 및 소수 입력 제한 검증 추가
        InputValidator.validateNoNegativeNumbers(numbers);
        InputValidator.validateNoDecimalNumbers(numbers);

        // 연속된 구분자를 하나의 구분자로 치환
        String finalInput = numbers.replaceAll("[" + delimiter + "]+", delimiter);

        // 숫자 합산
        return sum(finalInput, delimiter);
    }

    private static String extractNumbers(String input) {
        if (input.startsWith("//")) {
            return input.split("\n", 2)[1];
        }
        return input;
    }

    private static int sum(String input, String delimiter) {
        String[] numbers = input.split(delimiter);

        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }
}
