package calculator;

// 입력을 처리하고 구분자를 추출하는 클래스
public class DelimiterParser {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private final String input;

    public DelimiterParser(String input) {
        this.input = input;
    }

    // 입력된 문자열에서 숫자를 구분자로 분리하여 배열로 반환하는 메서드
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

    // 커스텀 구분자의 끝 위치를 찾는 메서드. "\n"의 위치를 기준으로 함.
    public int findCustomDelimiterEndIndex() {
        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 커스텀 구분자는 //과 \\n을 포함해야 합니다.");
        }
        return delimiterEndIndex;
    }

    // 숫자 부분을 추출하는 메서드
    public String extractNumbersSection() {
        int delimiterEndIndex = findCustomDelimiterEndIndex();
        return input.substring(delimiterEndIndex + 2);
    }

    public String escapeSpecialCharacters(String delimiter) {
        return delimiter.replaceAll("([\\\\.^$|?*+()\\[\\]{}])", "\\\\$1");
    }
}
