package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public String getCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile("//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            if (delimiter.matches("[0-9]")) {
                throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
            }
            return delimiter;
        }
        throw new IllegalArgumentException("올바른 커스텀 구분자가 없습니다.");
    }

    public String getNumbersAfterDelimiter(String input) {
        Pattern pattern = Pattern.compile("//.\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public boolean isCustomDelimiterPattern(String input) {
        Pattern pattern = Pattern.compile("//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean isValidDefaultPattern(String input) {
        Pattern pattern = Pattern.compile("^[0-9,:]*$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean isValidCustomPattern(String numbers, String delimiter) {
        String regex = "^[0-9" + Pattern.quote(delimiter) + "]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numbers);
        return matcher.matches();
    }

    public long calculateSum(String[] tokens) {
        long sum = 0;
        for (String token : tokens) {
            long number = parseNumber(token);
            checkOverflow(sum, number);
            sum += number;
        }
        return sum;
    }

    public long parseNumber(String token) {
        try {
            return Long.parseLong(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 long의 범위를 초과합니다: " + token);
        }
    }

    public void checkOverflow(long sum, long number) {
        if (sum > Long.MAX_VALUE - number) {
            throw new IllegalArgumentException("덧셈 결과가 long의 범위를 초과합니다.");
        }
    }

    public void validateContinuousDelimiters(String numbers, String delimiter) {
        if (!delimiter.equals(",|:")) {
            if (numbers.contains(delimiter + delimiter)) {
                throw new IllegalArgumentException("커스텀 구분자가 연속될 수 없습니다: " + delimiter);
            }
        } else {
            if (numbers.contains(",,") || numbers.contains("::")) {
                throw new IllegalArgumentException("연속된 쉼표(,) 또는 콜론(:)은 허용되지 않습니다.");
            }
        }
    }

    public boolean isEmptyString(String numbers) {
        return numbers == null || numbers.isBlank();
    }
}
