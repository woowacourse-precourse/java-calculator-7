package calculator.parsing;

import java.util.ArrayList;
import java.util.List;

public class ListChecker {
    private static final int MAX_DELIMITERS = 3;
    private static final String DEFAULT_DELIMITER1 = ":";
    private static final String DEFAULT_DELIMITER2 = ",";

    private final List<String> delimiters = new ArrayList<>();
    private String numbers;

    public List<String> getDelimiters(String input) {
        checkDelimiter(input);
        return new ArrayList<>(delimiters);
    }

    public String getNumbers() {
        return numbers;
    }

    private void checkDelimiter(String input) {
        validateInput(input);
        parseInput(input);
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
    }

    private void parseInput(String input) {
        if (input.startsWith("//")) {
            parseCustomDelimiter(input);
            return;
        }
        if (Character.isDigit(input.charAt(0))) {
            numbers = input; // 커스텀 구분자가 없으면 숫자로 처리
            return;
        }
        throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
    }

    private void parseCustomDelimiter(String input) {
        char[] charArray = input.toCharArray();
        if (charArray.length > 4 && charArray[3] == '\\' && charArray[4] == 'n') {
            addCustomDelimiter(charArray[2]);
            numbers = String.valueOf(charArray, 5, charArray.length - 5);
            return;
        }
        throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
    }

    private void addCustomDelimiter(char delimiter) {
        delimiters.add(DEFAULT_DELIMITER1);
        delimiters.add(DEFAULT_DELIMITER2);
        delimiters.add(String.valueOf(delimiter));
    }
}
