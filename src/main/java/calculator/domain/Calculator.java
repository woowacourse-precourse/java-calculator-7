package calculator.domain;

public class Calculator {
    public int sum(String[] elements) {
        int num = 0;
        for (String element : elements) {
            num += stringToInt(element);
        }
        return num;
    }

    public int stringToInt(String value) {
        int num;
        try {
            num = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 형태의 숫자가 아닙니다.");
        }

        if (num < 0) {
            throw new IllegalArgumentException("양수만 입력가능합니다.");
        }

        return num;
    }
}
