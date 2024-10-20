package calculator.validator;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class DefaultValidator implements Validator {

    private static final String DEFAULT_DELIMITER = ",|:"; // 기본 구분자
    private final String delimiterPattern;

    private DefaultValidator(String customDelimiterPattern) {
        if (customDelimiterPattern == null || customDelimiterPattern.isEmpty()) {
            this.delimiterPattern = DEFAULT_DELIMITER;
        } else {
            this.delimiterPattern = customDelimiterPattern + "|" + DEFAULT_DELIMITER;
        }
    }

    public static DefaultValidator create(String customDelimiterPattern) {
        return new DefaultValidator(customDelimiterPattern);
    }

    @Override
    public void validate(String[] tokens) {
        for (String token : tokens) {
            if (!isValidNumber(token) && !isValidDelimiter(token)) {
                throw new IllegalArgumentException("숫자 또는 올바른 구분자가 아닌 값이 포함되어 있습니다.");
            }
        }
    }

    private boolean isValidNumber(String token) {
        try {
            BigDecimal number = new BigDecimal(token);
            if (number.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("음수 또는 0은 허용되지 않습니다.");
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidDelimiter(String token) {
        return Pattern.matches(delimiterPattern, token);
    }
}
