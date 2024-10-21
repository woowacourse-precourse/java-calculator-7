package calculator;

// 입력을 처리하고 구분자를 추출하는 클래스
public class InputProcessor {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private final String input;

    public InputProcessor(String input) {
        this.input = input;
    }

    public String[] processInput() {
        String delimiters = DEFAULT_DELIMITERS;
        String numberSection = input;

        if (hasCustomDelimiter()) {
            String customDelimiter = extractCustomDelimiter();
            delimiters = customDelimiter + "|" + delimiters;
            numberSection = extractNumbersSection();
        }

        return new NumberSplitter().splitNumbers(numberSection, delimiters);
    }

    public boolean hasCustomDelimiter() {
        return input.startsWith("//");
    }

    public String extractCustomDelimiter() {
        int delimiterEndIndex = findDelimiterEndIndex();
        String customDelimiter = input.substring(2, delimiterEndIndex);
        return escapeSpecialCharactersInDelimiter(customDelimiter);
    }

    public int findDelimiterEndIndex() {
        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 커스텀 구분자는 //과 \\n을 포함해야 합니다.");
        }
        return delimiterEndIndex;
    }

    public String extractNumbersSection() {
        int delimiterEndIndex = findDelimiterEndIndex();
        return input.substring(delimiterEndIndex + 2);
    }

    public String escapeSpecialCharactersInDelimiter(String delimiter) {
        return delimiter.replaceAll("([\\\\.^$|?*+()\\[\\]{}])", "\\\\$1");
    }
}
