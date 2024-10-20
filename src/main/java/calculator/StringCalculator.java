package calculator;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String patternString = "(//(.*)\\\\n)?(.*)";

    public String[] addCustomDelimiter(String input) {
        // 기본 구분자
        String delimiter = "[,:]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다");
        }
        String customDelimiter = matcher.group(2);
        String numberAndDelimiter = matcher.group(3);
        if (customDelimiter != null) {
            // "\" 을 문자열 자체로 취급하려면 "\\"으로 작성해야 한다.
            customDelimiter = customDelimiter.replace("\\", "\\\\");
            delimiter = "[,:" + customDelimiter + "]";
        }
        return new String[]{delimiter, numberAndDelimiter};
    }

    public BigInteger addString(String[] delimiterAndNumbers) {
        String delimiter = delimiterAndNumbers[0];
        String numberAndDelimiter = delimiterAndNumbers[1];
        // 2번째 인수로 limit==-1 로 선언하면 마지막까지 공백으로 받을 수 있음.
        String[] tokens = numberAndDelimiter.split(delimiter, -1);
        BigInteger sum = BigInteger.valueOf(0);
        for (String token : tokens) {
            BigInteger number = parseString(token);
            if (number.compareTo(BigInteger.valueOf(0)) < 0) {
                throw new IllegalArgumentException("음수는 입력 불가합니다");
            }
            sum = sum.add(number);
        }
        return sum;
    }

    private static BigInteger parseString(String token) {
        try {
            return new BigInteger(token);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다");
        }
    }
}
