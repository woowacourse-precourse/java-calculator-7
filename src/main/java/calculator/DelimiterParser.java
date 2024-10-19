package calculator;

public class DelimiterParser {

    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    // 내부에서 한번에 파싱하고, 계산까지 하도록 리팩토링? 어떤 구조가 더 좋은지 고민하기.
    public String findCustomDelimiter(String str) {
        StringBuilder sb = new StringBuilder();

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

    public String removeCustomDelimiterRegistrant(String str) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            int index = 0;
            int start = str.indexOf(CUSTOM_DELIMITER_START);
            int end = str.indexOf(CUSTOM_DELIMITER_END);

            if (start == -1 && end == -1) {
                sb.append(str, index, str.length());
                return sb.toString();
            }

            sb.append(str, index, start);
            sb.append(str, start + 2, start + 3);
            index = end + 2;
            str = str.substring(index);
        }
    }
}
