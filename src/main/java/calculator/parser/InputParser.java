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
        String trimmedInput = input.trim();

        if (trimmedInput.contains(" ")) {
            throw new IllegalArgumentException("Error: 커스텀 구분자가 아닌 공백은 불가능합니다.");
        }
        return trimmedInput;
    }
}
