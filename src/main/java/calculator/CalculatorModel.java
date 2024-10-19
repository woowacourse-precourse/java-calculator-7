package calculator;

import java.math.BigInteger;

public class CalculatorModel {

    public BigInteger processInput(String input, boolean extendedMode) {
        if (input.isEmpty()) {
            return BigInteger.ZERO;
        }

        String substringToCheck = extendedMode && input.length() > 5 ? input.substring(5) : input;
        if (substringToCheck.matches(".*[^0-9]{2,}.*")) {
            throw new IllegalArgumentException("입력 문자열에 2개 이상의 연속된 숫자가 아닌 문자가 포함되어 있습니다.");
        }

        String delimiters = ",:";
        if (extendedMode && input.length() > 2) {
            char additionalDelimiter = input.charAt(2);
            delimiters += additionalDelimiter;
        }

        int startIndex = extendedMode ? 5 : 0;
        for (int i = startIndex; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c) && delimiters.indexOf(c) == -1) {
                throw new IllegalArgumentException("입력 문자열에 허용되지 않은 문자가 포함되어 있습니다: " + c);
            }
        }

        if (extendedMode) {
            if (input.length() <= 5 || !Character.isDigit(input.charAt(5)) || !Character.isDigit(
                    input.charAt(input.length() - 1))) {
                throw new IllegalArgumentException("Extended 모드에서는 5번째 자리와 맨 끝의 문자가 숫자여야 합니다.");
            }
        } else {
            if (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(input.length() - 1))) {
                throw new IllegalArgumentException("입력 문자열의 맨 앞과 맨 뒷 부분은 숫자여야 합니다.");
            }
        }

        return sumNumbers(input, extendedMode);
    }

    private BigInteger sumNumbers(String input, boolean extendedMode) {
        String delimiters = "[,:]";
        if (extendedMode && input.length() > 2) {
            char additionalDelimiter = input.charAt(2);
            delimiters = "[,:" + additionalDelimiter + "]";
        }

        String substringToProcess = extendedMode && input.length() > 5 ? input.substring(5) : input;
        String[] numbers = substringToProcess.split(delimiters);
        BigInteger sum = BigInteger.ZERO;
        for (String number : numbers) {
            sum = sum.add(new BigInteger(number));
        }
        return sum;
    }
}
