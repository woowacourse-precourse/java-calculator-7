package calculator.parser;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Error: 문자열은 null이 될수 없습니다.");
        }
        if (input.matches(".*\".*\".*")) {
            throw new IllegalArgumentException("Error: 하나의 문자열만 입력해야 합니다.");
        }
    }

    public String processSpace(String input) {
        return input.trim();
    }

    public List<Integer> parse(String input) {
        String[] splitInput = input.split("[,:]");
        List<Integer> numbers = new ArrayList<>();

        for (String str : splitInput) {
            if (str.isEmpty()) {
                numbers.add(0);
            } else {
                if (str.contains(" ")) {
                    throw new IllegalArgumentException("Error: 입력 값에 불필요한 공백이 있습니다.");
                }
                if (!str.matches("\\d+")) {
                    throw new IllegalArgumentException("Error: 입력 값은 숫자여야 합니다.");
                }
                int number = Integer.parseInt(str);
                if (number < 0) {
                    throw new IllegalArgumentException("Error: 입력 값은 음수일 수 없습니다.");
                }
                numbers.add(number);
            }
        }
        return numbers;
    }
}
