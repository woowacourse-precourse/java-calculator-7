package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private final List<Character> delimiters = new ArrayList<>();
    private int index = 0;


    private void addDelimiter(char delimiter) {
        delimiters.add(delimiter);
    }

    private List<Character> getDelimiters() {
        return new ArrayList<>(delimiters);
    }

    public String[] getNumList(String inputString) {

        addDefaultDelimiters();

        if (inputString.startsWith("//")) {
            setIndexAndResetDelimiters(inputString);
        }
        String numString = inputString.substring(index);
        return numString.split(getDelimiterExpression());
    }


    private void addDefaultDelimiters() {
        delimiters.clear();
        addDelimiter(':');
        addDelimiter(',');
    }


    private void setIndexAndResetDelimiters(String inputString) {

        delimiters.clear();
        index = inputString.indexOf("\\n");
        validateCustomDelimiterFormat();
        addDelimiterToDelimiters(inputString);
        index += 2;
    }

    private String getDelimiterExpression() {
        StringBuilder delimiterExpression = new StringBuilder();
        for (char delimiter : getDelimiters()) {
            appendDelimiterToExpression(delimiterExpression, delimiter);
        }
        return delimiterExpression.toString();
    }

    private void appendDelimiterToExpression(StringBuilder expression, char delimiter) {
        if (!expression.isEmpty()) {
            expression.append("|");
        }
        expression.append("\\").append(delimiter);
    }

    private void addDelimiterToDelimiters(String inputString) {
        for (int i = 2; i < index; i++) {
            char currentDelimiter = inputString.charAt(i);
            validateDelimiterIsPeriod(currentDelimiter);
            validateDelimiterIsDigit(currentDelimiter);
            addDelimiter(currentDelimiter);
        }

        validateSingleDelimiter();

    }

    private void validateSingleDelimiter() {
        if (delimiters.size() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 하나여야 합니다.");
        }
    }

    private void validateDelimiterIsPeriod(char delimiter) {
        if (delimiter == '.') {
            throw new IllegalArgumentException("커스텀 구분자에 '.'이 들어올 수 없습니다.");
        }
    }

    private void validateDelimiterIsDigit(char delimiter) {
        if (Character.isDigit(delimiter)) {
            throw new IllegalArgumentException("커스텀 구분자로 숫자는 사용할 수 없습니다.");
        }
    }

    private void validateCustomDelimiterFormat() {
        if (index == -1) {
            throw new IllegalArgumentException("커스텀 구분자 입력이 잘못되었습니다.");
        }
    }
}
