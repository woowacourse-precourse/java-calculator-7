package calculator.domain;

import java.util.List;

public class Numbers {
    private final long sum;
    public Numbers(Separator separator) {
        List<String> numbers = separator.getExtractedNumbers();
        validate(numbers);
        this.sum = sum(numbers);
    }
    private void validate(List<String> numbers) {
        for(String number : numbers) {
            if(number.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
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
