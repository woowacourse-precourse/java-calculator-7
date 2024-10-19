package calculator.domain;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.Delimiter;
import static calculator.domain.delimiter.DelimiterState.REGISTERED_DELIMITER;

public class CharAnalyzer {
    private final String input;
    private final Delimiter delimiter;
    private final CustomDelimiter customDelimiter;
    private final NumberGenerator numberGenerator;
    private int currentIndex;

    public CharAnalyzer(String input, Delimiter delimiter, CustomDelimiter customDelimiter, NumberGenerator numberGenerator) {
        this.input = input;
        this.delimiter = delimiter;
        this.customDelimiter = customDelimiter;
        this.numberGenerator = numberGenerator;
        this.currentIndex = 0;
    }

    public void analyzeAllChars() {
        while (currentIndex < input.length()) {
            analyzeNextChar();
        }

        numberGenerator.flushConsecutiveNumbers();
    }

    private void analyzeNextChar() {
        if (isEndOfInput()) {
            throw new IllegalStateException("문자열의 끝에 도달했습니다.");
        }

        if (isCustomDelimiterStart()) {
            processCustomDelimiter();
            return;
        }

        char currentChar = input.charAt(currentIndex);
        currentIndex++;

        if (isPositiveNumber(currentChar)) {
            processNumber(currentChar);
        } else if (isRegisteredDelimiterChar(currentChar)) {
            markDelimiter();
        } else {
            throw new IllegalArgumentException("입력 값은 구분자와 양수로 구성된 문자열이어야합니다.");
        }
    }

    private boolean isEndOfInput() {
        return currentIndex >= input.length();
    }

    private boolean isCustomDelimiterStart() {
        return input.startsWith("//", currentIndex);
    }

    private void processNumber(char currentChar) {
        numberGenerator.generator(currentChar);
    }

    private void markDelimiter() {
        numberGenerator.isDelimiter(REGISTERED_DELIMITER.getState());
    }

    private void processCustomDelimiter() {
        customDelimiter.registerCustomDelimiter(input.substring(currentIndex), delimiter);
        currentIndex = input.indexOf("\\n", currentIndex) + 2;
    }

    private boolean isPositiveNumber(char ch) {
        return Character.isDigit(ch) && ch > '0';
    }

    private boolean isRegisteredDelimiterChar(char ch) {
        return delimiter.isRegisteredDelimiter(ch);
    }
}
