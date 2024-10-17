package calculator;

import java.util.List;

public class Numbers {

    private static final int MIN_INDEX = 0;
    private static final int MAX_NUMBER_DIGITS = 30;

    private final List<Number> values;

    private Numbers(List<Number> values) {
        validateNumberCount(values.size());
        this.values = values;
    }

    public static Numbers of(List<Number> values) {
        return new Numbers(values);
    }

    public int size() {
        return values.size();
    }

    public Number findByIndex(int index) {
        validateIndex(index);
        return values.get(index);
    }

    private void validateNumberCount(int count) {
        if (count > MAX_NUMBER_DIGITS) {
            throw new IllegalArgumentException("[ERROR] 숫자는 최대 30 개를 초과할 수 없습니다.");
        }
    }

    private void validateIndex(int index) {
        if (index < MIN_INDEX || index >= values.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 범위의 인덱스입니다.");
        }
    }
}
