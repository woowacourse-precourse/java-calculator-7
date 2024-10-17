package calculator.domain;

public class Calculator {
    public int sum(String[] elements) {
        int num = 0;
        for (String element : elements) {
            num += checkValid(element);
        }
        return num;
    }

    public int checkValid(String value) {
        int num;
        try {
            num = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (num < 0) {
            throw new IllegalArgumentException();
        }

        return num;
    }
}
