package calculator.domain;

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
            numberGenerator.generator(currentChar);
        } else if (isDelimiter(currentChar)) {
            numberGenerator.isDelimiter(true);
        } else {
            throw new IllegalArgumentException("입력 값은 구분자와 양수로 구성된 문자열이어야합니다.");
        }
    }

    private void processCustomDelimiter() {
        customDelimiter.registerCustomDelimiter(input.substring(currentIndex), delimiter);
        currentIndex = input.indexOf("\\n", currentIndex) + 2;
    }

    private boolean isPositiveNumber(char ch) {
        return Character.isDigit(ch) && ch > '0';
    }

    private boolean isDelimiter(char ch) {
        return delimiter.isRegisteredDelimiter(ch);
    }

}
