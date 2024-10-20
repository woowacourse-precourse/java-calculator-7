package calculator;

import java.util.List;

public class Validator {

    public void validate(String userInput, List<String> numbers, String delimiter) {
        checkContainsNegative(userInput, delimiter);
    }

    private void checkContainsNegative(String userInput, String delimiter) {
        if (!delimiter.contains("-")) {
            if (userInput.contains("-")) {
                throw new IllegalArgumentException("음수가 입력되었습니다.");
            }
        }
    }
}
