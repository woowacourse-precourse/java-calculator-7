package calculator.model;

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
                    .toList();
            return new Numbers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자의 형식이 잘못되었습니다");
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("정규 표현식이 잘못되었습니다");
        }
    }
}
