package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import utils.Utils;
import validator.Validator;

public class Calculator {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final String DEFAULT_DELIMITER = "[,|:]";
    private static final int SUM_ZERO = 0;
    private static final String NO_DELIMITER = "";

    public int processInputAndSum(String userInput) {
        String customDelimiter = extractCustomDelimiter(userInput);
        String[] splitNumbers = splitByDelimiter(userInput, customDelimiter);
        List<Integer> numbers = extractValidNumbers(splitNumbers);
        return sumNumbers(numbers);
    }

    private int sumNumbers(List<Integer> numbers) {
        int sum = SUM_ZERO;
        for (Integer number : numbers) {
            Validator.validateIncludeZero(number);
            sum += number;
        }
        return sum;
    }

    private List<Integer> extractValidNumbers(String[] splitValues) {
        List<Integer> numbers = new ArrayList<>();
        for (String splitValue : splitValues) {
            if (Utils.containsOnlyNumbers(splitValue)) {
                numbers.add(Integer.parseInt(splitValue));
            }
        }
        return numbers;
    }

    private String[] splitByDelimiter(String userInput, String customDelimiter) {
        String numbersPart = extractNumbersPart(userInput, customDelimiter);
        String delimiter = determineDelimiter(customDelimiter);
        Validator.validateAllowedCharacters(numbersPart, customDelimiter);
        return numbersPart.split(delimiter);
    }

    // 커스텀 구분자가 있는 경우 기본 구분자와 커스텀 구분자 결합
    private String determineDelimiter(String customDelimiter) {
        if (!customDelimiter.isEmpty()) {
            return Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITER;
        }
        return DEFAULT_DELIMITER;
    }

    // 커스텀 구분자가 있는 경우 커스텀 구분자 선언 부분을 제외한 숫자 부분 추출
    private String extractNumbersPart(String userInput, String customDelimiter) {
        if (!customDelimiter.isEmpty()) {
            int customDelimiterEndIndex = userInput.indexOf(CUSTOM_DELIMITER_SUFFIX);
            int numberPartLength = customDelimiterEndIndex + CUSTOM_DELIMITER_SUFFIX.length();
            return userInput.substring(numberPartLength);
        }
        return userInput;
    }

    private String extractCustomDelimiter(String userInput) {
        Validator.validateDelimiterDeclaration(userInput, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = NO_DELIMITER;
        if (userInput.startsWith(CUSTOM_DELIMITER_PREFIX) && userInput.contains(CUSTOM_DELIMITER_SUFFIX)) {
            int delimiterEndIndex = userInput.indexOf(CUSTOM_DELIMITER_SUFFIX);
            customDelimiter = userInput.substring(CUSTOM_DELIMITER_START_INDEX, delimiterEndIndex);
        }
        return customDelimiter;
    }
}
