package calculator.delimiter;

public class Delimiter {
    private String del;
    private static final int CUSTOM_DEL_INDEX = 2;
    private static final String DEFAULT_DELIMITER = "[,:]";

    public Delimiter() {
        this.del = DEFAULT_DELIMITER;
    }

    public String getDel() {
        return del;
    }

    public String addCustomDelimiter(String input) {
        String customDelHeader = getCustomDelHeader(input);
        validateCustomDelHeader(customDelHeader);

        char customDel = customDelHeader.charAt(CUSTOM_DEL_INDEX);
        validateCustomDel(customDel);

        this.del = this.del.substring(0, 3) + customDel + "]";
        return input.length() == 5 ? "" : input.substring(5);
    }

    private String getCustomDelHeader(String input) {
        if (input.length() < 5) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return input.substring(0, 5);
    }

    private void validateCustomDelHeader(String customDelHeader) {
        if (!customDelHeader.endsWith("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 설정은 \\n 으로 끝나야합니다.");
        }
    }

    private void validateCustomDel(char customDel) {
        if (isDefaultDel(customDel)) {
            throw new IllegalArgumentException("기본 구분자와 중복되는 커스텀 구분자입니다.");
        }
    }

    private boolean isDefaultDel(char customDel) {
        return customDel == ':' || customDel == ',';
    }
}
