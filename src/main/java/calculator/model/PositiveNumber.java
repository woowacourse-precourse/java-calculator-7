package calculator.model;

import java.util.regex.Pattern;

public class PositiveNumber {
    private final String REGEXP_ONLY_NUM = "^[\\d]*$";
    private final String EMPTY_NUMBER = "";

    private int count;

    public PositiveNumber(int count) {
        this.count = count;
    }

    public void plus(String numberAdded) {
        if (!Pattern.matches(REGEXP_ONLY_NUM, numberAdded)) {
            throw new IllegalArgumentException("잘못된 구분자를 포함합니다.");
        }
        if (numberAdded.equals(EMPTY_NUMBER)) {
            return;
        }

        int number = Integer.parseInt(numberAdded);
        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닌 수를 포함합니다.");
        }
        this.count += number;
    }

    public int getCount() {
        return this.count;
    }
}
