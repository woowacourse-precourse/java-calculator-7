package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    ArrayList<String> delimiters = new ArrayList<>(List.of(",", ":"));

    public BigInteger calculate(String inputString) {
        inputString = extractDelimiter(inputString);

        String regex = String.join("|", delimiters);
        String[] splitByDelimiter = inputString.split(regex);

        return sumNumbers(splitByDelimiter);

    }

    private String extractDelimiter(String inputString) {
        if (inputString.startsWith(CUSTOM_DELIMITER_START)) {
            if (inputString.contains(CUSTOM_DELIMITER_END)) {
                String newDelimiter = inputString.substring(2, inputString.indexOf("\\n"));
                if (newDelimiter.isEmpty() || newDelimiter.matches("\\d+")) {
                    throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
                }
                delimiters.add(Pattern.quote(newDelimiter));
                inputString = inputString.substring(inputString.lastIndexOf("\\n") + 2);
            } else {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
            }
        }
        return inputString;
    }

    private BigInteger sumNumbers(String[] splitByDelimiter) {
        BigInteger result = BigInteger.ZERO;
        for (String num : splitByDelimiter) {
            if (num.isEmpty()) {
                num = "0";
            }
            BigInteger addNum = new BigInteger(num);
            if (addNum.compareTo(BigInteger.ZERO) < 0) {
                throw new IllegalArgumentException("음수 값은 허용되지 않습니다.");
            }
            result = result.add(addNum);
        }
        return result;
    }
}
