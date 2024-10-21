package calculator.model;

import calculator.common.ErrorMessage;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class Numbers {
    private final List<BigDecimal> numbers;

    public Numbers(List<BigDecimal> numbers) {
        this.numbers = numbers;
    }

    public List<BigDecimal> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public static Numbers of(String expression, Delimiters delimiters) {
        try {
            String[] rawElements = expression.split(delimiters.buildSplitRegex());
            List<BigDecimal> numbers = Arrays.stream(rawElements)
                    .filter(element -> (element != null && !element.isEmpty()))
                    .map(BigDecimal::new)
                    .peek(Numbers::validatePositive)
                    .toList();
            return new Numbers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_REGEX.getMessage());
        }
    }

    private static void validatePositive(BigDecimal number) {
        if (number.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_NUMBER.getMessage());
        }
    }
}
