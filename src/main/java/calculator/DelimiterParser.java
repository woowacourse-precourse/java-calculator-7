package calculator;

// 입력을 처리하고 구분자를 추출하는 클래스
public class DelimiterParser {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private final String input;

    public DelimiterParser(String input) {
        this.input = input;
    }

    public String[] parseNumbers() {
        String delimiters = DEFAULT_DELIMITERS;
        String numberSection = input;

        if (hasCustomDelimiter()) {
            String customDelimiter = extractCustomDelimiter();
            delimiters = customDelimiter + "|" + delimiters;
            numberSection = extractNumbersSection();
        }

        return new NumberExtractor().splitNumbers(numberSection, delimiters);
    }

    public boolean hasCustomDelimiter() {
        return input.startsWith("//");
    }

    public String extractCustomDelimiter() {
        int delimiterEndIndex = findCustomDelimiterEndIndex();
        String customDelimiter = input.substring(2, delimiterEndIndex);
        return escapeSpecialCharacters(customDelimiter);
    }

    public int findCustomDelimiterEndIndex() {
        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 커스텀 구분자는 //과 \\n을 포함해야 합니다.");
        }
        return delimiterEndIndex;
    }

    public String extractNumbersSection() {
        int delimiterEndIndex = findCustomDelimiterEndIndex();
        return input.substring(delimiterEndIndex + 2);
    }

    public String escapeSpecialCharacters(String delimiter) {
        return delimiter.replaceAll("([\\\\.^$|?*+()\\[\\]{}])", "\\\\$1");
    }
}
