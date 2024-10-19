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
        if (!userInput.startsWith(prefix)) {
            throw new CalculatorException("커스텀 구분자는 " + prefix + "로 시작해야 합니다.");
        }
        if (!userInput.contains(suffix)) {
            throw new CalculatorException("커스텀 구분자 " + suffix + "를 포함해야 합니다.");
        }
        return true;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}