package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    //TODO 사용하지 않을 경우 삭제 현재 NumbersTest에서만 사용중
    public void addNumber(Integer... numbers) {
        for (Integer number : numbers) {
            if (number == null || number < 0) {
                throw new IllegalArgumentException("숫자가 0이거나 NULL이어서는 안됩니다.");
            }
            this.numbers.add(number);
        }
    }

    public void addNumber(Integer number) {
        if (number == null || number < 0) {
            throw new IllegalArgumentException("숫자가 0이거나 NULL이어서는 안됩니다.");
        }
        numbers.add(number);
    }

    public Integer sumNumbers() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
