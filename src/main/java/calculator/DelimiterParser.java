package calculator;

public class DelimiterParser {

    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    
    public String findCustomDelimiter(String str) {
        StringBuilder sb = new StringBuilder();

        while (str.contains(CUSTOM_DELIMITER_START)) {
            int start = str.indexOf(CUSTOM_DELIMITER_START);
            int end = str.indexOf(CUSTOM_DELIMITER_END);

            validEndDelimiterExist(end);

            validDelimiterFormat(start, end);

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

            // 커스텀 구분자를 추가하는 부분이 없으면 모두 StringBuilder 객체에 추가함
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

    private void validDelimiterFormat(int start, int end) {
        if (end < start) {
            throw new IllegalArgumentException();
        }
    }

    private void validEndDelimiterExist(int end) {
        if (end == -1) {
            throw new IllegalArgumentException();
        }
    }
}
