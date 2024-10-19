package calculator;

public class DelimiterParser {

    private final StringBuilder sb = new StringBuilder();
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    // 내부에서 한번에 파싱하고, 계산까지 하도록 리팩토링? 어떤 구조가 더 좋은지 고민하기.
    public String findCustomDelimiter(String str) {

        while (str.contains(CUSTOM_DELIMITER_START)) {
            int start = str.indexOf(CUSTOM_DELIMITER_START);
            int end = str.indexOf(CUSTOM_DELIMITER_END);

            if (end == -1) {
                throw new IllegalArgumentException();
            }

            if (end < start) {
                throw new IllegalArgumentException();
            }

            sb.append(str, start + 2, end);
            str = str.substring(end + 2);
        }
        return sb.toString();
    }
}
