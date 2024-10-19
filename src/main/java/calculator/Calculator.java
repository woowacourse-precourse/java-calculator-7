package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final String DEFAULT_DELIMITER = "[,|:]";

    // 커스텀 구분자가 있는 경우 기본 구분자와 커스텀 구분자 결합
    public String determineDelimiter(String customDelimiter) {
        if (!customDelimiter.isEmpty()) {
            String CustomAndDefaultDelimiter = Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITER;
            return CustomAndDefaultDelimiter;
        }
        return DEFAULT_DELIMITER;
    }

    // 커스텀 구분자가 있는 경우 커스텀 구분자 선언 부분을 제외한 숫자 부분 추출
    public String extractNumbersPart(String userInput, String customDelimiter) {
        if (!customDelimiter.isEmpty()) {
            int customDelimiterEndIndex = userInput.indexOf(CUSTOM_DELIMITER_SUFFIX);
            int numberPartLength = customDelimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length();
            String numberPart = userInput.substring(numberPartLength);
            return numberPart;
        }
        return userInput;
    }

    public String extractCustomDelimiter(String userInput) {
        String customDelimiter = "";
        if (userInput.startsWith(CUSTOM_DELIMITER_PREFIX) && userInput.contains(CUSTOM_DELIMITER_SUFFIX)) {
            int delimiterEndIndex = userInput.indexOf(CUSTOM_DELIMITER_SUFFIX);
            customDelimiter = userInput.substring(CUSTOM_DELIMITER_START_INDEX, delimiterEndIndex);
        }
        return customDelimiter;
    }
}
