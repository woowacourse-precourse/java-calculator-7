package calculator;

public class Calculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        String delimiter = extractDelimiter(input); // 구분자추출
        input = extractNumbers(input); // 숫자부분만 추출
        return sumNumbers(input.split(delimiter)); // 구분자로 분리된 숫자 더하기
    }

}
