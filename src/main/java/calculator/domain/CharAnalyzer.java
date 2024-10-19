package calculator.domain;

import calculator.domain.delimiter.CustomDelimiterRegistrar;
import calculator.domain.delimiter.Delimiter;

import static calculator.domain.delimiter.CustomDelimiterPattern.CUSTOM_DELIMITER_END;
import static calculator.domain.delimiter.CustomDelimiterPattern.CUSTOM_DELIMITER_START;
import static calculator.view.enums.Message.END_OF_INPUT;
import static calculator.view.enums.Message.INVALID_INPUT_VALUE;

public class CharAnalyzer {
    private final String input;
    private final Delimiter delimiter;
    private final CustomDelimiterRegistrar customDelimiterRegistrar;
    private final NumberAccumulator numberGenerator;
    private int currentIndex;

    public CharAnalyzer(String input, Delimiter delimiter, CustomDelimiterRegistrar customDelimiterRegistrar, NumberAccumulator numberGenerator) {
        this.input = input;
        this.delimiter = delimiter;
        this.customDelimiterRegistrar = customDelimiterRegistrar;
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
        validateInputEnd();
        if (isCustomDelimiter()) return;

        char currentChar = input.charAt(currentIndex);
        currentIndex++;

        processChar(currentChar);
    }

    private void validateInputEnd() {
        if (hasMoreChar()) {
            throw new IllegalStateException(END_OF_INPUT.getMessage());
        }
    }

    private boolean isCustomDelimiter() {
        if (isCustomDelimiterStart()) {
            registerCustomDelimiter();
            return true;
        }
        return false;
    }

    private void processChar(char currentChar) {
        if (isPositiveNumber(currentChar)) {
            processNumber(currentChar);
        } else if (isRegisteredDelimiterChar(currentChar)) {
            processDelimiter();
        } else {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE.getMessage());
        }
    }

    private boolean hasMoreChar() {
        return currentIndex >= input.length();
    }

    private boolean isCustomDelimiterStart() {
        return input.startsWith(CUSTOM_DELIMITER_START.getPattern(), currentIndex);
    }

    private void processNumber(char currentChar) {
        numberGenerator.appendNumber(currentChar);
    }

    private void processDelimiter() {
        if (!numberGenerator.isConsecutiveNumbersEmpty()) {
            numberGenerator.flushConsecutiveNumbers();
        }
    }

    private void registerCustomDelimiter() {
        customDelimiterRegistrar.registerCustomDelimiter(input.substring(currentIndex), delimiter);
        currentIndex = input.indexOf(CUSTOM_DELIMITER_END.getPattern(), currentIndex) + 2;
    }

    private boolean isPositiveNumber(char ch) {
        return Character.isDigit(ch) && ch > '0';
    }

    private boolean isRegisteredDelimiterChar(char ch) {
        return delimiter.isRegisteredDelimiter(ch);
    }
}
