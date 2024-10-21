package calculator;

import java.util.ArrayList;
import java.util.List;


public class Delimiters {
    private final List<Delimiter> delimiters = new ArrayList<>();
    private final Index index = new Index(0);

    private static class Index {
        private int index;

        private Index(int index) {
            this.index = index;
        }

        private int getIndex() {
            return index;
        }

        private void setIndex(int index) {
            this.index = index;
        }

        private void incrementIndex(int amount) {
            this.index += amount;
        }

        private void validateCustomDelimiterFormat() {
            if (index == -1) {
                throw new IllegalArgumentException("커스텀 구분자 입력이 잘못되었습니다.");
            }
        }

    }

    private void addDelimiter(Delimiter delimiter) {
        delimiters.add(delimiter);
    }

    private List<Delimiter> getDelimiters() {
        return new ArrayList<>(delimiters);
    }

    public String[] getNumList(String inputString) {

        addDefaultDelimiters();

        if (inputString.startsWith("//")) {
            setIndexAndResetDelimiters(inputString);
        }
        String numString = inputString.substring(index.getIndex());
        return numString.split(getDelimiterExpression());
    }


    private void addDefaultDelimiters() {
        delimiters.clear();
        addDelimiter(new Delimiter(':'));
        addDelimiter(new Delimiter(','));
    }


    private void setIndexAndResetDelimiters(String inputString) {

        delimiters.clear();
        index.setIndex(inputString.indexOf("\\n"));
        index.validateCustomDelimiterFormat();
        addDelimiterToDelimiters(inputString);
        index.incrementIndex(2);
    }

    private String getDelimiterExpression() {
        StringBuilder delimiterExpression = new StringBuilder();
        for (Delimiter delimiter : getDelimiters()) {
            appendDelimiterToExpression(delimiterExpression, delimiter.getDelimiter());
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
        for (int i = 2; i < index.getIndex(); i++) {
            Delimiter currentDelimiter = new Delimiter(inputString.charAt(i));
            addDelimiter(currentDelimiter);
        }

        validateSingleDelimiter();

    }

    private void validateSingleDelimiter() {
        if (delimiters.size() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 하나여야 합니다.");
        }
    }


}
