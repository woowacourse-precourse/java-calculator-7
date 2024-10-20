package calculator.model;

import java.util.Arrays;
import java.util.List;

public class StringSeparator {

    public List<Integer> extractNumbers(String input) {
        verifyNegativeSeparator(input);
        try {
            String[] numbers = separateNumbers(input);
            return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException("구분자로 분리하는 과정에서 오류가 발생하였습니다.");
        }
    }

    private String[] separateNumbers(String inputString) {
        if (inputString.substring(0, 2).equals("//") && inputString.substring(3, 5).equals("\\n")) {
            return separateNumbersByCustom(inputString);
        }
        return inputString.split(",|;");
    }

    private String[] separateNumbersByCustom(String input) {
        char customSeparator = input.charAt(2);
        String numbers = input.substring(5);
        return numbers.split(",|;|" + customSeparator);
    }

    private void verifyNegativeSeparator(String input) {
        if (input.contains("-")) {
            throw new IllegalArgumentException("음수 기호는 사용할 수 없습니다.");
        }
    }
}
