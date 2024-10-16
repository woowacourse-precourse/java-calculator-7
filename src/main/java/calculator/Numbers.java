package calculator;

public class Numbers {
    private final String[] numbers;

    public Numbers(String[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("숫자는 비어 있을수 없습니다");
        }
        this.numbers = numbers;
    }

    public String[] getNumbers() {
        return numbers;
    }
}
