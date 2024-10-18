package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private static final List<String> DEFAULT_SEPARATOR = List.of(":", ",");
    private static final String SEPARATOR_DELIMITER = "|";
    private static final String DOUBLE_BACKSLASH_DELIMITER = "\\\\";
    private static final String BACKSLASH_DELIMITER = "\\";

    private final List<String> separators;

    public CalculatorService() {
        separators = new ArrayList<>(DEFAULT_SEPARATOR);
    }

    public void addSeparator(String newSeparator) {
        if(!separators.contains(newSeparator)) {
            separators.add(newSeparator);
        }
    }

    public int calculate(String expression) {
        String[] splitExpression = expression.split(convertSeparatorToRegex(separators));

        int result = 0;
        for (String number : splitExpression) {
            int numberInt = Integer.parseInt(number);
            checkNumberIsPositive(numberInt);
            result += numberInt;
        }
        return result;
    }

    //List로 되어 있는 구분 문자들을 정규식에 맞게 하나의 문자열로 변환
    private String convertSeparatorToRegex(List<String> separators) {
        StringBuilder regexBuilder = new StringBuilder();

        for (String separator : separators) {
            // "\"(실제론 "\\")가 구분 문자라면 문자열 \\(실제로는 "\\\\")를 넣는다
            if (separator.equals(BACKSLASH_DELIMITER)) {
                regexBuilder.append(DOUBLE_BACKSLASH_DELIMITER);
            } else {
                regexBuilder.append(separator);
            }

            regexBuilder.append(SEPARATOR_DELIMITER);
        }

        String regex = regexBuilder.toString();
        //마지막 "|" 는 제거한다.
        if (!regex.isEmpty()) {
            regex = regex.substring(0, regex.length() - 1);
        }

        return regex;
    }

    private void checkNumberIsPositive(int numberInt) {
        if (numberInt <= 0) {
            throw new IllegalArgumentException("Not a positive number: " + numberInt);
        }
    }
}
