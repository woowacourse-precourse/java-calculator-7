package calculator;

import java.util.Arrays;
import java.util.List;

public class InputString {
    private final List<Integer> numbers;

    public InputString(String input) {
        this.numbers = inputToList(input);
    }

    private boolean isInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private List<Integer> inputToList(String input) {
        if (isInputEmpty(input)) {
            return List.of();
        }

        String delimiter = findDelimiter(input);

        if (input.startsWith("//")) {
            input = input.substring(4);
        }

        return Arrays.stream(input.split(delimiter))
            .peek(s -> {
                if (!s.matches("\\d+")) {
                    throw new IllegalArgumentException("숫자가 아닌 값이나 음수가 포함되어 있습니다.");
                }
            })
            .map(Integer::valueOf)
            .toList();
    }

    private String findDelimiter(String input) {
        if (input.startsWith("//")) {
            var frontInput = input.split("\n")[0];

            if(frontInput.length() != 3) {
                throw new IllegalArgumentException("커스텀 구분자가 한 글자 이상입니다.");
            }

            var delimiter = frontInput.substring(2);

            if (delimiter.matches("\\d+")) {
                throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
            }
            return delimiter;
        }
        return "[,:]";
    }

    public int getSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
