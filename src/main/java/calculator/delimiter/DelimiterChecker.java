package calculator.delimiter;

import calculator.CalculatorException;

public class DelimiterChecker {

    private final String prefix;
    private final String suffix;

    public DelimiterChecker(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public boolean isCustomDelimiter(String userInput) {
        if (isNotStartPrefix(userInput)) {
            return false;
        }
        return true;
    }

    public String getSuffix() {
        return suffix;
    }

    public String extractCustomDelimiter(String userInput) {
        if (isNotStartPrefix(prefix)) {
            throw new CalculatorException("커스텀 시작 식별자가 포함되어 있지 않습니다.");
        }

        int suffixIdx = userInput.indexOf(suffix);
        if (suffixIdx == -1) {
            throw new CalculatorException("커스텀 종료 식별자가 포함되어 있지 않습니다.");
        }

        return userInput.substring(prefix.length(), suffixIdx);
    }

    private boolean isNotStartPrefix(String userInput) {
        return !userInput.startsWith(prefix);
    }

}