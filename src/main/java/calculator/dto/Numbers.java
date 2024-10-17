package calculator.dto;

import java.util.Arrays;

public class Numbers {
    private final int[] numbers;

    public Numbers(String[] inputs) {
        this.numbers = Arrays.stream(inputs)
                .filter(s -> !s.trim().isEmpty())
                .mapToInt(s -> {
                    try {
                        return Integer.parseInt(s.trim());
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("wrong number value: " + s);
                    }
                })
                .toArray();
    }

    public int sum(){
        return Arrays.stream(numbers).sum();
    }

    public int [] getNumbers(){
        return numbers;
    }
}
