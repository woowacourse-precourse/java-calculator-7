package calculator.model;

import calculator.constant.CustomDelimiterPattern;
import calculator.constant.Separator;
import java.util.ArrayList;
import java.util.List;

public class DelimiterManager {

    private final List<String> customDelimiters = new ArrayList<>();
    private final static String PREFIX = CustomDelimiterPattern.PREFIX.getSymbol();
    private final static String SUFFIX = CustomDelimiterPattern.SUFFIX.getSymbol();
    private static final int NOT_FOUND = -1;
    private static final int SINGLE_CHARACTER_LENGTH = 1;

    public void addCustomDelimiter(String inputString) {
        int delimiterStartIndex = inputString.indexOf(PREFIX);
        int delimiterEndIndex = inputString.indexOf(SUFFIX, delimiterStartIndex);

        validateCustomDelimiterPositions(delimiterStartIndex, delimiterEndIndex);

        String delimiterPart = extractDelimiter(inputString, delimiterStartIndex, delimiterEndIndex);

        validateDelimiterLength(delimiterPart);

        customDelimiters.add(delimiterPart);
    }

    private void validateCustomDelimiterPositions(int delimiterStartIndex, int delimiterEndIndex) {
        if (delimiterStartIndex == NOT_FOUND || delimiterEndIndex == NOT_FOUND) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
    }

    private String extractDelimiter(String input, int delimiterStartIndex, int delimiterEndIndex) {
        return input.substring(delimiterStartIndex + PREFIX.length(), delimiterEndIndex);
    }

    private void validateDelimiterLength(String delimiterPart) {
        if (delimiterPart.length() != SINGLE_CHARACTER_LENGTH) {
            throw new IllegalArgumentException("구분자는 하나의 문자여야 합니다.");
        }
    }

    public List<String> getAllDelimiters() {
        List<String> allDelimiters = new ArrayList<>();

        addDefaultDelimiters(allDelimiters);
        allDelimiters.addAll(customDelimiters);

        return allDelimiters;
    }

    private void addDefaultDelimiters(List<String> delimiters) {
        for (Separator separator : Separator.values()) {
            delimiters.add(separator.getSymbol());
        }
    }
}
