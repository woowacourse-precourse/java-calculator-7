package calculator;

public class Summation {
    Long sum;
    Long[] numbers;
    Summation(Long[] numbers) {
        this.numbers = numbers;
        this.sum = 0L;
    }

    void sum() {
        for (Long number : this.numbers) {
            if (number == null) {
                return;
            }
            sum += number;
        }
    }
}
