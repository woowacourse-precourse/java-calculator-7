package calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumCalculator {

    public BigDecimal calculateSum(String input) {
        String[] tokens = splitNumbers(input);
        BigDecimal sumResult = BigDecimal.ZERO;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                BigDecimal number = parseToBigDecimal(token);
                if (number.compareTo(BigDecimal.ZERO) < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sumResult = sumResult.add(number);
            }
        }

        return sumResult.setScale(0, RoundingMode.DOWN);
    }

    private String[] splitNumbers(String input) {
        String delimiter = ",|:";
        String numbers = input;

        Matcher matcher = Pattern.compile("//(.*)\\\\n(.*)").matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            if (customDelimiter.matches(".*[0-9.].*")) {
                throw new IllegalArgumentException("커스텀 구분자에 숫자나 '.'이 포함될 수 없습니다.");
            }
            delimiter += "|" + Pattern.quote(customDelimiter);
            numbers = matcher.group(2);
        }

        return numbers.split(delimiter);
    }

    private BigDecimal parseToBigDecimal(String token) {
        try {
            return new BigDecimal(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못되거나 허용되지 않은 형식입니다.");
        }
    }
}