package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class DelimiterChecker {

    private String input;
    private List<Character> delimiters = new ArrayList<>(List.of(',', ':'));

    private static final String CUSTOM_DELIMITER_BEGIN = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CUSTOM_MARK_END_INDEX = 5;

    public DelimiterChecker() {
    }

    public void putString(String input) {
        this.input = input;
    }

    public List<Integer> getNumbers() {
        if (isCustomed()) {
            addDelimiter();
            deleteCustomMark();
        }
        return leaveOnlyNumbers();
    }

    private boolean isCustomed() {
        return input.startsWith(CUSTOM_DELIMITER_BEGIN) &&
                input.contains(CUSTOM_DELIMITER_END);
    }

    private void addDelimiter() {
        delimiters.add(input.charAt(CUSTOM_DELIMITER_INDEX));
    }

    private void deleteCustomMark() {
        input = input.substring(CUSTOM_MARK_END_INDEX);
    }

    private List<Integer> leaveOnlyNumbers() {
        List<Integer> numbers = new ArrayList<>();
        String number = "";
        for (int current = 0; current < input.length(); current++) {
            char currentChar = input.charAt(current);

            if (Character.isDigit(currentChar)) number += currentChar;
            else if (isRightDelimiter(currentChar)) {
                numbers.add(Integer.parseInt(number));
                number = "";
            }
        }
        if (!number.isEmpty()) numbers.add(Integer.parseInt(number));
        return numbers;
    }

    private boolean isRightDelimiter(char currentChar) {
        if (delimiters.contains(currentChar)) return true;
        else throw new IllegalArgumentException();
    }
}
