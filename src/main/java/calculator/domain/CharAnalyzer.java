package calculator.domain;

import calculator.domain.delimiter.CustomDelimiterRegistrar;
import calculator.domain.delimiter.Delimiter;

import static calculator.domain.delimiter.CustomDelimiterPattern.CUSTOM_DELIMITER_END;
import static calculator.domain.delimiter.CustomDelimiterPattern.CUSTOM_DELIMITER_START;
import static calculator.domain.delimiter.DelimiterState.REGISTERED_DELIMITER;
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
            processCurrentNumber(currentChar);
        } else if (isRegisteredDelimiterChar(currentChar)) {
            processDelimiter();
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

    private void processCurrentNumber(char currentChar) {
        numberGenerator.appendNumber(currentChar);
    }

    private void processDelimiter() {
        numberGenerator.handleDelimiter(REGISTERED_DELIMITER.getState());
    }

    private void processCustomDelimiter() {
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
