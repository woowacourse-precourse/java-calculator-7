package calculator;

import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String NEGATIVE_OR_ZERO_ERROR = "음수 또는 0은 입력되면 안됩니다.";

    int add (String inputString) {
        if(inputString.isEmpty()) return 0; // 공백 예외처리

        String delimiter = extractDelimiter(inputString); //조건 만족시 구분자 추가
        inputString = removeCustomDelimiterInit(inputString); //조건 만족시 커스텀구분자 생성식 제거

        negativeOrZeroCheck(inputString,delimiter); // -값, 0 예외처리

        return calculateAdd(inputString, delimiter);
    }

    void negativeOrZeroCheck(String inputString, String delimiter) {
        String[] split = inputString.split(delimiter);
        for (String number : split) {
            if(number.contains("-") || number.equals("0")) {
                throw new IllegalArgumentException(NEGATIVE_OR_ZERO_ERROR);
            }
        }
    }

    String extractDelimiter(String inputString) {
        if(inputString.startsWith("//")){
            String customDelimiter = inputString.substring(2, inputString.indexOf("\n"));
            return DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter);
        }
        return DEFAULT_DELIMITER;
    }

    String removeCustomDelimiterInit(String inputString) {
        if(inputString.startsWith("//")){
            return inputString.substring(inputString.indexOf("\n") + 1);
        }
        return inputString;
    }

    int calculateAdd(String inputString, String delimiter) {
        String[] split = inputString.split(delimiter);
        int sum = 0;
        for (String number : split) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
