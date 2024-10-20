package calculator.domain;

import java.math.BigDecimal;
import java.util.List;

public class Numbers {
    private final BigDecimal sum;
    public Numbers(List<String> extractedNumbers) {
        List<String> numbers = handleEmptyNumbers(extractedNumbers);
        this.sum = sum(numbers);
    }
    private List<String> handleEmptyNumbers(List<String> numbers) {
        return numbers.stream()
                .map(number -> number.isEmpty() ? "0" : number)
                .peek(this::isValidNumber)
                .toList();
    }
    private void isValidNumber(String number) {
        try {
            new BigDecimal(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    private BigDecimal sum(List<String> numbers) {
        BigDecimal sum = BigDecimal.ZERO;
        for(String number : numbers) {
            sum = sum.add(new BigDecimal(number));
        }
        return sum;
    }
    @Override
    public String toString() {
        return sum.toString();
    }
}
