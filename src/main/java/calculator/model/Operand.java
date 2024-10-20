package calculator.model;

import java.util.List;
import java.util.stream.Collectors;

public record Operand(int number) {

    public Operand {
        if (number <= 0) {
            throw new IllegalArgumentException("0이하의 숫자는 입력할 수 없습니다.");
        }
    }

    public static Operand fromString(String input) {
        try {
            return new Operand(Integer.parseInt(input));
        } catch (NumberFormatException exception) {
            System.out.println(input);
            throw new IllegalArgumentException("피연산자는 숫자여야 합니다.");
        }
    }

    public static List<Operand> fromStringList(List<String> input) {
        return input.stream()
                .map(Operand::fromString)
                .collect(Collectors.toList());
    }



}
