package calculator.domain;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.Delimiter;

import static calculator.domain.delimiter.CustomDelimiterPattern.CUSTOM_DELIMITER_END;
import static calculator.domain.delimiter.CustomDelimiterPattern.CUSTOM_DELIMITER_START;
import static calculator.domain.delimiter.DelimiterState.REGISTERED_DELIMITER;
import static calculator.exception.ErrorMessage.*;

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
            throw new IllegalStateException(END_OF_INPUT.getMessage());
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
            throw new IllegalArgumentException(INVALID_INPUT_VALUE.getMessage());
        }
    }

    private boolean isEndOfInput() {
        return currentIndex >= input.length();
    }

    private boolean isCustomDelimiterStart() {
        return input.startsWith(CUSTOM_DELIMITER_START.getPattern(), currentIndex);
    }

    private void processNumber(char currentChar) {
        numberGenerator.generator(currentChar);
    }

    private void markDelimiter() {
        numberGenerator.handleDelimiter(REGISTERED_DELIMITER.getState());
    }

    private void processCustomDelimiter() {
        customDelimiter.registerCustomDelimiter(input.substring(currentIndex), delimiter);
        currentIndex = input.indexOf(CUSTOM_DELIMITER_END.getPattern(), currentIndex) + 2;
    }

    private boolean isPositiveNumber(char ch) {
        return Character.isDigit(ch) && ch > '0';
    }

    private boolean isRegisteredDelimiterChar(char ch) {
        return delimiter.isRegisteredDelimiter(ch);
    }
}
