package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private final List<Character> delimiters = new ArrayList<>();
    private int index = 2;

    public void addDelimiter(char delimiter) {
        delimiters.add(delimiter);
    }

    public List<Character> getDelimiters() {
        return new ArrayList<>(delimiters);
    }

    public boolean hasSingleDelimiter() {
        return delimiters.size() == 1;
    }

    public int findLastDelimiterIndex(String inputString) {
        int length = inputString.length();

        while (index < length - 1) {
            char currentChar = inputString.charAt(index);
            char nextChar = inputString.charAt(index + 1);

            if (currentChar == '\\' && nextChar == 'n') {
                return index;
            }
            index++;
        }
        return index;
    }

    public void appendDelimiter(StringBuilder expression, char delimiter) {
        if (!expression.isEmpty()) {
            expression.append("|");
        }
        expression.append("\\").append(delimiter);
    }

    public void clearDelimiters() {
        delimiters.clear();
    }

    public String extractNumberString(String inputString) {
        addDelimiter(':');
        addDelimiter(',');

        if (inputString.startsWith("//")) {
            clearDelimiters();
            int index = findLastDelimiterIndex(inputString);

            extractDelimiters(inputString, index);

            validateSingleDelimiter();

            return inputString.substring(index + 2);
        }

        return inputString;
    }

    private void extractDelimiters(String inputString, int index) {
        for (int i = 2; i < index; i++) {
            addDelimiter(inputString.charAt(i));
        }
    }

    private void validateSingleDelimiter() {
        if (!hasSingleDelimiter()) {
            throw new IllegalArgumentException("커스텀 구분자는 하나여야 합니다.");
        }
    }
}
