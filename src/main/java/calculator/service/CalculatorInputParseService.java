package calculator.service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorInputParseService {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PART_REGEX = "^//(.*?)\\\\n";

    public CalculatorInputParseService() {
    }

    public List<BigInteger> parseSumInput(String input) {
        String delimiterRegex = DEFAULT_DELIMITER_REGEX;

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PART_REGEX);
        Matcher matcher = pattern.matcher(input);

        String numbersPart;
        if (matcher.find()) {
            String comment = matcher.group();
            String delimiterPart = comment.substring(0, comment.indexOf("\\n") + 2);
            numbersPart = input.substring(delimiterPart.length());
            String customDelimiter = delimiterPart.substring(2, delimiterPart.length() - 2);

            delimiterRegex += "|" + "[" + customDelimiter + "]";
        } else {
            numbersPart = input;
        }

        String[] numberStrings = numbersPart.split(delimiterRegex);

        return Arrays.stream(numberStrings)
                .map(this::parseSumNumber)
                .collect(Collectors.toList());
    }

    private BigInteger parseSumNumber(String numberStr) {
        BigInteger parsedNumber = null;

        try {
            parsedNumber = new BigInteger(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("변환할 수 없는 숫자입니다.: " + numberStr);
        }

        if (parsedNumber.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("숫자는 양수만 허용됩니다.: " + numberStr);
        }

        return parsedNumber;
    }
}
