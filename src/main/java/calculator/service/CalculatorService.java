package calculator.service;

import java.util.List;

public class CalculatorService {

    public String calculateSumFormString(String inputString) {

        List<String> delimiters = setDelimiter(inputString);
        return inputString;
    }

    public List<String> setDelimiter(String inputString) {
        if (!isCustomDelimiter(inputString)) {
            return List.of(",", ":");
        }

        String customDelimiter = parseCustomDelimiter(inputString);
        validCustomDelimiter(customDelimiter);

        return List.of(",", ":", customDelimiter);
    }

    public void validCustomDelimiter(String delimiter) {
        checkDelimiterLength(delimiter);
        checkDelimiterIsNumber(delimiter);
        checkDelimiterPlusMinus(delimiter);
    }

    public boolean isCustomDelimiter(String inputString) {
        return inputString.startsWith("//") && inputString.contains("\n");
    }

    public String parseCustomDelimiter(String inputString) {
        return inputString.substring(2, inputString.indexOf("\n"));
    }

    public void checkDelimiterLength(String delimiter) {
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("구분자는 한 글자여야 합니다.");
        }
    }

    public void checkDelimiterIsNumber(String delimiter) {
        if (Character.isDigit(delimiter.charAt(0))) {
            throw new IllegalArgumentException("구분자는 숫자일 수 없습니다.");
        }
    }

    public void checkDelimiterPlusMinus(String delimiter) {
        if (delimiter.equals("+") || delimiter.equals("-")) {
            throw new IllegalArgumentException("구분자는 +, - 가 될 수 없습니다.");
        }
    }
}
