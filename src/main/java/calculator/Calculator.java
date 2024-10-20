package calculator;

public class Calculator {
    // 기본 구분자로 숫자 분리 및 합 계산 기능 구현

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEWLINE_REPLACEMENT = "\\n";

    public int calculateSumFromInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) { // 공백 문자열 처리
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER; // 기본 구분자

        if (userInput.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            userInput = userInput.replace(NEWLINE_REPLACEMENT, "\n");
            int delimiterIndex = userInput.indexOf("\n");
            delimiter = userInput.substring(2, delimiterIndex);
            userInput = userInput.substring(delimiterIndex + 1);

            if (userInput == null || userInput.isEmpty()) { // 공백 문자열 처리
                return 0;
            }
        }

        String[] splitNumbers = userInput.split(delimiter);
        return sumParsedNumbers(splitNumbers);
    }

    // 숫자의 합 계산
    private int sumParsedNumbers(String[] splitNumbers) {
        int sum = 0;
        for (String number : splitNumbers) {
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