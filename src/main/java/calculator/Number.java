package calculator;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private String input;
    private List<Integer> numbers = new ArrayList<>();

    public Number(String input) {
        this.input = input;
        this.numbers = extractingNumbers();
    }

    private List<Integer> extractingNumbers() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }

            if (!sb.isEmpty() && (!Character.isDigit(c) || i == input.length() - 1)) {
                numbers.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }

        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int calculateTotal() {
        return numbers.stream().mapToInt(n -> n).sum();
    }
}
