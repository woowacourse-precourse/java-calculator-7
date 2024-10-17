package calculator.domain;

public class CharAnalyzer {
    private final String input;
    private final Delimiter delimiter;
    private final CustomDelimiter customDelimiter;
    private final SumCalculator sumCalculator;
    private int currentIndex;

    public CharAnalyzer(String input, Delimiter delimiter, CustomDelimiter customDelimiter, SumCalculator sumCalculator) {
        this.input = input;
        this.delimiter = delimiter;
        this.customDelimiter = customDelimiter;
        this.sumCalculator = sumCalculator;
        this.currentIndex = 0;
    }

    public void analyzeAllChars() {
        while (currentIndex < input.length()) {
            analyzeNextChar();
        }
    }

    private void analyzeNextChar() {
        if (currentIndex >= input.length()) {
            throw new IllegalStateException("문자열의 끝에 도달했습니다.");
        }

        if (input.startsWith("//", currentIndex)) {
            processCustomDelimiter();
            return;
        }

        char currentChar = input.charAt(currentIndex);
        currentIndex++;

        if (isPositiveNumber(currentChar)) {
            sumCalculator.sum(currentChar);
        }
    }

    private void processCustomDelimiter() {
        customDelimiter.registerCustomDelimiter(input.substring(currentIndex), delimiter);
        currentIndex = input.indexOf("\\n", currentIndex) + 1;
    }

    private boolean isPositiveNumber(char ch) {
        return Character.isDigit(ch) && ch > '0';
    }

    private boolean isDelimiter(char ch) {
        return delimiter.isRegisteredDelimiter(ch);
    }

}
