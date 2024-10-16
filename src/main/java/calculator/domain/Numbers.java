package calculator.domain;

import java.util.List;

public class Numbers {
    private final long sum;
    public Numbers(Separator separator) {
        this.sum = sum(separator.getExtractedNumbers());
    }
    private long sum(List<Integer> numbers) {
        long sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }
    @Override
    public String toString() {
        return String.valueOf(sum);
    }
}
