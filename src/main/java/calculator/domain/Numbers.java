package calculator.domain;

import java.util.List;

public class Numbers {
    private final long sum;
    public Numbers(List<String> extractedNumbers) {
        List<String> numbers = handleEmptyNumbers(extractedNumbers);
        this.sum = sum(numbers);
    }
    private List<String> handleEmptyNumbers(List<String> numbers) {
        return numbers.stream()
                .map(number -> number.isEmpty() ? "0" : number)
                .toList();
    }
    private long sum(List<String> numbers) {
        long sum = 0;
        for(String number : numbers) {
            sum += Long.parseLong(number);
        }
        return sum;
    }
    @Override
    public String toString() {
        return String.valueOf(sum);
    }
}
